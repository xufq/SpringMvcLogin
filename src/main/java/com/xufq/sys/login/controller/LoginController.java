/**
 * 
 */
package com.xufq.sys.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xufq.common.annotation.ControllerLog;
import com.xufq.common.constants.CommonConstants;
import com.xufq.common.result.Result;
import com.xufq.common.utils.SessionUtil;
import com.xufq.sys.login.entity.UserInfo;
import com.xufq.sys.login.service.LoginServiceImpl;
import com.xufq.sys.login.vo.LoginVO;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;

	@PostMapping("/login")
	@ControllerLog(requestUrl = "/login")
	public Result login(@RequestBody LoginVO userInfoVO, HttpServletResponse response) {

		UserInfo userInfo = loginService.selectUserInfo(userInfoVO.getUserId());
		Result result = new Result();
		// 登录验证
		if (userInfo != null && StringUtils.equals(userInfo.getPassword(), userInfoVO.getPassword())) {
			SessionUtil.setUserInfo(userInfo);
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@GetMapping("/user")
	@ControllerLog(requestUrl = "/user")
	public Result getPassword(HttpServletRequest request, @RequestParam("userId") String userId) {
		Result result = new Result();
		UserInfo userInfo = loginService.selectUserInfo(userId);
		if (userInfo != null) {
			result.setSuccess(true);
			request.getSession().setAttribute(CommonConstants.SESSION_KEY_USERINFO, userInfo);
		} else {
			result.setSuccess(false);
		}
		return result;
	}
}
