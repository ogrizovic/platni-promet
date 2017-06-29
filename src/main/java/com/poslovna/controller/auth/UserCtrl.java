package com.poslovna.controller.auth;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.controller.Interceptable;
import com.poslovna.dto.ChangePasswordDto;
import com.poslovna.dto.RegisterUserDTO;
import com.poslovna.model.users.Klijent;
import com.poslovna.model.users.PravnoLice;
import com.poslovna.model.users.access.AuthorizationInterceptor;
import com.poslovna.model.users.access.Permission;
import com.poslovna.model.users.access.Role;
import com.poslovna.model.users.access.User;
import com.poslovna.repo.KlijentRepo;
import com.poslovna.service.BankService;
import com.poslovna.service.RoleService;
import com.poslovna.service.UserService;

@Controller
public class UserCtrl implements Interceptable{
	
	private HashMap<String, ArrayList<Permission>> methodPerms; // <naziv_metode, lista_permisija>
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private KlijentRepo klijentRepo;
	
	public UserCtrl() {
		this.methodPerms = new HashMap<>();
		
		ArrayList<Permission> getAllUsersPerms = new ArrayList<Permission>(); // permisije za metodu getAllUsers
		getAllUsersPerms.add(new Permission("readConfidental"));
		methodPerms.put("getAllUsers", getAllUsersPerms);
		
		
		
	}
	
	@RequestMapping(
			value = "/changePassword",
			method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> changePassword(HttpServletRequest request, @RequestBody ChangePasswordDto changePasswordDto){
		
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		if(sessionUser == null){
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		User user = userService.getById(sessionUser.getId());
		
		String hashedOldPass =  user.getPassword();
		String hashedAttemptedOldPass = userService.hashPassword(
				changePasswordDto.getOldPassword(), 
				userService.getById(sessionUser.getId()).getSalt()).toString();
		
		if (!hashedOldPass.equals(hashedAttemptedOldPass)){
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	
		byte[] salt = userService.generateSalt();
		String hashedNewPassword = userService.hashPassword(changePasswordDto.getNewPassword(), salt).toString();
		
		user.setPassword(hashedNewPassword);
		user.setSalt(salt);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(
			value = "/register",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> register(HttpServletRequest request, @RequestBody RegisterUserDTO newUserDto){
		
		
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		if(sessionUser != null){
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		User user = userService.getByUsername(newUserDto.getUsername());
		
		if(user != null){
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		User newUser = new User();
		newUser.setUsername(newUserDto.getUsername());
		newUser.setEmail(newUserDto.getEmail());
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(roleService.getByRoleName("CLIENT"));
		newUser.setRoles(roles);
		byte[] salt = userService.generateSalt();
		newUser.setSalt(salt);
		newUser.setBank(bankService.getById(1));
		newUser.setPassword(new String(userService.hashPassword(newUserDto.getPassword(), salt), Charset.forName("US-ASCII")));
		
		userService.add(newUser);
		
		return new ResponseEntity<User>(newUser, HttpStatus.ACCEPTED);
	}
	
	// nakon kreiranja user-a(pri cemu se generise userID), 
	// novi user mora da se uloguje, pa onda da unese svoje podatke potrebne za fizicko lice
	@RequestMapping(
			value = "/register/fizicko", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Klijent> registracijaFizickogLica(HttpServletRequest request, 
			@RequestBody Klijent klijent){
		User sessionUser = (User) request.getSession().getAttribute("user");
		klijent.setUser(userService.getById(sessionUser.getId()));
		sessionUser.setKlijent(klijent);
		
		klijentRepo.save(klijent);
		return new ResponseEntity<Klijent>(klijent, HttpStatus.OK); 
	}
	
	@RequestMapping(
			value = "/register/pravno",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PravnoLice> registracijaPravnogLica(HttpServletRequest request, 
			@RequestBody PravnoLice pLice){
		User sessionUser = (User) request.getSession().getAttribute("user");
		pLice.setUser(userService.getById(sessionUser.getId()));
		return new ResponseEntity<PravnoLice>(pLice, HttpStatus.OK); 
	}
	
	@Interceptors(AuthorizationInterceptor.class)
	public ArrayList<User> getAllUsers(HttpServletRequest request){
		return (ArrayList<User>) userService.getAll();
	}
	
	
	
	

	public HashMap<String, ArrayList<Permission>> getMethodPermissions() {
		return methodPerms;
	}

	public void setMethodPerms(HashMap<String, ArrayList<Permission>> methodPerms) {
		this.methodPerms = methodPerms;
	}
	
	
	

}
