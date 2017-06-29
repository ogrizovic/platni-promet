package com.poslovna.controller.auth;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.dto.LoginDTO;
import com.poslovna.model.users.access.User;
import com.poslovna.service.UserService;

@Controller
public class AuthenticationCtrl {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(
			value = "/login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDto, HttpServletRequest request){
		
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		if(sessionUser != null){
			return new ResponseEntity<LoginDTO>(loginDto, HttpStatus.OK);
		}
		
		User user = new User();
		user = userService.getByUsername(loginDto.getUsername());
		if (user != null){
			byte[] hashedPassword = userService.hashPassword(loginDto.getPassword(), user.getSalt());
			String hashedPasswordString = new String(hashedPassword, Charset.forName("US-ASCII"));
			if(!user.getPassword().equals(hashedPasswordString)){
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			} else {
				request.getSession().setAttribute("user", user);
				return new ResponseEntity<LoginDTO>(loginDto, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(
			value = "/logout",
			method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE) // index
	public ResponseEntity<HttpStatus> logout(HttpServletRequest request){
		
		request.getSession().setAttribute("user", null);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
