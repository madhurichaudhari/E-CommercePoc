package com.hcl.ecommercepoc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommercepoc.requestmodels.UserRequestModel;
import com.hcl.ecommercepoc.responsemodels.UserResponseModel;
import com.hcl.ecommercepoc.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public UserResponseModel addUser(@RequestBody UserRequestModel user) {
		return this.userService.saveUser(user);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public List<UserResponseModel> getAllUsers() {
		return this.userService.getAll();
	}

}
