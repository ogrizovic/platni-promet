package com.poslovna.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.Banka;
import com.poslovna.repo.BankRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class BankService implements CrudService<Banka>{

	@Autowired
	private BankRepo bankRepo;
	
	public BankService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Banka add(Banka t) {
		return bankRepo.save(t);
	}

	@Override
	public Banka getById(int id) {
		return bankRepo.findOne(id);
	}

	@Override
	public Set<Banka> getAll() {
		return (Set<Banka>) bankRepo.findAll();
	}

	@Override
	public Banka update(Banka t) {
		return bankRepo.save(t);
	}

	@Override
	public void delete(int id) {
		bankRepo.delete(id);
	}

}
