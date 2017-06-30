package com.poslovna.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.poslovna.model.Racun;

public interface RacunRepo extends CrudRepository<Racun, Integer> {

	public Racun findByBrojRacuna(String brojRacuna);
	public ArrayList<Racun> findAll();
}
