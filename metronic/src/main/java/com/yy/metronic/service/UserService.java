package com.yy.metronic.service;

import com.yy.metronic.entity.User;

//涉及到事务的，用service调用
public interface UserService {
	
	void saveUser(User user);

}
