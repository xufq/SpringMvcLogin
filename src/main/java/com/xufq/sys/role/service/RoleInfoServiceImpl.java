package com.xufq.sys.role.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.xufq.common.utils.SessionUtil;
import com.xufq.common.utils.UUIDUtil;
import com.xufq.sys.role.bo.RoleInfoBo;
import com.xufq.sys.role.dao.RoleInfoMapper;
import com.xufq.sys.role.entity.RoleInfo;
import com.xufq.sys.role.vo.InsertRoleInfoVo;
import com.xufq.sys.role.vo.QueryRoleInfoListVo;
import com.xufq.sys.role.vo.QueryRoleInfoVo;
import com.xufq.sys.role.vo.UpdateRoleInfoVo;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleInfoServiceImpl {

	@Autowired
	private RoleInfoMapper mapper;

	/**
	 * 检索角色列表
	 * @param param 用户名
	 * @return 角色列表
	 */
	public List<RoleInfoBo> selectRoleInfoList(QueryRoleInfoListVo param) {
		PageHelper.startPage(param.getPage(), param.getLimit());
		return mapper.selectRoleInfoList(param);
	}
	
	/**
	 * 检索角色信息
	 * @param param 角色ID
	 * @return 角色信息
	 */
	public RoleInfoBo selectRoleInfo(QueryRoleInfoVo param) {
		return mapper.selectRoleInfo(param);
	}

	/**
	 * 插入角色信息
	 * @param param
	 * @return
	 */
	public int insertRoleInfo(InsertRoleInfoVo param) {

		// 拷贝roleid和rolename
		RoleInfo roleInfo = new RoleInfo();
		BeanUtils.copyProperties(param, roleInfo);

		roleInfo.setId(UUIDUtil.getUUID(true));
		setEntityCreateInfo(roleInfo);
		return mapper.insertSelective(roleInfo);
	}
	
	/**
	 * 更新角色信息
	 * @param param
	 * @return
	 */
	public int updateRoleInfo(UpdateRoleInfoVo param) {
		// 拷贝roleid和rolename
		RoleInfo roleInfo = new RoleInfo();
		BeanUtils.copyProperties(param, roleInfo);
		
		setEntityUpdateInfo(roleInfo);
		return mapper.updateByPrimaryKeySelective(roleInfo);
	}

	private void setEntityCreateInfo(RoleInfo roleInfo) {
		roleInfo.setCreateDate(new Date());
		roleInfo.setCreateUser(SessionUtil.getUserInfo().getUserId());
	}

	private void setEntityUpdateInfo(RoleInfo roleInfo) {
		roleInfo.setUpdateDate(new Date());
		roleInfo.setUpdateUser(SessionUtil.getUserInfo().getUserId());
	}
}
