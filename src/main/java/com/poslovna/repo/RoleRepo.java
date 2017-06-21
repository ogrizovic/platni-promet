package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.users.access.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer>{
	public Role findByRoleName(String roleName);

}
