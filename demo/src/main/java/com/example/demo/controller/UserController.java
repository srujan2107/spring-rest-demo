package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> get() throws Exception {
		List<UserDto> userDtos = this.userService.getAll();
		return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK);
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<UserDto> get(@PathVariable("userId")Integer userId) throws Exception {
		UserDto userDto = this.userService.get(userId);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	@GetMapping("{userName}")
	public ResponseEntity<UserDto> get(@PathVariable("userName")String userName) throws Exception {
		UserDto userDto = this.userService.get(userName);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody UserDto userDto) throws Exception {
		this.userService.create(userDto);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("{userId}")
	public ResponseEntity<String> update(@PathVariable("userId")Integer userId, @RequestBody UserDto userDto) throws Exception {
		this.userService.update(userId, userDto);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{userId}")
	public ResponseEntity<String> delete(@PathVariable("userId")Integer userId) throws Exception {
		this.userService.delete(userId);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

}
