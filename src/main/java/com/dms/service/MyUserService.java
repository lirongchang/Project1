package com.dms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.MyUser;

public interface MyUserService {

	/**
	 * 通过手机号与密码登陆返回一个用户
	 * 
	 * @param name
	 *            MyUser的name(即电话号码)
	 * @param password
	 *            MyUser的密码
	 * @return
	 */
	public MyUser selectByNamePassword(String name, String password);

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用戶名
	 * @return
	 */
	public void insertUser(MyUser use);

	/**
	 * 实现用户注册时不能重名的功能
	 * 
	 * @param name
	 *            用户名即手机号
	 * @return
	 */
	public MyUser selectByName(@Param("name") String name);

	/**
	 * 刷新用户的信息
	 * 
	 * @param u用戶
	 * @return
	 */
	public void updateUser(MyUser u);
	
	/**
	 * 显示全部的用户*/
	public List<MyUser> findAll();
	 /**根据id删除用户*/
	public void deleteUser(int id);
	

    public MyUser selectByEmailPassword(@Param("email") String email, @Param("password") String password);
    
    public MyUser selectByEmail(@Param("email") String email);
	
	  
    /**
     * 通过Id 查询用户*/
    
    public MyUser selectById(int id);
	 
}