package com.laptrinhjavaweb.dto;

import com.laptrinhjavaweb.entity.RolesEntity;

public class UserDTO extends AbstractDTO<UserDTO> {
	
	private String fullName;
	private String userName;
	private String password;
	private Integer status;
	private Long roleId;
	private RolesEntity role;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public RolesEntity getRole() {
		return role;
	}
	public void setRole(RolesEntity role) {
		this.role = role;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
