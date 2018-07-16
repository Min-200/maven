package com.pas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pas.dao.IUsersDao;
import com.pas.dao.domain.User;
import com.pas.mapper.IUserMapper;
import com.pas.service.IUsersService;
  
@Service(value="usersService")  
@Transactional(rollbackFor=Exception.class)  
public class UsersServiceImpl implements IUsersService {  
      
    @Resource(name="userMapper")  
    private IUserMapper userMapper;  
      
    @Resource(name="usersDao")  
    private IUsersDao usersDao;  
      
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)  
    public User queryUsersById(int id){  
        return userMapper.queryUserById(id);  
    }  
      
    /**
     * 使用dao方式
     */
    @SuppressWarnings("rawtypes")
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)  
    public User queryUsersByName(String name){  
        List list = usersDao.queryUserByName(name);  
        System.out.println("list = "+list==null?"0":list.size());  
        if(list!=null&&list.size()>0) return (User)list.get(0);  
        return null;  
    }  
      
    /**
     * 使用Mapper接口方式
     */
    @Transactional(propagation=Propagation.REQUIRED)  
    public void saveUser(User user){  
        if(user.getUserId()<=0){  
            System.out.println("insertUser");  
            userMapper.insertUser(user);  
        }else{  
            System.out.println("updateUser");  
            userMapper.updateUser(user);  
        }         
        //throw new RuntimeException("@@ Rollback for Debug..........");          
    }  
} 
