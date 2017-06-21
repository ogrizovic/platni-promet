package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.users.access.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
}
