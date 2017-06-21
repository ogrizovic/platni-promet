package com.poslovna.repo;


import org.springframework.data.repository.CrudRepository;

import com.poslovna.model.users.Klijent;

public interface KlijentRepo extends CrudRepository<Klijent, Integer> {

}
