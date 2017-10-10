package com.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.BugDao;
import com.dms.dao.ProjectDao;
import com.dms.entity.Bug;
import com.dms.entity.Project;
@Service
public class BugServiceImpl implements BugService {

	@Autowired
	private BugDao bugDao;

	public Bug selectById(Integer bug_id) {
		// TODO Auto-generated method stub
		return  bugDao.selectById(bug_id);
	}

	public Bug selectByName(String bug_summary) {
		// TODO Auto-generated method stub
		return bugDao.selectByName(bug_summary);
	}

	public void deleteById(int id) {
		bugDao.deleteById(id);
		
	}

	public void insertBug(Bug Bug) {
	bugDao.insertBug(Bug);
		
	}

	public void updateBug(Bug Bug) {
		// TODO Auto-generated method stub
		bugDao.updateBug(Bug);
	}

	public List<Bug> buglist() {
		// TODO Auto-generated method stub
		return bugDao.buglist();
	}

	public List<Bug> selectByreporter_id(Integer reporter_id) {
		// TODO Auto-generated method stub
		return bugDao.selectByreporter_id(reporter_id);
	}

	public List<Bug> selectByhandler_id(Integer handler_id) {
		// TODO Auto-generated method stub
		return bugDao.selectByhandler_id(handler_id);
	}

	public List<Bug> selectBypro_id(Integer pro_id) {
		// TODO Auto-generated method stub
		return bugDao.selectBypro_id(pro_id);
	}

	public List<Bug> selectBypon_id(Integer pon_id) {
		// TODO Auto-generated method stub
		return  bugDao.selectBypon_id(pon_id);
	}

 
	 
}
