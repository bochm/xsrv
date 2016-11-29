package cn.bx.system.security;

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
import org.apache.shiro.util.ByteSource;

import cn.bx.bframe.common.security.Digests;
import cn.bx.bframe.common.security.PasswordUtil;
import cn.bx.system.entity.User;
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
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //根据用户名查找角色，请根据需求实现
        String username = (String) principals.getPrimaryPrincipal();
        System.out.println("username="+username);
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        authorizationInfo.addRole("rs-service");
        return authorizationInfo;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        RsUserToken uToken = (RsUserToken) token;
        String username = uToken.getUsername();
        if(uToken.isLogin()){
        	User user = systemService.findUserByLoginName(username);
        	if(user == null || user.getPassword() == null) throw new AuthenticationException();
        	return new SimpleAuthenticationInfo(user,PasswordUtil.decryptPassword(user.getPassword()),
                    ByteSource.Util.bytes(PasswordUtil.decryptSalt(user.getPassword())),getName());
        }else{
        	//从缓存中得到用户
        	User user = UserUtils.getUserByLoginName(username);
        	//令牌过期,按缓存过期时间设置
        	if(user == null || user.getRsToken() == null) throw new ExpiredCredentialsException();
        	String key = user.getRsToken();//缓存密钥（和客户端的一样）
        	//然后进行客户端消息摘要和服务器端消息摘要的匹配
        	System.out.println("------"+generateToken(key,uToken));
        	System.out.println("------"+uToken.getClientToken());
        	System.out.println("------"+uToken.getRequestUrl());
            return new SimpleAuthenticationInfo(user,generateToken(key,uToken),getName());
        }
        
    }
    protected String generateToken(String key,RsUserToken uToken){
    	return Digests.hex_hmac_sha256(key, uToken.getRequestUrl());//在服务器端生成客户端参数消息摘要
    }
}

