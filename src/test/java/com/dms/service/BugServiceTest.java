package com.dms.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dms.entity.Bug;

import junit.framework.Assert;

@ContextConfiguration(locations = { "classpath:spring/application-mvc.xml"
		, "classpath:spring/application.xml",
		"classpath:mybatis/mybatis-config.xml", })
/**
 * 用spring Junit4测试
 */
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)

public class BugServiceTest {
	
	@Autowired
	private BugService bugService;

	@Test
	public void testSelectById() {
		Bug bug=new Bug();
		bug.setBug_id(123456);
		bug.setBug_comment("this is a test for BugServices");
		bug.setBug_description("this is a test for BugServeices");
		Bug bug2=bugService.selectById(bug.getBug_id());
		if(bug2!=null) {
			Assert.assertEquals(bug.getBug_id(), bug2.getBug_id());
		}
	}

	@Test
	public void testSelectByName() {
		Bug bug=new Bug();
		bug.setBug_id(123456);
		bug.setBug_comment("this is a test for BugServices");
		bug.setBug_description("this is a test for BugServeices");
		bug.setBug_summary("this is a test for BugServeices");
		Bug bug2=bugService.selectByName(bug.getBug_summary());
		if(bug2!=null) {
			Assert.assertEquals(bug.getBug_summary(), bug2.getBug_summary());
		}
	}

	@Test
	public void testDeleteById() {
		Bug bug=new Bug();
		bug.setBug_id(123456);
		bug.setBug_comment("this is a test for BugServices");
		bug.setBug_description("this is a test for BugServeices");
		bug.setBug_summary("this is a test for BugServeices");
		bugService.deleteById(bug.getBug_id());
	}

//	@Test
//	public void testInsertBug() {
//		Bug bug=new Bug();
//		bug.setBug_id(123456);
//		bug.setBug_comment("this is a test for BugServices");
//		bug.setBug_description("this is a test for BugServeices");
//		bug.setBug_summary("this is a test for BugServeices");
//		bugService.insertBug(bug);
//	}

	@Test
	public void testUpdateBug() {
		Bug bug=new Bug();
		bug.setBug_id(123456);
		bug.setBug_comment("this is a test for BugServices");
		bug.setBug_description("this is a test for BugServeices");
		bug.setBug_summary("this is a test for BugServeices");
		bugService.updateBug(bug);
	}

	@Test
	public void testBuglist() {
		Bug bug=new Bug();
		bug.setBug_id(123456);
		bug.setBug_comment("this is a test for BugServices");
		bug.setBug_description("this is a test for BugServeices");
		bug.setBug_summary("this is a test for BugServeices");
		bugService.buglist();
		
	}

//	@Test
//	public void testSelectByreporter_id() {
//		Bug bug=new Bug();
//		bug.setBug_id(123456);
//		bug.setBug_comment("this is a test for BugServices");
//		bug.setBug_description("this is a test for BugServeices");
//		bug.setBug_summary("this is a test for BugServeices");
//		bug.setReporter_id(123456);
//		bugService.selectByreporter_id(bug.getReporter_id());
//	}

//	@Test
//	public void testSelectByhandler_id() {
//		Bug bug=new Bug();
//		bug.setBug_id(123456);
//		bug.setBug_comment("this is a test for BugServices");
//		bug.setBug_description("this is a test for BugServeices");
//		bug.setBug_summary("this is a test for BugServeices");
//		bug.setHandler_id(123456);
//		bug.setReporter_id(123456);
//		bugService.selectByhandler_id(bug.getHandler_id());
//	}

	@Test
	public void testSelectBypro_id() {
		Bug bug=new Bug();
		bug.setBug_id(123456);
		bug.setBug_comment("this is a test for BugServices");
		bug.setBug_description("this is a test for BugServeices");
		bug.setBug_summary("this is a test for BugServeices");
		bug.setHandler_id(123456);
		bug.setReporter_id(123456);
		bug.setPon_id(123456);
		bugService.selectBypro_id(bug.getPro_id());
	}

	@Test
	public void testSelectBypon_id() {
		Bug bug=new Bug();
		bug.setBug_id(123456);
		bug.setBug_comment("this is a test for BugServices");
		bug.setBug_description("this is a test for BugServeices");
		bug.setBug_summary("this is a test for BugServeices");
		bug.setHandler_id(123456);
		bug.setReporter_id(123456);
		bugService.selectBypon_id(bug.getPon_id());
	}

}
