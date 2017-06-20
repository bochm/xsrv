package cn.bx.system.security;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.AccessControlFilter;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.bframe.json.JsonMapper;
import cn.bx.system.utils.RsSysConstants;


public class RsAuthcFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    	//限定请求只能是HTTP
    	HttpServletRequest httpRequest = (HttpServletRequest)request;
    	if("OPTIONS".equals(httpRequest.getMethod())) return true;
    	//客户端传入用户名,登录请求时
    	String username = httpRequest.getHeader(RsSysConstants.RS_PARAM_USERNAME);
    	//客户端传入密码,登录请求时
    	String password = httpRequest.getHeader(RsSysConstants.RS_PARAM_PASSWORD);
    	//客户端传入的令牌
    	String cToken = httpRequest.getHeader(RsSysConstants.RS_PARAM_TOKEN);
    	//客户端请求URL
    	String requestUrl = getRequestUrl(httpRequest);
    	//验证Token
    	RsUserToken token = null;
    	//客户端提交的令牌,非登录请求
    	
    	if(!StringUtils.isEmpty(cToken)){
    		username = httpRequest.getHeader(RsSysConstants.RS_PARAM_USERNAME);
    		token = new RsUserToken(username);
    		token.setClientToken(cToken);
    		token.setRequestUrl(requestUrl);
    	}//客户端提交的密码,登录请求
    	else if(!StringUtils.isEmpty(password) && !StringUtils.isEmpty(username)){
    		token = new RsUserToken(username,httpRequest.getHeader(RsSysConstants.RS_PARAM_PASSWORD));
    	}
    	else{
    		onRequestFail(response,"未授权访问");
            return false;
    	}
    	token.setRemoteIP(getRemoteAddr((HttpServletRequest)request));
        try {
            //委托给Realm进行登录
            getSubject(request, response).login(token);
            //((HttpServletResponse)response).setHeader(Constants.RS_RESP_TOKEN, ShiroCacheUtils.getToken(username));
        }catch(ExcessiveAttemptsException eae){
        	onRequestFail(response,"登录次数超限");
        	return false;
        }catch(ExpiredCredentialsException ece){
        	onRequestFail(response,"会话过期");
            return false;
        }catch(AuthenticationException ace){
        	ace.printStackTrace();
        	onRequestFail(response,"授权验证失败");
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            onRequestFail(response,"授权验证异常");
            return false;
        }
        return true;
    }

    //验证失败默认返回401状态码,目前使用json格式返回,后续可以考虑配置的方式返回不同格式错误
    private void onRequestFail(ServletResponse response,String msg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, msg);
        
        
        httpResponse.reset();
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("utf-8");
        httpResponse.getWriter().print(JsonMapper.toJsonString(new DataMessage(msg,null,HttpServletResponse.SC_UNAUTHORIZED)));
    }
    
    private String getRemoteAddr(HttpServletRequest request){
		String remoteAddr = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}
    private String getRequestUrl(HttpServletRequest request){
		return request.getRequestURI();
	}
}

