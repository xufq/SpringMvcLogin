package com.xufq.sys.menu.bo;

import java.util.Date;

import com.xufq.common.bo.BaseBO;

public class MenuInfoBo extends BaseBO {
	private String id;

    private int menuId;
    
    private int parentMenuId;

    private String menuName;

    private String menuUrl;

    private Integer deleteFlag;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    /**
	 * @return the parentMenuId
	 */
	public int getParentMenuId() {
		return parentMenuId;
	}

	/**
	 * @param parentMenuId the parentMenuId to set
	 */
	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
