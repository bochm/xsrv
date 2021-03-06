package cn.bx.system.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.bx.bframe.common.security.Digests;
import cn.bx.system.service.SystemService;
import cn.bx.system.utils.UserUtils;

public class RsAuthRealm extends AuthorizingRealm {
	@Resource(name="SystemService")
    private SystemService systemService;
    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持RsUserToken类型的Token
        return token instanceof RsUserToken;
    }
    @SuppressWarnings("unchecked")
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //根据用户名查找角色，请根据需求实现
    	Map<String,String> user = (Map<String,String>)principals.getPrimaryPrincipal();
    	String userId = UserUtils.getUserId(user);
    	System.out.println("AOP检测权限============================"+userId);
        Set<String> roles = UserUtils.getRoleFromCache();
        Set<String> permissions = UserUtils.getPermissionFromCache();
        if(roles == null){
        	roles = systemService.queryRolesByUserId(userId);
        	UserUtils.putRoleInCache(userId, roles);
        }
        if(permissions == null){
        	permissions = systemService.queryPermissionsByUserId(userId);
        	UserUtils.putPermissionInCache(UserUtils.getUserId(user), permissions);
        }
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        RsUserToken uToken = (RsUserToken) token;
        String username = uToken.getUsername();
        if(uToken.isLogin()){
        	HashMap<String,String> user = systemService.findUserByLoginName(username);
        	if(user == null || UserUtils.getPassword(user) == null) throw new AuthenticationException();
        	return new SimpleAuthenticationInfo(user,UserUtils.getPassword(user),getName());
        	/*return new SimpleAuthenticationInfo(user,PasswordUtil.decryptPassword(UserUtils.getPassword(user)),
                    ByteSource.Util.bytes(PasswordUtil.decryptSalt(UserUtils.getPassword(user))),getName());*/
        }else{
        	//从缓存中得到用户
        	HashMap<String,String> user = UserUtils.getUserByLoginName(username);
        	//令牌过期,按缓存过期时间设置
        	if(user == null || UserUtils.getToken(user) == null) throw new ExpiredCredentialsException();
        	String key = UserUtils.getToken(user);//缓存密钥（和客户端的一样）
        	//然后进行客户端消息摘要和服务器端消息摘要的匹配
            return new SimpleAuthenticationInfo(user,generateToken(key,uToken),getName());
        }
        
    }
    protected String generateToken(String key,RsUserToken uToken){
    	return Digests.hex_hmac_sha256(key, uToken.getRequestUrl());//在服务器端生成客户端参数消息摘要
    }
}

