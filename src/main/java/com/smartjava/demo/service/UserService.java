package com.smartjava.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjava.demo.model.User;
import com.smartjava.demo.repository.UserRepository;
import com.smartjava.demo.response.MetadataResponse;
import com.smartjava.demo.response.ResultResponse;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public ResultResponse saveUser(User user) {
		
		ResultResponse response=new ResultResponse();
		MetadataResponse metadataResponse=new MetadataResponse();
		
		Optional<User> existingUser =userRepository.findByUserName(user.getUserName());
		
		if(!existingUser.isPresent()) {
			User userSave=userRepository.save(user);
			metadataResponse.setCode("200K");
			metadataResponse.setMessage("User Registration sucessfylly...");
			metadataResponse.setNoOfRecords(1);
			response.setResult(userSave);
			response.setMetadata(metadataResponse);
			return response;
		}else {
			metadataResponse.setCode("400K");
			metadataResponse.setMessage("User already present in database....");
			metadataResponse.setNoOfRecords(0);
			response.setResult(null);
			response.setMetadata(metadataResponse);
			return response;
		}
	
		
	}

	public ResultResponse loginUser(String userName, String password) {
		ResultResponse response=new ResultResponse();
		MetadataResponse metadataResponse=new MetadataResponse();
		try {
			Optional<User> userData=userRepository.findByUserName(userName);
			User userList=userData.get();
			
			if(userList.getPassword().equalsIgnoreCase(password)) {
				metadataResponse.setCode("200K");
				metadataResponse.setMessage("Login sucessfylly...");
				metadataResponse.setNoOfRecords(1);
				response.setResult(userList);
				response.setMetadata(metadataResponse);
				return response;
			}else {
				metadataResponse.setCode("400K");
				metadataResponse.setMessage("Failed to Login please check your credential...");
				metadataResponse.setNoOfRecords(0);
				response.setResult(null);
				response.setMetadata(metadataResponse);
				return response;
			}
		}catch (Exception e) {
			metadataResponse.setCode("400K");
			metadataResponse.setMessage("Failed to Login please check your credential...");
			metadataResponse.setNoOfRecords(0);
			response.setResult(null);
			response.setMetadata(metadataResponse);
			return response;
		}
	}

}
