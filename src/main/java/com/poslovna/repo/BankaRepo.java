package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;

import com.poslovna.model.Banka;

public interface BankaRepo extends CrudRepository<Banka, Integer>{

}
