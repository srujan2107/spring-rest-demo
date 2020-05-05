package com.example.demo.dto;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class UserDto {

	Integer id;
	
	String firstName;
	
	String lastName;
	
	String middleName;
	
	String userName;
	
	String emailAddr;
	
	String phoneNum;
	
	public UserDto() {
		super();
	}

	public UserDto(User user) {
		super();
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.middleName = user.getMiddleName();
		this.userName = user.getUserName();
		this.emailAddr = user.getEmail();
		this.phoneNum = user.getPhone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
