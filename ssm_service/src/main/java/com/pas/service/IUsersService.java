package com.pas.service;

import com.pas.dao.domain.User;

public interface IUsersService {  
    public abstract User queryUsersById(int id);  
    public abstract User queryUsersByName(String name);  
    public abstract void saveUser(User user);  
}
