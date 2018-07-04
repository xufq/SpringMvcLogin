package com.xufq.sys.role.dao;

import java.util.List;

import com.xufq.sys.role.bo.RoleInfoBo;
import com.xufq.sys.role.entity.RoleInfo;
import com.xufq.sys.role.vo.QueryRoleInfoListVo;
import com.xufq.sys.role.vo.QueryRoleInfoVo;

public interface RoleInfoMapper {
	
	List<RoleInfoBo> selectRoleInfoList(QueryRoleInfoListVo param);
	
	RoleInfoBo selectRoleInfo(QueryRoleInfoVo param);
	
    int deleteByPrimaryKey(String id);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);
}