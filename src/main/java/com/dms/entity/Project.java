package com.dms.entity;

public class Project {
 
	private Integer pro_id;
	private String  pro_name;
	private MyUser myUser;
	private Integer manage_id;
	private String  pro_details;
	public Integer getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public MyUser getMyUser() {
		return myUser;
	}
	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}
	public Integer getManage_id() {
		return manage_id;
	}
	public void setManage_id(Integer manage_id) {
		this.manage_id = manage_id;
	}
	public String getPro_details() {
		return pro_details;
	}
	public void setPro_details(String pro_details) {
		this.pro_details = pro_details;
	}
	
	@Override
	public String toString()
	{
		return "[ Project: Pro_name"+pro_name+"Pro_detatils"+pro_name+"manage"+myUser+"]";
	}
	
}
