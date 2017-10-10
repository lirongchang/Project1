package com.dms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 








import com.dms.entity.Bug;
import com.dms.entity.MyUser;
import com.dms.entity.Project;
import com.dms.service.BugService;
import com.dms.service.MyUserService;
import com.dms.service.ProjectService;
 
@Controller
public class BugController {
  @Resource
  private ProjectService projectService;
  @Resource
  private MyUserService userService;
  @Resource
  private BugService BugService;
  /**
   * 跳转到projectlist*/
  @RequestMapping(value = "/bug")
  public ModelAndView projectlist() {
    ModelAndView mav = new ModelAndView("Bug/buglist");
    List<Bug> list=BugService.buglist();
    List<MyUser> users=userService.findAll();
    List<Project> pros=projectService.projectlist();
    mav.addObject("list", list);
    mav.addObject("users",users);
    mav.addObject("pros", pros);
    
    return mav;
  }
  
   @RequestMapping(value = "/deletebug")
  public ModelAndView deleteproject(@RequestParam("bug_id") Integer bug_id) {
	   BugService.deleteById(bug_id);
	   ModelAndView mav = new ModelAndView("Bug/buglist");
	    List<Bug> list=BugService.buglist();
	    List<MyUser> users=userService.findAll();
	    List<Project> pros=projectService.projectlist();
	    mav.addObject("list", list);
	    mav.addObject("users",users);
	    mav.addObject("pros", pros);
    return mav;
  }
   
   @RequestMapping(value = "/to_addbug")
  public ModelAndView toaddbug(HttpServletRequest request) {
	   ModelAndView mav = new ModelAndView("Bug/addbug");
	    List<Project> pros=projectService.projectlist();
	    HttpSession session = request.getSession();
	    MyUser user=(MyUser)session.getAttribute("currUser");
        System.out.println("--------------userid--"+user.getId()+"---------------------------");
	     mav.addObject("user",user); 
	    mav.addObject("pros", pros);
    return mav;
  }
  
   @RequestMapping(value = "/addbug", method = RequestMethod.POST)
   public ModelAndView addproject(@Validated Bug bug,BindingResult bindingResult,HttpServletRequest request) {
 	  if (bindingResult.hasErrors()) {
 	      List<ObjectError> itemsErrorList = bindingResult.getAllErrors();
 	      ModelAndView mav = new ModelAndView("Bug/addbug");
 	      mav.addObject("itemsErrorList", itemsErrorList);
 	      return mav;
 	    } else if (BugService.selectByName(bug.getBug_summary()) != null) {
 	      ModelAndView mav = new ModelAndView("Bug/addbug");
 	     List<Project> pros=projectService.projectlist();
 	     HttpSession session = request.getSession();
         MyUser user=(MyUser)session.getAttribute("currUser");
         System.out.println("--------------userid--"+user.getId()+"---------------------------");
 	     mav.addObject("user",user); 
 	     mav.addObject("pros", pros);
 	      return mav;
 	    } 
 	    
 	    else { 
 	      BugService.insertBug(bug);
 	      //注册成功跳转到登录页面
 	     ModelAndView mav = new ModelAndView("Bug/buglist");
 	    List<Bug> list=BugService.buglist();
 	    List<MyUser> users=userService.findAll();
 	    List<Project> pros=projectService.projectlist();
 	    mav.addObject("list", list);
 	    mav.addObject("users",users);
 	    mav.addObject("pros", pros);
 	      return mav;
 	    }
   }
   
   
   
   @RequestMapping(value = "/to_updatebug")
   public ModelAndView toupdateproject(@RequestParam("bug_id") Integer bug_id) {
	   ModelAndView mav = new ModelAndView("Bug/updatebug");
	   System.out.println(bug_id);
	   Bug bug=BugService.selectById(bug_id);
	   mav.addObject("bug", bug);
	   List<MyUser> users=userService.findAll();
	   mav.addObject("users",users);
	   List<Project> pros=projectService.projectlist();
	   mav.addObject("pros", pros);
	    return mav;
	  }
	  
	  @RequestMapping(value = "/updatebug",method = RequestMethod.POST)
	  public ModelAndView updateproject(@Validated Bug bug, BindingResult bindingResult) {
		  {
		      BugService.updateBug(bug);
		      ModelAndView mav = new ModelAndView("Bug/buglist");
		      List<Bug> list=BugService.buglist();
		      List<MyUser> users=userService.findAll();
		      List<Project> pros=projectService.projectlist();
		      mav.addObject("list", list);
		      mav.addObject("users",users);
		      mav.addObject("pros", pros);
		      return mav;
		    }
	  }
	  
 
}
