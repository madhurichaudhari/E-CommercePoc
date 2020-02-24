package com.hcl.ecommercepoc;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hcl.ecommercepoc.entities.UserEntities;
import com.hcl.ecommercepoc.repositories.UserRepository;
import com.hcl.ecommercepoc.requestmodels.UserRequestModel;
import com.hcl.ecommercepoc.responsemodels.UserResponseModel;

@SpringBootApplication
public class ECommercePocApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	private ModelMapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(ECommercePocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (this.userRepository.findByUsername("praveen") == null) {
			UserRequestModel user = new UserRequestModel("Praveen Verma", "praveen", passwordEncoder.encode("hcl123"), Arrays.asList("ADMIN"));
			mapper = new ModelMapper();
			
			UserEntities userEntities = mapper.map(user, UserEntities.class);
			mapper.map(this.userRepository.save(userEntities), UserResponseModel.class);
			
		}
	}

}
