package com.xufq.sys.menu.bo;

import com.xufq.common.bo.BaseBO;

public class MenuItemBO extends BaseBO{

	private int itemIndex;
	
	private String itemName;
	
	private String itemUrl;

	/**
	 * @return the itemIndex
	 */
	public int getItemIndex() {
		return itemIndex;
	}

	/**
	 * @param itemIndex the itemIndex to set
	 */
	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemUrl
	 */
	public String getItemUrl() {
		return itemUrl;
	}

	/**
	 * @param itemUrl the itemUrl to set
	 */
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	
}
