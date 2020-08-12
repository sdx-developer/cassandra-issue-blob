package com.example.issuecassandra;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.datastax.oss.driver.api.core.data.ByteUtils;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private UserRepository userRepository;
	
	public Users saveUser(Users users) {
		return this.userRepository.save(users);
	}

	public Users saveUsers(String userName, MultipartFile file) {
		Users user=new Users();
		user.setUserName(userName);
		setProfileImageDetails(user, new MultipartFile[] {file});
		System.out.println(Objects.toString(user));
		return this.saveUser(user);
	}
	
	 public void setProfileImageDetails(Users user,MultipartFile[] files)
	  { 
	   try {
		  if (files != null && files.length >0) 
		  	{
			  byte[] bytes; MultipartFile file = files[0];
			  bytes = file.getBytes();
			 
			  user.setProfileImage(ByteUtils.toHexString( Base64.getEncoder().encode(bytes)));
			
			} 
		  } 
	  catch (IOException e) {
		  LOGGER.debug("Exception at setProfileImageDetails: " + e.getMessage()); }
	 }

}
