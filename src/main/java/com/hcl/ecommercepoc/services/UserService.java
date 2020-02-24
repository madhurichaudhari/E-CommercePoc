package com.hcl.ecommercepoc.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcl.ecommercepoc.entities.UserEntities;
import com.hcl.ecommercepoc.repositories.UserRepository;
import com.hcl.ecommercepoc.requestmodels.UserRequestModel;
import com.hcl.ecommercepoc.responsemodels.UserResponseModel;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	ModelMapper mapper;

	public UserResponseModel saveUser(UserRequestModel user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		mapper = new ModelMapper();
		UserEntities userEntities = mapper.map(user, UserEntities.class);
		UserResponseModel userResponseModel = mapper.map(this.userRepository.save(userEntities), UserResponseModel.class);
		return  userResponseModel;
	}

	public List<UserResponseModel> getAll() {
		
		List<UserResponseModel> userResponseModelList = (List<UserResponseModel>) mapper.map(this.userRepository.findAll(), UserResponseModel.class);
		
		return userResponseModelList;
	}

}
