package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;

import com.poslovna.model.Valuta;

public interface ValutaRepo extends CrudRepository<Valuta, Integer>{
	
}
