package com.dsx.dao;

import org.springframework.stereotype.Repository;

import com.dsx.entities.User;

@Repository
public interface UserDao {
	
	public void addUser(User user);

}
