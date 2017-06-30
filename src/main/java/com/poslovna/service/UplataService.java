package com.poslovna.service;

import java.util.Set;

import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.dom.DOMParser;
import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.model.users.access.AuthorizationInterceptor;
import com.poslovna.repo.UplataRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class UplataService implements CrudService<AnalitikaIzvoda>{
	
	@Autowired
	private UplataRepo uplataRepo;
	
	public UplataService(){
		
	}
	

	@Override
	public AnalitikaIzvoda add(AnalitikaIzvoda t) {
		// TODO Auto-generated method stub
		return uplataRepo.save(t);
	}

	@Override
	public AnalitikaIzvoda getById(int id) {
		// TODO Auto-generated method stub
		return uplataRepo.findOne(id);
	}

	@Override
	public Set<AnalitikaIzvoda> getAll() {
		// TODO Auto-generated method stub
		return (Set<AnalitikaIzvoda>) uplataRepo.findAll();
	}

	@Override
	@Interceptors(AuthorizationInterceptor.class)
	public AnalitikaIzvoda update(AnalitikaIzvoda t) {
		// TODO Auto-generated method stub
		return uplataRepo.save(t);
	}

	@Override
	@Interceptors(AuthorizationInterceptor.class)
	public void delete(int id) {
		// TODO Auto-generated method stub
		uplataRepo.delete(id);
	}


	public AnalitikaIzvoda analitikaIzvoda;
	
	DOMParser parser = new DOMParser();
	
	public String filePath;
	
	public AnalitikaIzvoda odrediKojiJeXml(String a){
		
		if(a.equals("name1")){
			filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\uplata1.xml";
//			filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\uplata1.xml";
			AnalitikaIzvoda ai = parser.parseXML(filePath);
			return uplataRepo.save(ai);
			
		}else if(a.equals("name2")){
			filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\uplata2.xml";
//			filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\uplata2.xml";
			AnalitikaIzvoda ai = parser.parseXML(filePath);
			return uplataRepo.save(ai);
			
		}else if(a.equals("name3")){
			filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\uplata3.xml";
//			filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\uplata3.xml";
			AnalitikaIzvoda ai = parser.parseXML(filePath);
			return uplataRepo.save(ai);
			
		}else{
			System.out.println("Ne znam kako je izabran xml koji ne postoji.");
			return null;
		}
	}
	
	

}
