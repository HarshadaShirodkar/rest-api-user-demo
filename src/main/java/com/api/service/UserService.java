package com.api.service;


import com.api.model.PhoneEntity;

import java.util.List;

public interface UserService {

	List<PhoneEntity> getPhoneById(String userId);
	List<PhoneEntity> getAllNumbers();
	Boolean activateUser(String userId);



}