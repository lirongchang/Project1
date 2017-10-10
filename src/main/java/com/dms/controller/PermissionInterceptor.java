package com.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dms.entity.MyUser;

public class PermissionInterceptor implements HandlerInterceptor {

 

	    public boolean preHandle(  HttpServletRequest request,  HttpServletResponse response, Object handler) throws Exception {
	       //首先进入的方法
	        System.out.println("preHandle");
	        //return false表示拦截，不向下执行
	         //return true表示放行
	        System.out.println(request.getServletPath());
	        HttpSession session = request.getSession();
	        MyUser u=(MyUser)session.getAttribute("currUser");
	        if(u!=null){
	        	  System.out.println(u.getName());
	            return true;
	        }else{
	        	 request.setAttribute("message", "请先登录再访问网站!");
	     		 request.getRequestDispatcher("/").forward(request, response);
	            return false;
	        }

	    }
	    //返回modelAndView之前执行
	    public void postHandle( HttpServletRequest request,  HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		    	
	        System.out.println("postHandle");
	    }
	    //执行Handler完成执行此方法
	    public void afterCompletion( HttpServletRequest request,  HttpServletResponse response, Object handler, Exception ex) throws Exception {

	        System.out.println("afterCompletion");
	    }

 
}
