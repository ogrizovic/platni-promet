package com.poslovna.service;

import java.util.Set;

import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.dom.DOMParser;
import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.model.DnevnoStanjeRacuna;
import com.poslovna.model.Racun;
import com.poslovna.model.users.access.AuthorizationInterceptor;
import com.poslovna.repo.DnevnoStanjeRacunaRepo;
import com.poslovna.repo.IsplataRepo;
import com.poslovna.repo.NaseljenoMestoRepo;
import com.poslovna.repo.UplataRepo;
import com.poslovna.repo.ValutaRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class UplataService implements CrudService<AnalitikaIzvoda>{
	
	@Autowired
	private UplataRepo uplataRepo;
	
	@Autowired
	private ValutaRepo valutaRepo;
	
	@Autowired
	private RacunService racunService;
	
	@Autowired
	private NaseljenoMestoRepo naseljenomestoRepo;
	
	@Autowired
	private DnevnoStanjeRacunaRepo dnevnoStanjeRacunaRepo;
	
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
	
	private int qwerty = 0;
	
	public AnalitikaIzvoda odrediKojiJeXml(String a){
		
		if(a.equals("name1")){
//			filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\uplata1.xml";
			filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\uplata1.xml";
			AnalitikaIzvoda ai = parser.parseXML(filePath);
			ai.setValuta(valutaRepo.findOne(1));
			ai.setMestoPrijema(naseljenomestoRepo.findOne(1));
			
			/*Racun racun = racunService.findByBrojRacuna(ai.getRacunDuznika());
			Set<DnevnoStanjeRacuna> stanja = (Set<DnevnoStanjeRacuna>) racun.getDnevnoStanje();
			for(DnevnoStanjeRacuna dsr1 : stanja){
				if(dsr1.getDatumStanja().equals("01-07-2017")){
					dsr1.setPrethodnoStanje(dsr1.getNovoStanje());
					double aaa = dsr1.getNovoStanje();
					dsr1.setNovoStanje(aaa+ai.getIznos());
					double bbb = dsr1.getPrometNaTeret();
					dsr1.setPrometNaTeret(bbb+ai.getIznos());
					dnevnoStanjeRacunaRepo.save(dsr1);	
					qwerty=1;
					System.out.println("qwerty je jedannnnnnnnnnnnnnnnnnnn");
				}
			}
			
			if(qwerty==0){
				DnevnoStanjeRacuna dsr2 = new DnevnoStanjeRacuna();
				System.out.println("qwerty je nulaaaaaaaaaaaaa");
				dsr2.setNovoStanje(ai.getIznos());
				dsr2.setPrometNaTeret(ai.getIznos());
				dnevnoStanjeRacunaRepo.save(dsr2);	
			}*/
			
			
			/*if(dnevnoStanjeRacunaRepo.findByRacunBrojRacunaAndDatumPrijema(ai.getRacunPoverioca(), ai.getDatumPrijema())!=null){
				DnevnoStanjeRacuna dsr1 = dnevnoStanjeRacunaRepo.findByRacunBrojRacuna(ai.getRacunPoverioca());
				dsr1.setPrethodnoStanje(dsr1.getNovoStanje());
				double aaa = dsr1.getNovoStanje();
				dsr1.setNovoStanje(aaa+ai.getIznos());
				double bbb = dsr1.getPrometNaTeret();
				dsr1.setPrometNaTeret(bbb+ai.getIznos());
				dnevnoStanjeRacunaRepo.save(dsr1);
			}else{
				DnevnoStanjeRacuna dsr2 = new DnevnoStanjeRacuna();
				dsr2.setNovoStanje(ai.getIznos());
				dsr2.setPrometNaTeret(ai.getIznos());
			}*/
			return uplataRepo.save(ai);
			
		}else if(a.equals("name2")){
//			filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\uplata2.xml";
			filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\uplata2.xml";
			AnalitikaIzvoda ai = parser.parseXML(filePath);
			ai.setValuta(valutaRepo.findOne(1));
			ai.setMestoPrijema(naseljenomestoRepo.findOne(1));
			return uplataRepo.save(ai);
			
		}else if(a.equals("name3")){
//			filePath = "D:\\workspace_4\\poslovna\\src\\main\\resources\\xml\\uplata3.xml";
			filePath = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xml\\uplata3.xml";
			AnalitikaIzvoda ai = parser.parseXML(filePath);
			ai.setValuta(valutaRepo.findOne(1));
			ai.setMestoPrijema(naseljenomestoRepo.findOne(1));
			return uplataRepo.save(ai);
			
		}else{
			System.out.println("Ne znam kako je izabran xml koji ne postoji.");
			return null;
		}
	}
	
	

}
