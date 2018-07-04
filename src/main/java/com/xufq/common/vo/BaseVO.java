/**
 * 
 */
package com.xufq.common.vo;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class BaseVO implements Serializable {
	private final static long serialVersionUID = 1L;
	
	private int page;
	
	private int limit;

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
