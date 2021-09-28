package com.api;
import com.api.model.PhoneEntity;
import com.api.model.UserEntity;
import com.api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@SpringBootApplication
public class Application  {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {

			List<PhoneEntity> phoneEntities = new ArrayList<>();
			phoneEntities.add(new PhoneEntity(2L, new UserEntity(), "0000000000"));
			phoneEntities.add(new PhoneEntity(3L, new UserEntity(), "12345678"));
			// save a few customers
			repository.save( new UserEntity( 1L,"A","John",
					false,phoneEntities));
			repository.save(new UserEntity( 2L,"B","Kim",
					false,phoneEntities));
			repository.save(new UserEntity( 3L,"C","Min",
					false, phoneEntities));


			// fetch all nos
			log.info("User with all numbers():");
			log.info("-------------------------------");
			for (UserEntity user : repository.findAll()) {
				List<PhoneEntity> phones = user.getPhone();
				log.info(phones.toString());
			}
			log.info("");

			// fetch an individual user by ID
			Optional<UserEntity> user = repository.findById(1L);
			log.info("user found with findById(1L):");
			log.info("--------------------------------");
			log.info(user.toString());
			log.info("");

			// fetch customers by last name
			log.info("User found with findByUserId('A'):");
			log.info("--------------------------------------------");
			UserEntity userEntity = repository.findByUserId("A");
			userEntity.getPhone().toString();
			repository.findByUserId("A").getPhone().forEach(phoneEntity -> {
				log.info("Phone Number of user A::", phoneEntity.getPhoneNumber());
			});
		};
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
