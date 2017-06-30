package com.poslovna.service;

import java.util.Set;

import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.dom.DOMParser;
import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.model.users.access.AuthorizationInterceptor;
import com.poslovna.repo.PrenosRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class PrenosService implements CrudService<AnalitikaIzvoda>{
	
	@Autowired
	private PrenosRepo isplataRepo;
	
	private String kojiJeXml;
	
	
public PrenosService(){
		
	}
	
	
@Override
public AnalitikaIzvoda add(AnalitikaIzvoda t) {
	// TODO Auto-generated method stub
	return isplataRepo.save(t);
}

@Override
public AnalitikaIzvoda getById(int id) {
	// TODO Auto-generated method stub
	return isplataRepo.findOne(id);
}

@Override
public Set<AnalitikaIzvoda> getAll() {
	// TODO Auto-generated method stub
	return (Set<AnalitikaIzvoda>) isplataRepo.findAll();
}

@Override
@Interceptors(AuthorizationInterceptor.class)
public AnalitikaIzvoda update(AnalitikaIzvoda t) {
	// TODO Auto-generated method stub
	return isplataRepo.save(t);
}

@Override
@Interceptors(AuthorizationInterceptor.class)
public void delete(int id) {
	// TODO Auto-generated method stub
	isplataRepo.delete(id);
}


public void saljeMiControler(String nm) {
	// TODO Auto-generated method stub
	kojiJeXml = nm;
	odrediKojiJeXml(kojiJeXml);
}

public AnalitikaIzvoda analitikaIzvoda;

DOMParser parser = new DOMParser();

public String filePath;

public void odrediKojiJeXml(String a){
	
	if(a.equals("name1")){
		//filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\prenos1.xml";
		filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\prenos1.xml";
		parser.parseXML(filePath);
		
	}else if(a.equals("name2")){
		//filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\prenos2.xml";
		filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\prenos2.xml";
		parser.parseXML(filePath);
		
	}else if(a.equals("name3")){
		//filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\prenos3.xml";
		filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\prenos3.xml";
		parser.parseXML(filePath);
		
	}else{
		System.out.println("Ne znam kako je izabran xml koji ne postoji.");
	}
}
	
}