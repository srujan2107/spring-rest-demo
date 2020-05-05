package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() throws Exception {
		List<User> users = this.userRepository.findAll();
		if(users == null) throw new DataNotFoundException();
		return users;
	}

	@Override
	public User findBy(Integer userId) throws Exception {
		Optional<User> user = this.userRepository.findById(userId);
		return user.orElseThrow(() -> new DataNotFoundException());
	}

	@Override
	public User findBy(String userName) throws Exception {
		Optional<User> user = this.userRepository.findByUserName(userName);
		return user.orElseThrow(() -> new DataNotFoundException());
	}

	@Override
	public List<UserDto> getAll() throws Exception {
		return this.findAll().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto get(Integer userId) throws Exception {
		return new UserDto(this.findBy(userId));
	}

	@Override
	public UserDto get(String userName) throws Exception {
		return new UserDto(this.findBy(userName));
	}

	@Override
	@Transactional
	public void create(UserDto userDto) throws Exception {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setMiddleName(userDto.getMiddleName());
		user.setUserName(userDto.getUserName());
		user.setEmail(userDto.getEmailAddr());
		user.setPhone(userDto.getPhoneNum());
		this.userRepository.save(user);
	}

	@Override
	@Transactional
	public void update(Integer userId, UserDto userDto) throws Exception {
		User user = this.findBy(userId);
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setMiddleName(userDto.getMiddleName());
		user.setUserName(userDto.getUserName());
		user.setEmail(userDto.getEmailAddr());
		user.setPhone(userDto.getPhoneNum());
		this.userRepository.save(user);
	}

	@Override
	@Transactional
	public void delete(Integer userId) throws Exception {
		User user = this.findBy(userId);
		this.userRepository.delete(user);	
	}

}
