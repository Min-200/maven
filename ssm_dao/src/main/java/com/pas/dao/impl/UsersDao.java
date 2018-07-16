package com.pas.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.pas.dao.IUsersDao;
/**
 * 这个是使用dao方式,这种方式可以处理自定义异常等.
 * @author Administrator
 *
 */
@Repository
public class UsersDao extends SqlSessionDaoSupport implements IUsersDao {
	@SuppressWarnings("rawtypes")
	public List queryUserByName(String name) {
		System.out.println("Users.queryUserByName()");
		return getSqlSession().selectList("com.pas.mapper.IUserMapper.queryUserByName", name);
	}
}
