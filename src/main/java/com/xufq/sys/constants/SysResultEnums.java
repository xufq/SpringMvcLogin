package com.xufq.sys.constants;

public enum SysResultEnums {

	SUCCESS("0", ""), 
	ERROR("-1", "系统异常，请联系管理员"),
	
	SYS_ROLE_ERRROR_0001("ERROR0001", "该角色不存在！"),
	SYS_ROLE_ERRROR_0002("ERROR0002", "该角色信息更新失败！"),
	
	
	
	
	
	;

	private SysResultEnums(String code, String msg) {
		this.code = code;
		this.msg = msg;
	};

	private String code;

	private String msg;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return this.code + ":" + this.msg;
	}

}
