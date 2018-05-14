package com.xufq.sys.menu.bo;

import java.util.List;

import com.xufq.common.bo.BaseBO;

public class SubMenuBO extends BaseBO {
    private int subIndex;
    
    private String subName;
    
    private List<MenuItemBO> menuItemList;

	/**
	 * @return the subIndex
	 */
	public int getSubIndex() {
		return subIndex;
	}

	/**
	 * @param subIndex the subIndex to set
	 */
	public void setSubIndex(int subIndex) {
		this.subIndex = subIndex;
	}

	/**
	 * @return the subName
	 */
	public String getSubName() {
		return subName;
	}

	/**
	 * @param subName the subName to set
	 */
	public void setSubName(String subName) {
		this.subName = subName;
	}

	/**
	 * @return the menuItemList
	 */
	public List<MenuItemBO> getMenuItemList() {
		return menuItemList;
	}

	/**
	 * @param menuItemList the menuItemList to set
	 */
	public void setMenuItemList(List<MenuItemBO> menuItemList) {
		this.menuItemList = menuItemList;
	}
    
}
