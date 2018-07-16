package com.pas.mapper;

import com.pas.dao.domain.User;
/**
 * 这里是Mapper接口,接口定义的方法一定跟User.xml里面的sql id一致,否则会出现错误.
 * @author Administrator
 *
 */
public interface IUserMapper {  
	
    public abstract User queryUserById(int id);  
    public abstract void insertUser(User user);  
    public abstract void updateUser(User user);  
  
} 