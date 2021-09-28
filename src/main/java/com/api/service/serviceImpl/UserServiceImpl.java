package com.api.service.serviceImpl;

import com.api.model.PhoneEntity;
import com.api.model.UserEntity;
import com.api.repository.UserRepository;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<PhoneEntity> getPhoneById(String userId) {
		UserEntity user = userRepository.findByUserId(userId);
		return user.getPhone();
	}

	@Override
	public List<PhoneEntity> getAllNumbers() {
		return null;
	}

	@Override
	public Boolean activateUser(String userId) {
		return null;
	}
/*
	@Override
	public PhoneEntity getPhoneById(String userId) {

	}

	@Override
	public List<PhoneEntity> getAllNumbers() {
		return userRepository.getAllUsers();
	}

	@Override
	public Boolean activateUser(String userId) {
		UserEntity user = userRepository.getActivateUSer(userId);
		user.setActivationStatus(true);
		userRepository.save(user);
		return user.getActivationStatus();
	}*/
}
