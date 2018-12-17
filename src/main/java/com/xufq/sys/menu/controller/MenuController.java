package com.xufq.sys.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.xufq.common.result.Result;
import com.xufq.sys.menu.bo.MenuInfoBo;
import com.xufq.sys.menu.bo.SubMenuBO;
import com.xufq.sys.menu.service.MenuInfoServiceImpl;
import com.xufq.sys.menu.vo.MenuInfoSelectListVo;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuInfoServiceImpl service;
	
	@GetMapping("/menulist")
	public Result<List<SubMenuBO>> selectMenuList() {
		Result<List<SubMenuBO>> result = new Result();
		List<SubMenuBO> subMenuList = service.selectMenuList();
		result.bindSuccessInfo("aaa", subMenuList);
		return result;
	}
	
	@GetMapping("/list")
	public Result<List<MenuInfoBo>> list(MenuInfoSelectListVo param){
		Result<List<MenuInfoBo>> result = new Result();
		Page<MenuInfoBo> list = service.queryList(param);
		result.bindSuccessInfo("aaa", list);
		result.setTotal(list.getTotal());
		return result;
	}
}
