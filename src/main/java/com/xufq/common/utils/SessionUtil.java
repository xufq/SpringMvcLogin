package com.xufq.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xufq.common.constants.CommonConstants;
import com.xufq.sys.login.entity.UserInfo;

public class SessionUtil {

	public static UserInfo getUserInfo() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(false);
		if(session == null) {
			throw new RuntimeException("");
		}
		return (UserInfo)session.getAttribute(CommonConstants.SESSION_KEY_USERINFO);
	}
	
	public static void setUserInfo(UserInfo userInfo) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(true);
		session.setAttribute(CommonConstants.SESSION_KEY_USERINFO, userInfo);
	}
}
