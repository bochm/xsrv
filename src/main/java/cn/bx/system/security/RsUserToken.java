package cn.bx.system.security;

import org.apache.shiro.authc.AuthenticationToken;

public class RsUserToken implements AuthenticationToken {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
    private String clientToken;
    private String remoteIP;
    private String requestUrl;
    private boolean isLogin;
    public RsUserToken(String username) {
        this.username = username;
    }
    public RsUserToken(String username,String password) {
        this.username = username;
        this.password = password;
        this.isLogin = true;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public String getRemoteIP() {
		return remoteIP;
	}
	public void setRemoteIP(String remoteIP) {
		this.remoteIP = remoteIP;
	}
	@Override
    public Object getPrincipal() {
       return username;
    }

    @Override
    public Object getCredentials() {
        return isLogin() ? username+password : clientToken;
    }
}

