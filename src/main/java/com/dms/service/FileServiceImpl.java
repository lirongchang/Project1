package com.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.FileDao;
import com.dms.entity.Files;
 
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;

	public Files selectById(Integer file_id) {
		// TODO Auto-generated method stub
		return fileDao.selectById(file_id);
	}

	public Files selectByName(String file_name) {
		// TODO Auto-generated method stub
		return fileDao.selectByName(file_name);
	}

	public void deleteById(int id) {
	            fileDao.deleteById(id);
	}

	public void insertFile(Files File) {
		// TODO Auto-generated method stub
		fileDao.insertFile(File);
	}

	public void updateFile(Files File) {
		// TODO Auto-generated method stub
		fileDao.updateFile(File);
	}

	public List<Files> filelist() {
		// TODO Auto-generated method stub
		return fileDao.filelist();
	}

	public List<Files> selectByBug(Integer bug_id) {
		// TODO Auto-generated method stub
		return fileDao.selectByBug(bug_id);
	}

	public Files selectByuser(Integer user_id) {
		// TODO Auto-generated method stub
		return fileDao.selectByuser(user_id);
	}
	
	 

}
