package com.poslovna.repo;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.poslovna.model.users.access.Permission;
import com.poslovna.model.users.access.Role;

@Repository
public class InMemoryRoleRepo {

	private ConcurrentMap<String, Object> roles = new ConcurrentHashMap<String, Object>();
	private ArrayList<Permission> permissions = new ArrayList<>();
	
	public InMemoryRoleRepo() {
		Permission permRead = new Permission("READ");
		Permission permWrite = new Permission("WRITE");
		permissions.add(permRead);
		
		roles.put("klijent", new Role("Klijent", permissions));
	}
	
	public Role findByUsername(String username) {
		return null;
	}
}
