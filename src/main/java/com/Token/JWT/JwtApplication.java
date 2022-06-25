package com.Token.JWT;

import com.Token.JWT.entity.User;
import com.Token.JWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {SpringApplication.run(JwtApplication.class, args);}

	@Autowired
	private UserRepository repository;


	@PostConstruct
	public void initUsers()
	{
		List<User> users = Stream.of(
				new User(101, "xadmin", "xadminpassword", "xadmin@gmail.com"),
				new User(102, "ashish", "ashishpassword", "ashish@gmail.com"),
				new User(103, "gurpreet", "gurpreetpassword", "gurpreet@gmail.com"),
				new User(104, "mohit", "mohitpassword", "mohit@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}
}
