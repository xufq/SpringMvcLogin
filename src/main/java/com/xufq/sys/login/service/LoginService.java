package com.xufq.sys.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xufq.sys.login.dao.UserInfoMapper;
import com.xufq.sys.login.entity.UserInfo;
import com.xufq.sys.login.vo.UserInfoVO;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	/**
	 * 查询用户
	 * 
	 * @param userId
	 * @return
	 */
	public UserInfo selectUserInfo(String userId) {
		UserInfoVO param = new UserInfoVO();
		param.setUserId(userId);
		return userInfoMapper.selectUserInfo(param);
	}
}
