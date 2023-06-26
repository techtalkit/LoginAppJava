package com.jwt.jwtauthenticationexample.jwtauthexample;

import com.jwt.jwtauthenticationexample.jwtauthexample.model.User;
import com.jwt.jwtauthenticationexample.jwtauthexample.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class JwtauthexampleApplication implements CommandLineRunner {
	@Autowired
    private UserRepository userRepository;
	static Random random=new Random();
	public void createUsers(){
		long id= random.nextLong(100);
		User user=new User();
		user.setId(id);
		user.setEmail("user"+id+"@gmail.com");
		user.setPassword("user"+id);
		user.setEnabled(true);
		user.setRole("Admin");
		user.setUsername("user"+id);
		User save=userRepository.save(user);
		System.out.println(save);
	}
	public static void main(String[] args) {
		SpringApplication.run(JwtauthexampleApplication.class, args);
        //new JwtauthexampleApplication().createUsers();
	}

	@Override
	public void run(String... args) throws Exception {
		createUsers();
	}
}
