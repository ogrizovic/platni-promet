package com.poslovna.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.poslovna.model.AnalitikaIzvoda;

public interface AnalitikaIzvodaRepo extends CrudRepository<AnalitikaIzvoda, Integer> {

	public ArrayList<AnalitikaIzvoda> findByRacunDuznika(String racun);
	public ArrayList<AnalitikaIzvoda> findByRacunPoverioca(String racun);
}
