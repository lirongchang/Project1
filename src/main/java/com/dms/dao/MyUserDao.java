package com.dms.dao;
 

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.MyUser;


public interface MyUserDao {
     /**用户登录
     * @param name  手机号
     * @param password 密码
     * @return
     */
    public MyUser selectByNamePassword(@Param("name") String name, @Param("password") String password);
    /**
     * 实现用户注册时不能重名的功能
     * @param name 用户名即手机号
     * @return
     */
    public MyUser selectByName(@Param("name") String name);
    /**
     * 添加用户
     * @param user 用戶名
     * @return
     */
    public void insertUser(MyUser user);
    
    /**
     * 刷新用户的信息
     * @param u用戶
     * @return
     */
    public void updateUser(MyUser u);
    /**
     * 删除用户*/
    public void deleteUser(int id);
    /**
     * 查看全部用户*/
    public List<MyUser> list();
    
    /**
     * 通过Id 查询用户*/
    
    public MyUser selectById(int id);
 
   
    public MyUser selectByEmailPassword(@Param("email") String email, @Param("password") String password);
    
    public MyUser selectByEmail(@Param("email") String email);
    
}
