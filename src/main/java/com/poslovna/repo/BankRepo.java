package com.poslovna.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Banka;

@Repository
public interface BankRepo extends CrudRepository<Banka, Integer>{

}
