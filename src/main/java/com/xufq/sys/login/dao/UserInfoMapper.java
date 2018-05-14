package com.xufq.sys.login.dao;

import com.xufq.sys.login.entity.UserInfo;
import com.xufq.sys.login.vo.UserInfoVO;

public interface UserInfoMapper {
	UserInfo selectUserInfo(UserInfoVO param);
}