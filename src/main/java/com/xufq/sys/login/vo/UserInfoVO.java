/**
 * 
 */
package com.xufq.sys.login.vo;

import com.xufq.common.vo.BaseVO;

/**
 * @author Administrator
 *
 */
public class UserInfoVO extends BaseVO {

	private String userId;
	
	private String password;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
