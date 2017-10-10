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
import com.dms.service.MyUserService;
 
@Controller
public class MyUserController {
  @Resource
  private MyUserService userService;
  /**
   * 系统首页框架 教学内容：get 方式返回页面
   * 
   * @return 返回系统首页
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView getIndex() {
    ModelAndView mav = new ModelAndView("index");
    return mav;
  }

  /**
   * 登录系统 教学内容：post方式传输页面，页面参数转换，session用法
   * 
   * @param username
   *          用户名
   * @param userpsw
   *          用户密码
   * @param session
   *          当前连接的session
   * @return
   */

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(@Validated @RequestParam("name") String name,
      @Validated @RequestParam("password") String password, HttpSession session) {
    ModelAndView mav;
    MyUser myUser = userService.selectByNamePassword(name, password);
    if (myUser == null) {
      mav = new ModelAndView("User/loginUser");
      mav.addObject("error", "用户名或密码错误！");
    } else {
       List<MyUser> list = userService.findAll();
      // 记录下当前登录用户
      session.setAttribute("currUser", myUser);
      session.setAttribute("name", myUser.getName());
      mav = new ModelAndView("User/userlist"); 
      mav.addObject("list", list);
    }
    return mav;
  }

  @RequestMapping(value = "/to_login")
  public ModelAndView login() {
    ModelAndView mav = new ModelAndView("User/loginUser");
    return mav;
  }
  
  /**
   * 跳转到邮箱登录*/
  @RequestMapping(value = "/to_login2")
  public ModelAndView loginbyemail() {
    ModelAndView mav = new ModelAndView("User/login2");
    return mav;
  }
  
  
  /**
   * 进行邮箱登录*/
  @RequestMapping(value = "/login2", method = RequestMethod.POST)
  public ModelAndView login2(@Validated @RequestParam("email") String email,
      @Validated @RequestParam("password") String password, HttpSession session) {
    ModelAndView mav = null;

    MyUser myUser = userService.selectByEmailPassword(email, password);

    if (myUser == null) {
      mav = new ModelAndView("User/login2");
      mav.addObject("error", "用户名或密码错误！");
    } else {
       List<MyUser> list = userService.findAll();
      // 记录下当前登录用户
      session.setAttribute("currUser", myUser);
      session.setAttribute("name", myUser.getName());
      mav = new ModelAndView("User/userlist"); 
      mav.addObject("list", list);
 
    }
    return mav;
  }
  
 
  /**
   * 登出页面
   * 
   * @param session
   * @return
   */
  @RequestMapping(value = "/logout")
  public ModelAndView logout(HttpSession session) {
    // 移除当前登录用户信息
    session.removeAttribute("currUser");
    ModelAndView mav = new ModelAndView("loginUser");
    return mav;
  }

  @RequestMapping(value = "/to_reginster")
  public ModelAndView getReginster() {
    ModelAndView mav = new ModelAndView("User/reginsterUser");
    return mav;
  }

  /**
   * 注册页面
   * 
   * @param u
   * @param bindingResult
   * @return
   */
  @RequestMapping(value = "/reginster", method = RequestMethod.POST)
  public ModelAndView reginster(@Validated MyUser u, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      List<ObjectError> itemsErrorList = bindingResult.getAllErrors();
      ModelAndView mav = new ModelAndView("User/reginsterUser");
      mav.addObject("itemsErrorList", itemsErrorList);
      return mav;
    } else if (userService.selectByName(u.getName()) != null) {
      ModelAndView mav = new ModelAndView("User/reginsterUser");
      mav.addObject("reginsterError", "该用户名已被注册！");
      return mav;
    } 
    else if (userService.selectByEmail(u.getEmail()) != null) {
        ModelAndView mav = new ModelAndView("User/reginsterUser");
        mav.addObject("reginsterError", "该邮箱已被注册！");
        return mav;
      }
    else {
      userService.insertUser(u);
      //注册成功跳转到登录页面
      ModelAndView mav = new ModelAndView("User/loginUser");
      return mav;
    }

  }
  
  @RequestMapping(value = "/about")
  public ModelAndView getAboutTeam() {
    ModelAndView mav = new ModelAndView("aboutpage");
    return mav;
  }
  
  @RequestMapping(value = "/deleteUser")
  public ModelAndView deleteUser(@RequestParam("id") Integer id,
	      HttpSession session) {
	  userService.deleteUser(id);
    ModelAndView mav = new ModelAndView("questionType");
    List<MyUser> list = userService.findAll();
    mav.addObject("list", list);
    return mav;
  }
  /**
   * 跳转修改用户页面*/
  @RequestMapping(value = "/updateUser")
  public ModelAndView updata(@RequestParam("id") Integer id,
	      HttpSession session) {
	 
	MyUser user=userService.selectById(id);
    ModelAndView mav = new ModelAndView("User/UpdateUser");
 
    mav.addObject("list", user);
 
    return mav;
  }
  /**
   * 更新用户后，跳转到用户列表*/
  @RequestMapping(value = "/updateUser2", method = RequestMethod.POST)
  public ModelAndView updataUser(@Validated MyUser u, BindingResult bindingResult){
   
	 userService.updateUser(u);
     ModelAndView mav = new ModelAndView("User/userlist");
     List<MyUser> list = userService.findAll();
     mav.addObject("list",list);
    return mav;
  }
}
