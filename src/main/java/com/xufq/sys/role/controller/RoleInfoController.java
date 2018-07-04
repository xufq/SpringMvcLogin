package com.xufq.sys.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.xufq.common.result.Result;
import com.xufq.sys.constants.SysResultEnums;
import com.xufq.sys.role.bo.RoleInfoBo;
import com.xufq.sys.role.service.RoleInfoServiceImpl;
import com.xufq.sys.role.vo.QueryRoleInfoListVo;
import com.xufq.sys.role.vo.QueryRoleInfoVo;
import com.xufq.sys.role.vo.UpdateRoleInfoVo;

@RestController
@RequestMapping("/sys/role")
public class RoleInfoController {

	/**
	 * 角色接口
	 */
	@Autowired
	private RoleInfoServiceImpl service;

	/**
	 * 检索角色列表
	 * 
	 * @param param
	 *            用户名
	 * @return 角色列表
	 */
	@GetMapping("/rolelist")
	public Result<List<RoleInfoBo>> selectRoleInfoList(QueryRoleInfoListVo param) {

		List<RoleInfoBo> roleInfoList = service.selectRoleInfoList(param);
		Result<List<RoleInfoBo>> result = new Result<>();
		result.bindSuccessInfo("", roleInfoList);
		result.setTotal(((Page<RoleInfoBo>) roleInfoList).getTotal());
		return result;
	}

	/**
	 * 检索角色信息
	 * 
	 * @param param
	 *            角色ID
	 * @return 角色列表
	 */
	@GetMapping("/roleinfo")
	public Result<RoleInfoBo> selectRoleInfo(QueryRoleInfoVo param) {

		RoleInfoBo roleInfo = service.selectRoleInfo(param);
		Result<RoleInfoBo> result = new Result<>();
		if (roleInfo != null) {
			result.bindSuccessInfo("", roleInfo);
		} else {
			result.bindErrorInfo(SysResultEnums.SYS_ROLE_ERRROR_0001.getMsg());
		}
		return result;
	}

	/**
	 * 更新角色信息
	 * @param param 角色信息
	 * @return 更新结果
	 */
	@PostMapping("/roleinfo")
	public Result<String> updateRoleInfo(@RequestBody UpdateRoleInfoVo param) {
		int updateCount = service.updateRoleInfo(param);
		Result<String> result = new Result<>();
		if (updateCount > 0) {
			result.setSuccess(true);
		} else {
			result.bindErrorInfo(SysResultEnums.SYS_ROLE_ERRROR_0002.getMsg());
		}
		return result;
	}
}
