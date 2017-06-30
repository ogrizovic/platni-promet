package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.AnalitikaIzvoda;

@Repository
public interface NaplataRepo extends CrudRepository<AnalitikaIzvoda ,Integer>{
	public AnalitikaIzvoda findById(int id);
}
