package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

public interface UserService {
	
	public List<User> findAll() throws Exception;
	
	public User findBy(Integer userId) throws Exception;
	
	public User findBy(String userName) throws Exception;

	public List<UserDto> getAll() throws Exception;

	public UserDto get(Integer userId) throws Exception;

	public UserDto get(String userName) throws Exception;

	public void create(UserDto userDto) throws Exception;

	public void update(Integer userId, UserDto userDto) throws Exception;

	public void delete(Integer userId) throws Exception;

}
