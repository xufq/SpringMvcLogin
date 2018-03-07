/**
 * 
 */
package com.xufq.sys.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xufq.sys.login.vo.UserInfoVO;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@PostMapping("/login")
	public String login(UserInfoVO userInfoVO) {
		// 用户名密码验证
		if(!"admin".equals(userInfoVO.getUserId()) || !"admin".equals(userInfoVO.getPassword())) {
			return "redirect:/error.html";
		}
		return "redirect:/index.html";
	}
}
