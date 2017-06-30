package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;

import com.poslovna.model.DnevnoStanjeRacuna;

public interface DnevnoStanjeRacunaRepo extends CrudRepository<DnevnoStanjeRacuna, Long> {

	public DnevnoStanjeRacuna findByRacunBrojRacuna(String brojRacuna);
	//public DnevnoStanjeRacuna findByRacunBrojRacunaAndDatumPrijema(String brojRacuna, String datumPrijema);
}
