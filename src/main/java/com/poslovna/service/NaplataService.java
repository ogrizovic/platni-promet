package com.poslovna.service;

import java.util.Set;

import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.dom.DOMParser;
import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.model.users.access.AuthorizationInterceptor;
import com.poslovna.repo.NaplataRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class NaplataService implements CrudService<AnalitikaIzvoda>{
	
	
	@Autowired
	private NaplataRepo isplataRepo;
	
	private String kojiJeXml;
	
	
public NaplataService(){
		
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
		//filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\naplata1.xml";
		filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\naplata1.xml";
		parser.main(filePath);
		
	}else if(a.equals("name2")){
		//filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\naplata2.xml";
		filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\naplata2.xml";
		parser.main(filePath);
		
	}else if(a.equals("name3")){
		//filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\naplata3.xml";
		filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\naplata3.xml";
		parser.main(filePath);
		
	}else{
		System.out.println("Ne znam kako je izabran xml koji ne postoji.");
	}
}

}
