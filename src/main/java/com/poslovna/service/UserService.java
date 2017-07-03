package com.poslovna.service;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.interceptor.Interceptors;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.users.access.AuthorizationInterceptor;
import com.poslovna.model.users.access.User;
import com.poslovna.repo.UserRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class UserService implements CrudService<User>{

	@Autowired
	private UserRepo userRepo;
	
	public UserService() {
		
	}
	
	public void sendPassword(User user, String password){
		String to = user.getEmail();
		String from = "generickitest@gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(props);
		
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(from);
		
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Registracija");
			message.setText("Dobrodosli, Vase korisnicko ime je: " + user.getUsername() + ", a Vasa lozinka je: " + password);
			
			Transport.send(message);
		
			System.out.println("Mail poslat.");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String generatePassword(){
		return new BigInteger(5, new SecureRandom()).toString();
	}
	
	public String generateUsername(){
		return new BigInteger(5, new SecureRandom()).toString();
	}
	
	public byte[] hashPassword(String password, byte[] salt){
		char[] pass = password.toCharArray();
		try {
			
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(pass, salt, 1000, 256); // samo 1000 iteracija zbog brzine pri testiranju
			SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;
            
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public byte[] generateSalt(){
		return new SecureRandom().generateSeed(32);
	}

	@Override
	public User add(User t) {
		return userRepo.save(t);
	}

	@Override
	public User getById(int id) {
		return userRepo.findOne(id);
	}

	@Override
	public Set<User> getAll() {
		return (Set<User>) userRepo.findAll();
	}

	@Override
	@Interceptors(AuthorizationInterceptor.class)
	public User update(User t) {
		return userRepo.save(t);
	}
	
	@Override
	@Interceptors(AuthorizationInterceptor.class)
	public void delete(int id) {
		userRepo.delete(id);
	}

	public User getByUsername(String username){
		return userRepo.findByUsername(username);
	}
	
}
