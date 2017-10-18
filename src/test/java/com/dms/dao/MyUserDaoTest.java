package com.dms.dao;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		user.setName("张三丰");
		user.setPassword("123456");
		user.setEmail("88888888888@qq.com");
		user.setRole(123);
		user.setStatus(1);
		myUserDao.insertUser(user);
	}
	
	@Test
	@Rollback(true)
	public void testselectByName() {
		MyUser user = new MyUser();
		user.setName("周志寰");
		user.setPassword("123456");
		user.setEmail("1184531851@qq.com");
		user.setRole(123);
		user.setStatus(1);
		myUserDao.insertUser(user);
		MyUser myuser=myUserDao.selectByName(user.getName());
		if (myuser != null) {
			Assert.assertEquals(user.getName(), myuser.getName());
		}
	}
	
	@Test
	@Rollback(true)
	public void testupdateUser() {
		MyUser user = new MyUser();
		user.setName("李佳玲");
		user.setPassword("654321");
		user.setEmail("3354676884@qq.com");
		user.setRole(123);
		user.setStatus(1);
		myUserDao.insertUser(user);
		myUserDao.updateUser(user);
		MyUser myuser=myUserDao.selectByName(user.getName());
		if (myuser != null) {
			Assert.assertEquals(user.getName(), myuser.getName());
		}
	}
	
	
	@Test(expected=NullPointerException.class)
	@Rollback(true)
	public void testdeleteUser() {
		MyUser user = new MyUser();
		user.setName("楚留香");
		user.setPassword("654321");
		user.setEmail("3354676884@qq.com");
		user.setRole(123);
		user.setStatus(1);
		myUserDao.insertUser(user);
		myUserDao.updateUser(user);
		MyUser myuser=myUserDao.selectByName(user.getName());
		if (myuser != null) {
			Assert.assertEquals(user.getName(), myuser.getName());
		}
		myUserDao.deleteUser(myuser.getId());
		myUserDao.updateUser(myuser);
		MyUser myuser2=myUserDao.selectByName(user.getName());
		myuser2.getName();
	}
	
	@Test
	@Rollback(true)
	public void testlist() {
		List<MyUser> users=new ArrayList<MyUser>();
		MyUser user1=new MyUser();
		user1.setName("敖海洋");
		user1.setPassword("123456");
		user1.setEmail("2725144703@qq.com");
		user1.setRole(1);
		user1.setStatus(1);
		
		MyUser user2=new MyUser();
		user2.setName("李荣昌");
		user2.setPassword("123456");
		user2.setEmail("123456@qq.com");
		user2.setRole(1);
		user2.setStatus(1);
		
		MyUser user3=new MyUser();
		user3.setName("任想");
		user3.setPassword("123456");
		user3.setEmail("12345678@qq.com");
		user3.setRole(1);
		user3.setStatus(1);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		List<MyUser> actual=new ArrayList<MyUser>();
		actual=myUserDao.list();
//		Assert.assertEquals(users, actual);
	}
	
	@Test
	@Rollback(true)
	public void testselectById() {
		MyUser user1 = new MyUser();
		user1.setName("敖海洋");
		user1.setPassword("123456");
		user1.setEmail("2725144703@qq.com");
		user1.setRole(1);
		user1.setStatus(1);
		user1.setId(1);
		
		Assert.assertEquals(user1.getId(), myUserDao.selectById(1).getId());
	}
	
	@Test
	public void testselectByEmailPassword() {
		MyUser user = new MyUser();
		user.setName("李荣昌");
		user.setEmail("123456@qq.com");
		user.setPassword("123456");
		
		MyUser myUser = myUserDao.selectByEmailPassword(user.getEmail(), user.getName());
		if (myUser != null) {
			Assert.assertEquals(user.getEmail(), myUser.getEmail());
			Assert.assertEquals(user.getPassword(), myUser.getPassword());
		}
	}
	
	@Test
	public void testselectByEmail() {
		MyUser user = new MyUser();
		user.setName("李荣昌");
		user.setEmail("123456@qq.com");
		user.setPassword("123456");
		
		MyUser myUser = myUserDao.selectByEmail(user.getEmail());
		if (myUser != null) {
			Assert.assertEquals(user.getEmail(), myUser.getEmail());
		}
	}
}
