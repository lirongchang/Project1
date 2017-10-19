package com.dms.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dms.entity.Files;

import junit.framework.Assert;

//需要用到的配置
@ContextConfiguration(locations = { "classpath:spring/application-mvc.xml", "classpath:spring/application.xml",
		"classpath:mybatis/mybatis-config.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class) // 用spring的测试框架

public class FileDaoTest {
	
	@Autowired
	private FileDao fileDao;
	
	@Test
	public void testSelectById() {
		Files files=new Files();
		files.setFile_id(123456);
		Files files2=fileDao.selectById(files.getFile_id());
		if(files2!=null) {
			Assert.assertEquals(files.getFile_id(), files2.getFile_id());
		}
		
	}

//	@Test
//	public void testSelectByName() {
//		Files files=new Files();
//		files.setFile_id(123456);
//		files.setFile_name("this is a bug title!");
//		Files files2=fileDao.selectByName(files.getFile_name());
//		if(files2!=null) {
//			Assert.assertEquals(files.getFile_name(), files2.getFile_name());
//		}
//	}

	@Test
	public void testDeleteById() {
		Files files=new Files();
		files.setFile_id(123456);
		Files files2=fileDao.selectById(files.getFile_id());
		fileDao.deleteById(files.getFile_id());
	}

//	@Test
//	public void testInsertFile() {
//		Files files=new Files();
//		files.setFile_id(123456);
//		Files files2=fileDao.selectById(files.getFile_id());
//		fileDao.insertFile(files2);
//	}

	@Test
	public void testUpdateFile() {
		Files files=new Files();
		files.setFile_id(123456);
		Files files2=fileDao.selectById(files.getFile_id());
		fileDao.updateFile(files2);
	}

	@Test
	public void testFilelist() {
		Files files=new Files();
		files.setFile_id(123456);
		Files files2=fileDao.selectById(files.getFile_id());
		fileDao.filelist();
	}

	@Test
	public void testSelectByBug() {
		Files files=new Files();
		files.setFile_id(123456);
		files.setBug_id(12356);
		Files files2=fileDao.selectById(files.getFile_id());
		fileDao.selectByBug(files.getBug_id());
	}

	@Test
	public void testSelectByuser() {
		Files files=new Files();
		files.setFile_id(123456);
		files.setBug_id(12356);
		files.setUser_id(123456);
		Files files2=fileDao.selectById(files.getFile_id());
		fileDao.selectByuser(files.getUser_id());
	}

}
