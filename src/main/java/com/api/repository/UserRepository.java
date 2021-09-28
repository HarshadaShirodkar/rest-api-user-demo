package com.api.repository;

import com.api.exception.ResourceNotFoundException;
import com.api.model.PhoneEntity;
import com.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUserId(@NotBlank String userId);

	List<PhoneEntity> getAllUsers();

	UserEntity getActivateUSer(String userId);




}
