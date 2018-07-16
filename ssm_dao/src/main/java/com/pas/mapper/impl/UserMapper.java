package com.pas.mapper.impl;

import com.pas.dao.domain.User;
import com.pas.mapper.IUserMapper;

/**
 * 杩欎釜鏄疢apper鎺ュ彛鏂瑰紡,鎺ュ彛鐨勬柟娉曞悕瀛楀氨鐩存帴瀵瑰簲User.xml閲岄潰鐨凷QL ID.<p>
 * 鍦ㄥ疄鐜扮被閲岄潰瀹炵幇骞剁洿鎺ヤ娇鐢ㄦ帴鍙�鍏跺疄杩欎釜鎺ュ彛鐨勫疄鐜板氨鏄疷ser.xml
 * @author Administrator
 *
 */
public class UserMapper implements IUserMapper {
	private IUserMapper userMapper;

	public User queryUserById(int id) {
		return userMapper.queryUserById(id);
	}

	public void insertUser(User user) {
		System.out.println("userMapper insertUser");
		userMapper.insertUser(user);
	}

	public void updateUser(User user) {
		System.out.println("userMapper updateUser");
		userMapper.updateUser(user);
	}

	public IUserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(IUserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
