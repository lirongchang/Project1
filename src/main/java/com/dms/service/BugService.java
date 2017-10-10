package com.dms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Bug;

public interface BugService {

	/**
	 * 根据id 查询 Bug*/
	public  Bug selectById(@Param("bug_id") Integer bug_id);
	/**
	 * 根据name 查询 Bug*/
	public  Bug selectByName(@Param("bug_summary") String bug_summary);
	/**
	 * 根据id删除*/
	public void deleteById(int id);
	/**
	 * 插入缺陷*/
	public void insertBug(Bug Bug);
	/**
	 * 更新缺陷*/
	public void updateBug(Bug Bug);
	/**
	 * 查询全部缺陷*/
	public List<Bug> buglist();
	/**
	 * 根据提交者查询缺陷*/
	public List<Bug> selectByreporter_id(Integer reporter_id);
	 /**
	  *  根据处理者查询缺陷*/
	public List<Bug> selectByhandler_id(Integer handler_id);
	 /**
	  *  根据所属项目查询缺陷*/
	public List<Bug> selectBypro_id(Integer pro_id);
	/**
	  *  根据严重级别查询缺陷*/
	public List<Bug> selectBypon_id(Integer pon_id);
	
}
