/**
 * 
 */
package com.xufq.sys.result;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class Result<T> {

	// 成功与否
	private boolean success;

	// 消息
	private String msg;

	// 单条数据
	private T data;

	// 多条数据
	private List<T> list;

	/**
	 * 绑定成功消息
	 * 
	 * @param msg
	 *            成功消息
	 */
	public void bindSuccessInfo(String msg) {
		this.setSuccess(true);
		this.setMsg(msg);

	}

	/**
	 * 绑定成功消息
	 * 
	 * @param msg
	 *            成功消息
	 * @param data
	 *            返回的BO
	 */
	public void bindSuccessInfo(String msg, T data) {
		this.setSuccess(true);
		this.setMsg(msg);
		this.setData(data);
	}

	/**
	 * 绑定成功消息
	 * 
	 * @param msg
	 *            成功消息
	 * @param list
	 *            返回的BO
	 */
	public void bindSuccessInfo(String msg, List<T> list) {
		this.setSuccess(true);
		this.setMsg(msg);
		this.setList(list);
	}

	/**
	 * 绑定失败消息
	 * 
	 * @param msg
	 *            失败消息
	 */
	public void bindErrorInfo(String msg) {
		this.setSuccess(false);
		this.setMsg(msg);
	}

	/**
	 * 绑定失败消息
	 * 
	 * @param msg
	 *            失败消息
	 * @param data
	 *            返回的BO
	 */
	public void bindErrorInfo(String msg, T data) {
		this.setSuccess(false);
		this.setMsg(msg);
		this.setData(data);
	}

	/**
	 * 绑定失败消息
	 * 
	 * @param msg
	 *            失败消息
	 * @param list
	 *            返回的BO
	 */
	public void bindErrorInfo(String msg, List<T> list) {
		this.setSuccess(false);
		this.setMsg(msg);
		this.setList(list);
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

}
