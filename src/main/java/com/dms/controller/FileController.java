package com.dms.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dms.entity.Files;
import com.dms.entity.MyUser;
import com.dms.service.MyUserService;
import com.dms.service.FileService;
 
@Controller
public class FileController {
  @Resource
  private FileService FileService;
  @Resource
  private MyUserService userService;
  /**
   * 跳转到Filelist*/
  @RequestMapping(value = "/file")
  public ModelAndView Filelist() {
    ModelAndView mav = new ModelAndView("File/filelist");
    List<Files> list=FileService.filelist();
    mav.addObject("list", list);
    return mav;
  }
  
  /*@RequestMapping(value = "/deleteFile")
  public ModelAndView deleteFile(@RequestParam("pro_id") Integer pro_id) {
	  FileService.deleteById(pro_id);
    ModelAndView mav = new ModelAndView("File/Filelist");
    List<File> list=FileService.Filelist();
    mav.addObject("list", list);
    return mav;
  }
  */
//  @RequestMapping(value = "/to_File")
//  public ModelAndView toFile() {
//    ModelAndView mav = new ModelAndView("File/addFile");
//    List<MyUser> users=userService.findAll();
//    mav.addObject("users",users);
//    return mav;
//  }
//  
//  @RequestMapping(value = "/to_updateFile")
//  public ModelAndView toupdateFile(@RequestParam("pro_id") Integer pro_id) {
//    ModelAndView mav = new ModelAndView("File/updateFile");
//    File pro=FileService.selectById(pro_id);
//    mav.addObject("pro", pro);
//    List<MyUser> users=userService.findAll();
//    mav.addObject("users",users);
//    return mav;
//  }
//  
//  @RequestMapping(value = "/updateFile",method = RequestMethod.POST)
//  public ModelAndView updateFile(@Validated File pro, BindingResult bindingResult) {
//	  {
//	      FileService.updateFile(pro);
//	      //注册成功跳转到登录页面
//	  	  MyUser myUser=userService.selectById(pro.getManage_id());
// 
//	      ModelAndView mav = new ModelAndView("File/Filelist");
//	      List<File> list=FileService.Filelist();
//	      mav.addObject("myuser",myUser);
//	      mav.addObject("list", list);
//	      return mav;
//	    }
//  }
//  
  
  @RequestMapping(value = "/to_addfile")
  public ModelAndView to_addFile()
  {
	  ModelAndView mav = new ModelAndView("File/addfile"); 
      return mav;
  }
  @RequestMapping(value = "/addfile", method = RequestMethod.POST)
  public ModelAndView addFile(@Validated Files files,BindingResult bindingResult) {
	 
	      FileService.insertFile(files);
	   
	     // String originalFilename = file.getOriginalFilename();
	      
	 //     System.out.println("--------------"+originalFilename+"--------------------");
//			if (file != null && originalFilename != null && originalFilename.length() > 0) {
//				// 存储图片的物理路径
//				//String pic_path = "D:\\pic\\"; // 将通过tomcat配置虚拟图片服务器
//				String pic_path="D://";
//				// 新的图片名称
//				String filename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
//	
//				
////				file
////				// 将内存中的数据写入磁盘
////				file.transferTo(newFile);
//	      
//			}
	      ModelAndView mav = new ModelAndView("File/filelist");
	      List<Files> list=FileService.filelist();
	      mav.addObject("list", list);
	      return mav;
	    }
   
  
}
  
