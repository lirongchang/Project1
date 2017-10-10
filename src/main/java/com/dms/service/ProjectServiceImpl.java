package com.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.ProjectDao;
import com.dms.entity.Project;
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	public Project selectById(Integer pro_id) {
		// TODO Auto-generated method stub
		return projectDao.selectById(pro_id);
	}

	public Project selectByName(String pro_name) {
		// TODO Auto-generated method stub
		return projectDao.selectByName(pro_name);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		projectDao.deleteById(id);
		
	}

	public void insertProject(Project project) {
		// TODO Auto-generated method stub
		projectDao.insertProject(project);
		
	}

	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		projectDao.updateProject(project);
	}

	public List<Project> projectlist() {
		// TODO Auto-generated method stub
		return projectDao.projectlist();
	}

}
