package com.xufq.sys.menu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xufq.common.result.Result;
import com.xufq.sys.menu.bo.MenuItemBO;
import com.xufq.sys.menu.bo.SubMenuBO;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@GetMapping("/menulist")
	public Result<List<SubMenuBO>> selectMenuList(HttpServletRequest request) {
		Result result = new Result();
		List<SubMenuBO> subMenuList = new ArrayList();
		SubMenuBO subMenu = new SubMenuBO();
		subMenu.setSubIndex(1);
		subMenu.setSubName("统计分析");
		List<MenuItemBO> menuItemList = new ArrayList();
		MenuItemBO menuItem = new MenuItemBO();
		menuItem.setItemIndex(1);
		menuItem.setItemName("新增和启动");
		menuItem.setItemUrl("http://www.baidu.com");
		menuItemList.add(menuItem);
		subMenu.setMenuItemList(menuItemList);
		subMenuList.add(subMenu);
		result.bindSuccessInfo("aaa", subMenuList);
		return result;
	}
}
