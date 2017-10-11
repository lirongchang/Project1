package com.dms.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dms.entity.MyUser;

import junit.framework.Assert;

//需要用到的配置
@ContextConfiguration(locations = { "classpath:spring/application-mvc.xml", "classpath:spring/application.xml",
		"classpath:mybatis/mybatis-config.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class) // 用spring的测试框架

public class MyUserDaoTest {
	
	@Autowired
	private MyUserDao myUserDao;
	
	@Test
	public void testSelectByNamePassword() {
		MyUser user = new MyUser();
		user.setName("李荣昌");
		user.setPassword("123456");

		MyUser myUser = myUserDao.selectByNamePassword(user.getName(), user.getPassword());
		if (myUser != null) {
			Assert.assertEquals(user.getName(), myUser.getName());
			Assert.assertEquals(user.getPassword(), myUser.getPassword());
		}
	}

	@Test
	@Rollback(true)
	public void testInsertUser() {
		MyUser user = new MyUser();
		user.setName("周志寰");
		user.setPassword("123456");
		user.setEmail("1184531851@qq.com");
		user.setRole(123);
		user.setStatus(1);
		myUserDao.insertUser(user);
	}

}
