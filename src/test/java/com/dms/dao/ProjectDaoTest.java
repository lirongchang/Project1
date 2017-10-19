package com.dms.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dms.entity.Project;

import junit.framework.Assert;

//需要用到的配置
@ContextConfiguration(locations = { "classpath:spring/application-mvc.xml", "classpath:spring/application.xml",
		"classpath:mybatis/mybatis-config.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class) // 用spring的测试框架

public class ProjectDaoTest {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Test
	public void testSelectById() {
		Project project=new Project();
		project.setPro_id(123456);
		project.setPro_name("this is a test for project");
		Project project2=projectDao.selectById(project.getPro_id());
		if(project2!=null) {
			Assert.assertEquals(project.getPro_id(), project2.getPro_id());
		}
	}

	@Test
	public void testSelectByName() {
		Project project=new Project();
		project.setPro_id(123456);
		project.setPro_name("this is a test for project");
		Project project2=projectDao.selectByName(project.getPro_name());
		if(project2!=null) {
			Assert.assertEquals(project.getPro_name(), project2.getPro_name());
		}
	}

	@Test
	public void testDeleteById() {
		Project project=new Project();
		project.setPro_id(123456);
		project.setPro_name("this is a test for project");
		projectDao.deleteById(project.getPro_id());
	}

//	@Test
//	public void testInsertProject() {
//		Project project=new Project();
//		project.setPro_id(123456);
//		project.setPro_name("this is a test for project");
//		projectDao.insertProject(project);		
//	}

	@Test
	public void testUpdateProject() {
		Project project=new Project();
		project.setPro_id(123456);
		project.setPro_name("this is a test for project");
		projectDao.updateProject(project);
	}

	@Test
	public void testProjectlist() {
		Project project=new Project();
		project.setPro_id(123456);
		project.setPro_name("this is a test for project");
		projectDao.projectlist();
	}

}
