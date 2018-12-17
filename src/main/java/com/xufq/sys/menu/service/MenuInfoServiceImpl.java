package com.xufq.sys.menu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xufq.common.exception.BusinessException;
import com.xufq.sys.constants.SysResultEnums;
import com.xufq.sys.menu.bo.MenuInfoBo;
import com.xufq.sys.menu.bo.MenuItemBO;
import com.xufq.sys.menu.bo.SubMenuBO;
import com.xufq.sys.menu.dao.MenuInfoMapper;
import com.xufq.sys.menu.vo.MenuInfoSelectListVo;

@Service
@Transactional(rollbackFor = Exception.class)
public class MenuInfoServiceImpl {

	@Autowired
	private MenuInfoMapper dao;

	/**
	 * 检索menu信息
	 */
	public List<SubMenuBO> selectMenuList() {
		List<MenuInfoBo> list = dao.selectMenuList();
		return makeSubMenu(list);
	}
	
	/**
	 * 检索menu列表 
	 */
	public Page<MenuInfoBo> queryList(MenuInfoSelectListVo param){
		PageHelper.startPage(param.getPage(), param.getLimit());
		return (Page)dao.selectMenuList();
	}
	

	/**
	 * 整理menu列表
	 */
	private List<SubMenuBO> makeSubMenu(List<MenuInfoBo> list) {
		if (!CollectionUtils.isEmpty(list)) {
			List<SubMenuBO> subMenuList = new ArrayList();
			
             Map<Integer,List<MenuInfoBo>> groupMap = list.stream().collect(Collectors.groupingBy(MenuInfoBo::getParentMenuId));
             for(Map.Entry<Integer, List<MenuInfoBo>> entry : groupMap.entrySet()) {
            	 List<MenuInfoBo> itemList = entry.getValue();
            	 
            	 SubMenuBO subMenu = new SubMenuBO();
      			List<MenuItemBO> menuItemList = new ArrayList();
     			for(int i =0; i<itemList.size(); i++) {
     				MenuInfoBo menuInfo = itemList.get(i);
     				if(i ==0) {
     	     			subMenu.setSubIndex(menuInfo.getMenuId());
     	     			subMenu.setSubName(menuInfo.getMenuName());
     				} else {
     					MenuItemBO menuItem = new MenuItemBO();
     	     			menuItem.setItemIndex(menuInfo.getMenuId());
     	     			menuItem.setItemName(menuInfo.getMenuName());
     	     			menuItem.setItemUrl(menuInfo.getMenuUrl());
     	     			menuItemList.add(menuItem);
     	     			subMenu.setMenuItemList(menuItemList);
     				}
     			}     			
     			subMenuList.add(subMenu);
             }
             return subMenuList;
		}
		throw new BusinessException(SysResultEnums.ERROR);
	}
}
