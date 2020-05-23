package com.waves.springsec.dto;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class UserDto {
	private int userId;
	private String userName;
	private String password;
	private boolean enabledYN;
	private List<GrantedAuthority> grantedAuthorities;

	
	
	public UserDto(int userId, String userName, String password, boolean enabledYN,
			List<GrantedAuthority> grantedAuthorities) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.enabledYN = enabledYN;
		this.grantedAuthorities = grantedAuthorities;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabledYN() {
		return enabledYN;
	}

	public void setEnabledYN(boolean enabledYN) {
		this.enabledYN = enabledYN;
	}

	public List<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}
	
}
