package com.springboot.chapter9.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.chapter9.dao.UserDao;
import com.springboot.chapter9.pojo.User;
import com.springboot.chapter9.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
//	使用mybatis接口 userDao。因为在启动文件使用MapperScan装配了对应的接口。这里可以依赖注入
	private UserDao userDao = null;
	
	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> findUsers(String userName, String note) {
		return userDao.findUsers(userName, note);
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}
	
}
