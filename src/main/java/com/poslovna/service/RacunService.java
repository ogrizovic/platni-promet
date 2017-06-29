package com.poslovna.service;

import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.DnevnoStanjeRacuna;
import com.poslovna.model.Racun;
import com.poslovna.repo.BankRepo;
import com.poslovna.repo.DnevnoStanjeRacunaRepo;
import com.poslovna.repo.RacunRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class RacunService implements CrudService<Racun>{

	Random rnd = new Random();
	
	@Autowired
	private RacunRepo racunRepo;
	
	@Autowired
	private DnevnoStanjeRacunaRepo stanjeRepo;
	
	@Autowired
	private BankRepo bankRepo;
	
	public RacunService() {
		// TODO Auto-generated constructor stub
	}
	
	public DnevnoStanjeRacuna stanje(String brojRacuna){
		return stanjeRepo.findByRacunBrojRacuna(brojRacuna);
	}

	@Override
	public Racun add(Racun t) {
		return racunRepo.save(t);
	}

	@Override
	public Racun getById(int id) {
		return racunRepo.findOne(id);
	}

	@Override
	public Set<Racun> getAll() {
		return (Set<Racun>) racunRepo.findAll();
	}

	@Override
	public Racun update(Racun t) {
		return racunRepo.save(t);
	}

	@Override
	public void delete(int id) {
		racunRepo.delete(id);		
	}

	public String generateBrojRacuna() {
		String sifraBanke = bankRepo.findOne(1).getSifraBanke();
		long range = 999999999999999L;
		return sifraBanke + String.valueOf((long)(rnd.nextDouble() * range));
	}
	
	
}
