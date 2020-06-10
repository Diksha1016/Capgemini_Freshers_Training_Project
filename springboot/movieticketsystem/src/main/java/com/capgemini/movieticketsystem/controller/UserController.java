package com.capgemini.movieticketsystem.controller;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.movieticketsystem.dto.UserBean;
import com.capgemini.movieticketsystem.dto.UserResponse;
import com.capgemini.movieticketsystem.service.UserService;

@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping(path="/userRegister",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse userRegister(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();

		if(service.userRegister(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("User registered successfully");
			
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("UserId already exists");
		}
		return response;
	}
	@PostMapping(path="/userLogin",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse adminLogin(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		UserBean admin = service.userLogin(bean.getUserId(), bean.getUserPassword());
		if(admin!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("User found for given credential");
			response.setUser(Arrays.asList(admin));
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Invalid credential");
		}
		return response;
	}
	@PutMapping(path ="/change-password",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse changePassword(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		if(service.changePassword(bean.getUserId(), bean.getUserPassword())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Password changed successfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Unable to change password");
		}
		return response;
	}
//	@PutMapping(path = "/update-profile", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public UserResponse updateProduct(@RequestBody UserBean bean) {
//		UserResponse response = new UserResponse();
//		UserBean userBean = new UserBean();
//		userBean.setUserId(bean.getUserId());
//		userBean.setUserName(bean.getUserName());
//		userBean.setContact(bean.getContact());
//		userBean.setUserPassword(bean.getUserPassword());
//		userBean.setDateOfBirth(bean.getDateOfBirth());
//		
//		
//		if (service.updateProfile(bean.getUserId(),userBean)) {
//			response.setStatusCode(201);
//			response.setMessage("success");
//			response.setDescription("Profile updated successfully");
//		} else {
//			response.setStatusCode(401);
//			response.setMessage("failure");
//			response.setDescription("unable to update profile details");
//		}
//		return response;
//	}
	@PutMapping(path ="/update-contact",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateAccount(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		if(service.updateContact(bean.getUserId(), bean.getContact())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Contact Number changed successfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Unable to change contact");
		}
		return response;
	}
	
}
