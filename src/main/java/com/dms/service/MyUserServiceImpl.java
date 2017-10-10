package com.dms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.MyUserDao;
import com.dms.entity.MyUser;

/**
 * 测试信息服务类（接口的实现类）
 * 
 * @author
 *
 */
@Service
public class MyUserServiceImpl implements MyUserService {

	@Autowired
	private MyUserDao myUserDao;

	/**
	 * 通过手机号与密码登陆返回一个用户
	 * 
	 * @param name
	 *            MyUser的name(即电话号码)
	 * @param password
	 *            MyUser的密码
	 * @return
	 */
	//@Override
	public MyUser selectByNamePassword(String name, String password) {
		return myUserDao.selectByNamePassword(name, password);
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用戶名
	 * @return
	 */
	//@Override
	public void insertUser(MyUser user) {
		myUserDao.insertUser(user);
	}

	/**
	 * 实现用户注册时不能重名的功能
	 * 
	 * @param name
	 *            用户名即手机号
	 * @return
	 */
	//@Override
	public MyUser selectByName(@Param("name") String name) {
		return myUserDao.selectByName(name);
	}

	/**
	 * 刷新用户的信息
	 * 
	 * @param u用戶
	 * @return
	 */
	//@Override
	public void updateUser(MyUser u) {
		myUserDao.updateUser(u);
	 
	}

	/*
	 *展示全部用户*/
	
	//@Override
	public List<MyUser> findAll() {
		// TODO Auto-generated method stub
	   return 	myUserDao.list();
	}

	//@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		myUserDao.deleteUser(id);
		
	}

	//@Override
	public MyUser selectById(int id) {
		// TODO Auto-generated method stub
		return myUserDao.selectById(id);
	}
	public MyUser selectByEmailPassword(String email, String password) {
		// TODO Auto-generated method stub
		return myUserDao.selectByEmailPassword(email,password);
	}

	public MyUser selectByEmail(String email) {
		// TODO Auto-generated method stub
		return myUserDao.selectByEmail(email);
	}
}
