package com.xufq.common.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xufq.common.constants.CommonConstants;
import com.xufq.sys.login.entity.UserInfo;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  
            Object handler) throws Exception {
		
		String url = request.getRequestURI();
		// 登录页面不需要拦截
		if(StringUtils.isNotEmpty(url) &&  url.contains("/login")) {
			return true;
		} else {
			HttpSession session = request.getSession(false);
			if(session == null) {
				response.getWriter().print("logout");
				return false;
			}
			UserInfo userInfo = (UserInfo) session.getAttribute(CommonConstants.SESSION_KEY_USERINFO);
			if(userInfo != null) {
				return true;
			}else {
				response.sendRedirect(request.getContextPath()+"/login.html");
				return false;
			}
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession(false);
		Cookie cookie = new Cookie("name_test",session.getId());//创建新cookie
        cookie.setMaxAge(5 * 60);// 设置存在时间为5分钟
        cookie.setPath("/");//设置作用域
        response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端
	}
	
}
