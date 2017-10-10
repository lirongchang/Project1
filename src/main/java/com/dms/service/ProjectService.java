package com.dms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Project;

public interface ProjectService {

	
	/**
	 * 根据id 查询 project*/
	public  Project selectById(@Param("pro_id") Integer pro_id);
	
	
	/**
	 * 根据name 查询 project*/
	public  Project selectByName(@Param("pro_name") String pro_name);
	
	/**
	 * 根据id删除*/
 	
	public void deleteById(int id);
	
	public void insertProject(Project project);
	
	public void updateProject(Project project);
	
	public List<Project> projectlist();
}
