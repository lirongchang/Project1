package com.dms.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dms.entity.Bug;

import junit.framework.Assert;

//需要用到的配置
@ContextConfiguration(locations = { "classpath:spring/application-mvc.xml", "classpath:spring/application.xml",
		"classpath:mybatis/mybatis-config.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class) // 用spring的测试框架

public class BugDaoTest {
	
	@Autowired
	private BugDao bugDao;
	
	@Test
	public void testSelectById() {
		Bug bug=new Bug();
		bug.setBug_id(1);
		Bug actual=bugDao.selectById(bug.getBug_id());
		if(actual!=null) {
			Assert.assertEquals(bug.getBug_id(), actual.getBug_id());
		}	
	}

	@Test
	public void testSelectByName() {
		Bug bug=new Bug();
		bug.setBug_summary("this is a bug!");
		Bug actual=bugDao.selectByName(bug.getBug_summary());
		if(actual!=null) {
			Assert.assertEquals(bug.getBug_summary(), actual.getBug_summary());
		}	
	}

	@Test
	public void testDeleteById() {
		Bug bug=new Bug();
		bug.setBug_id(123);
		bug.setBug_comment("this is a bug");
		bug.setBug_description("click a link invalid");
		bug.setPro_id(2);
		bugDao.deleteById(bug.getBug_id());
	}

//	@Test
//	public void testInsertBug() {
//		Bug bug=new Bug();
//		bug.setBug_id(123);
//		bug.setBug_comment("this is a bug");
//		bug.setBug_description("click a link invalid");
//		bug.setPro_id(2);
//		bugDao.insertBug(bug);
//	}

	@Test
	public void testUpdateBug() {
		Bug bug=new Bug();
		bug.setBug_id(123);
		bug.setBug_comment("this is a bug");
		bug.setBug_description("click a link invalid");
		bug.setPro_id(2);
		bugDao.updateBug(bug);
	}

	@Test
	public void testBuglist() {
		Bug bug=new Bug();
		bug.setBug_id(123);
		bug.setBug_comment("this is a bug");
		bug.setBug_description("click a link invalid");
		bug.setPro_id(2);
		bugDao.buglist();
	}
	

	@Test
	public void testSelectBypro_id() {
		Bug bug=new Bug();
		bug.setPro_id(123456);
		List<Bug> bug1=new  ArrayList<Bug>();
		bug1=bugDao.selectBypro_id(bug.getPro_id());
		//Assert.assertEquals(bug.getPon_id(), bug1.get(0).getPon_id());
	}

	@Test
	public void testSelectBypon_id() {
		Bug bug=new Bug();
		bug.setPon_id(123456);
		List<Bug> bug1=new  ArrayList<Bug>();
		bug1=bugDao.selectBypon_id(bug.getPon_id());
		//Assert.assertEquals(bug.getPon_id(), bug1.get(0).getPon_id());
	}

}
