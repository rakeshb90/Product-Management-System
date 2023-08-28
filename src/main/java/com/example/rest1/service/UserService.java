package com.example.rest1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest1.dao.UserDao;
import com.example.rest1.entity.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	public List<User> getAllUser(){
		List<User>users=new ArrayList<User>();
		userDao.findAll().forEach(user->users.add(user));
		return users;
		
	}
	public User getUser(int id) {
		return userDao.getById(id);
	}
	public User getUserByname(String name) {
		return userDao.findByName(name);
	}
   public User saveUser(User user) {
	   return userDao.save(user);
   }
   public User updateUser(User user) {
	  return userDao.saveAndFlush(user);
   }
   public void deleteUser(int id) {
	   userDao.deleteById(id);
	   
   }
}
