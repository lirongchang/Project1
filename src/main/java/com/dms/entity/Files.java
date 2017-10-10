package com.dms.entity;

import java.io.Serializable;

public class Files implements Serializable{

	private Integer file_id;
	
	private Integer bug_id;
	
	private String  file_name;
	
	private Integer user_id;

	public Integer getFile_id() {
		return file_id;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}

	public Integer getBug_id() {
		return bug_id;
	}

	public void setBug_id(Integer bug_id) {
		this.bug_id = bug_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	} 
	@Override
	public String toString()
	{
		return  "[ file: file_id"+file_id+"file_name:"+file_name+"bug_id"+bug_id+"user_id"+user_id;
	}
	
	
	
	
}
