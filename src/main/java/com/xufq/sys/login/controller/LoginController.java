/**
 * 
 */
package com.xufq.sys.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xufq.common.annotation.ControllerLog;
import com.xufq.sys.login.vo.UserInfoVO;
import com.xufq.sys.result.Result;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	@PostMapping("/login")
	@ControllerLog(requestUrl = "/login")
	public Result login(@RequestBody UserInfoVO userInfoVO) {
		Result result = new Result();
		// 登录验证
		if ("admin".equals(userInfoVO.getUserId()) && "admin".equals(userInfoVO.getPassword())) {
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
		return result;
	}
}
