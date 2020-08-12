package com.example.issuecassandra;

import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.issuecassandra.*;

@SpringBootApplication
@RestController
public class IssueCassandraApplication {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(IssueCassandraApplication.class, args);
	}
	
	@PostMapping("/users")
	public Users saveUser( @RequestParam String userName,  MultipartFile file) {
		Assert.notNull(userName, "user name cannot be null");
		return this.userService.saveUsers(userName,file);
	}

}
