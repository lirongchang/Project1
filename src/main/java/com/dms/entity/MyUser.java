package com.dms.entity;

import java.text.DecimalFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyUser {
	private int id;

	@JsonProperty("name")
	@NotNull(message = "账户名不能为空！")
	@Size(min = 11, max = 11, message = "账户名只能是11位！")
	private String name;

	@JsonProperty("password")
	@NotNull(message = "密码不能为空！")
	@Size(min = 6, max = 12, message = "密码范围 (6,12)！")
	private String password;
   
	/**
	 * 得到用户id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置用户id
	 * 
	 * @return
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 得到用户名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置用户名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 得到密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 登录系统账号*/
	private String Email; 
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	/**
	 * 用户角色*/
	private int role;
	
	/**
	 * 用户状态，1为可用，0 为禁用*/
	public int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
