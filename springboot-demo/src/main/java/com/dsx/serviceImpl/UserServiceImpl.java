package com.dsx.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsx.dao.UserDao;
import com.dsx.entities.User;
import com.dsx.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public void register(User user) {
		userDao.addUser(user);
	}

}
