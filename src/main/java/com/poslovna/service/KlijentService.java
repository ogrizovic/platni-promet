package com.poslovna.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.users.Klijent;
import com.poslovna.repo.KlijentRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class KlijentService implements CrudService<Klijent> {

	@Autowired
	private KlijentRepo klijentRepo;
	
	public KlijentService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Klijent add(Klijent t) {
		return klijentRepo.save(t);
	}

	@Override
	public Klijent getById(int id) {
		return klijentRepo.findOne(id);
	}

	@Override
	public Set<Klijent> getAll() {
		return (Set<Klijent>) klijentRepo.findAll();
	}

	@Override
	public Klijent update(Klijent t) {
		return klijentRepo.save(t);
	}

	@Override
	public void delete(int id) {
		klijentRepo.delete(id);
	}

	
}
