package com.dms.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:spring/application-mvc.xml"
		, "classpath:spring/application.xml",
		"classpath:mybatis/mybatis-config.xml", })
/**
 * 用spring Junit4测试
 */
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)


public class BugServiceImplTest {
	
	@Autowired
	private BugServiceImpl bugServiceImpl;

	@Test
	public void testSelectById() {
		
	}

	@Test
	public void testSelectByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBug() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBug() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuglist() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByreporter_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByhandler_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectBypro_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectBypon_id() {
		fail("Not yet implemented");
	}

}
