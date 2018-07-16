package com.pas.dao;


import java.util.List;

public interface IUsersDao {
	@SuppressWarnings("rawtypes")
	public abstract List queryUserByName(String name);
}
