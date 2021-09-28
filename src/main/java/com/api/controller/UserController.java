package com.api.controller;

import com.api.model.PhoneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.api.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getUser")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<PhoneEntity>> getUserById(String userId) {
		List<PhoneEntity> phoneEntities = userService.getPhoneById(userId);

		return new ResponseEntity<>(phoneEntities, HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<PhoneEntity>> getAllUsers() {
		List<PhoneEntity> userProfile = userService.getAllNumbers();

		return new ResponseEntity<>(userProfile, HttpStatus.OK);
	}

	@PatchMapping("/activateUser")
	public ResponseEntity<Boolean> activateUser(String userId) {
		Boolean status = userService.activateUser(userId);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
