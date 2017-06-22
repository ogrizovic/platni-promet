package com.poslovna.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.users.access.Permission;

@Repository
public interface PermissionRepo extends CrudRepository<Permission, Integer>{
	public Permission findByPermissionName(String name);
}
