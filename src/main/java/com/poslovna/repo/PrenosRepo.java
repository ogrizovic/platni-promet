package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.AnalitikaIzvoda;

@Repository
public interface PrenosRepo extends CrudRepository<AnalitikaIzvoda ,Integer>{
	public AnalitikaIzvoda findById(int id);
}
