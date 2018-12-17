package com.xufq.sys.menu.dao;

import java.util.List;

import com.xufq.sys.menu.bo.MenuInfoBo;
import com.xufq.sys.menu.entity.MenuInfo;

public interface MenuInfoMapper {
	
	List<MenuInfoBo> selectMenuList();
	
    int deleteByPrimaryKey(String id);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    MenuInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);
}