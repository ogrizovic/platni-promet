package com.poslovna.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.model.Racun;
import com.poslovna.repo.AnalitikaIzvodaRepo;
import com.poslovna.repo.RacunRepo;

@Service
public class AnalitikaIzvodaService {

	@Autowired
	private AnalitikaIzvodaRepo analitikaRepo;
	
	@Autowired
	private RacunRepo racunRepo;
	
	public AnalitikaIzvodaService() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<AnalitikaIzvoda> getAllZaRacun(int racunId, String datum){
		Racun racun = racunRepo.findOne(racunId);
		String brojRacuna = racun.getBrojRacuna();
		ArrayList<AnalitikaIzvoda> tmp = analitikaRepo.findByRacunDuznikaAndDatumPrijema(brojRacuna, datum);
		tmp.addAll(analitikaRepo.findByRacunPoveriocaAndDatumPrijema(brojRacuna, datum));
		return tmp;
	}
	
	public ArrayList<AnalitikaIzvoda> getAllZaRacun(int racunId){
		Racun racun = racunRepo.findOne(racunId);
		String brojRacuna = racun.getBrojRacuna();
		ArrayList<AnalitikaIzvoda> tmp = analitikaRepo.findByRacunDuznika(brojRacuna);
		tmp.addAll(analitikaRepo.findByRacunPoverioca(brojRacuna));
		return tmp;
	}
	
	public ArrayList<AnalitikaIzvoda> getAllNeprocesuirane(){
		ArrayList<AnalitikaIzvoda> tmp = analitikaRepo.findByProcesuiran(false);
		//tmp.addAll(analitikaRepo.findByProcesuiran(false));
		return tmp;
	}
	
	public void kliring(){
		ArrayList<AnalitikaIzvoda> tmp = analitikaRepo.findByProcesuiran(false);
		for(int i= 0; i<tmp.size();i++){
			tmp.get(i).setProcesuiran(true);
		}
		analitikaRepo.save(tmp);
	}
	

	public AnalitikaIzvoda add(AnalitikaIzvoda ai) {
		return analitikaRepo.save(ai);
	}
}
