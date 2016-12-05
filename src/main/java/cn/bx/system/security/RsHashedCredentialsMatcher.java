package cn.bx.system.security;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import cn.bx.bframe.common.security.PasswordUtil;
import cn.bx.system.utils.UserUtils;

public class RsHashedCredentialsMatcher extends HashedCredentialsMatcher {
    private Cache<String, AtomicInteger> passwordRetryCache;
    //private Cache<String,String> credentialsCache;
    public RsHashedCredentialsMatcher(CacheManager cacheManager) {
    	//ehcache-shiro-rs.xml中定义的名称
        passwordRetryCache = cacheManager.getCache(UserUtils.PWD_RETRY_CACHE);
    }

    @SuppressWarnings("unchecked")
	@Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    	RsUserToken uToken = (RsUserToken) token;
    	boolean matches = false;
    	String username = (String)token.getPrincipal();
    	if(uToken.isLogin()){//登录服务不能连续五次失败
            AtomicInteger retryCount = passwordRetryCache.get(username);
            if(retryCount == null) {
                retryCount = new AtomicInteger(0);
                passwordRetryCache.put(username, retryCount);
            }
            if(retryCount.incrementAndGet() > 5) { //密码重试次数大于5次
                throw new ExcessiveAttemptsException();
            }
            matches = super.doCredentialsMatch(token, info);
            if(matches) {
                passwordRetryCache.remove(username);
                //生成随机的16位salt并经过1024次 sha-1 hash迭代的token
				Map<String,String> user = (Map<String,String>)info.getPrincipals().getPrimaryPrincipal();
				UserUtils.setToken(user, PasswordUtil.entryptPassword(uToken.getPassword()));
                UserUtils.putUserInCache(user);
            }
    	}else{

    		String credentials = (String)info.getCredentials();
    		matches = credentials.equals((String)token.getCredentials());
    		//每次请求的令牌不能一样
    		/*if(matches) {
    			if(credentials.equals(credentialsCache.get(username))){
                    throw new ExcessiveAttemptsException();
    			}
    			credentialsCache.put(username, credentials);
            }*/
    	}
        return matches;
    }
}