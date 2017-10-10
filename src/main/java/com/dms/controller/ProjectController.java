package com.dms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 




import com.dms.entity.MyUser;
import com.dms.entity.Project;
import com.dms.service.MyUserService;
import com.dms.service.ProjectService;
 
@Controller
public class ProjectController {
  @Resource
  private ProjectService projectService;
  @Resource
  private MyUserService userService;
  /**
   * 跳转到projectlist*/
  @RequestMapping(value = "/project")
  public ModelAndView projectlist() {
    ModelAndView mav = new ModelAndView("Project/projectlist");
    List<Project> list=projectService.projectlist();
    mav.addObject("list", list);
    return mav;
  }
  
  @RequestMapping(value = "/deleteproject")
  public ModelAndView deleteproject(@RequestParam("pro_id") Integer pro_id) {
	  projectService.deleteById(pro_id);
    ModelAndView mav = new ModelAndView("Project/projectlist");
    List<Project> list=projectService.projectlist();
    mav.addObject("list", list);
    return mav;
  }
  
  @RequestMapping(value = "/to_project")
  public ModelAndView toproject() {
    ModelAndView mav = new ModelAndView("Project/addproject");
    List<MyUser> users=userService.findAll();
    mav.addObject("users",users);
    return mav;
  }
  
  @RequestMapping(value = "/to_updateproject")
  public ModelAndView toupdateproject(@RequestParam("pro_id") Integer pro_id) {
    ModelAndView mav = new ModelAndView("Project/updateproject");
    Project pro=projectService.selectById(pro_id);
    mav.addObject("pro", pro);
    List<MyUser> users=userService.findAll();
    mav.addObject("users",users);
    return mav;
  }
  
  @RequestMapping(value = "/updateproject",method = RequestMethod.POST)
  public ModelAndView updateproject(@Validated Project pro, BindingResult bindingResult) {
	  {
	      projectService.updateProject(pro);
	      //注册成功跳转到登录页面
	  	  MyUser myUser=userService.selectById(pro.getManage_id());
 
	      ModelAndView mav = new ModelAndView("Project/projectlist");
	      List<Project> list=projectService.projectlist();
	      mav.addObject("myuser",myUser);
	      mav.addObject("list", list);
	      return mav;
	    }
  }
  
  
  @RequestMapping(value = "/addproject", method = RequestMethod.POST)
  public ModelAndView addproject(@Validated Project pro,BindingResult bindingResult) {
	  if (bindingResult.hasErrors()) {
	      List<ObjectError> itemsErrorList = bindingResult.getAllErrors();
	      ModelAndView mav = new ModelAndView("Project/addproject");
	      mav.addObject("itemsErrorList", itemsErrorList);
	      return mav;
	    } else if (projectService.selectByName(pro.getPro_name()) != null) {
	      ModelAndView mav = new ModelAndView("Project/addproject");
	      List<MyUser> users=userService.findAll();
	      mav.addObject("users",users);
	      mav.addObject("reginsterError", "该项目已存在!");
	      return mav;
	    } 
	    
	    else {
	      projectService.insertProject(pro);
	      //注册成功跳转到登录页面
	      ModelAndView mav = new ModelAndView("Project/projectlist");
	      List<Project> list=projectService.projectlist();
	      mav.addObject("list", list);
	    
	      return mav;
	    }
  }
  
}
