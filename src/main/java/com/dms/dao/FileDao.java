package com.dms.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.dms.entity.Files;
public interface FileDao {
	/**
	 * 根据id 查询File*/
	public Files selectById(@Param("file_id") Integer file_id);
	
	/**
	 * 根据name 查询File*/
	public Files selectByName(@Param("file_name") String file_name);
	
	/**
	 * 根据id删除*/
	public void deleteById(int id);
	
	public void insertFile (Files File);
	
	public void updateFile (Files File);
	
	public List<Files >filelist();
	
	public List<Files>selectByBug(Integer bug_id);  
	
	public Files selectByuser(Integer user_id); 
	
}
