package com.xufq.common.exception;

import com.xufq.sys.constants.SysResultEnums;

public class BusinessException extends RuntimeException {

	private String code;

	private String message;

	public BusinessException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public BusinessException(SysResultEnums sysResultEnum) {
		this.code = sysResultEnum.getCode();
		this.message = sysResultEnum.getMsg();
	}
}
