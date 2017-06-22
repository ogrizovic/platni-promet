package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;

import com.poslovna.model.Racun;

public interface RacunRepo extends CrudRepository<Racun, Integer> {

	public Racun findByBrojRacuna(String brojRacuna);
}
