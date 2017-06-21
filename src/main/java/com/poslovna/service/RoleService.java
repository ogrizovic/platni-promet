package com.poslovna.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.users.access.Role;
import com.poslovna.repo.RoleRepo;
import com.poslovna.service.interfaces.CrudService;

@Service
public class RoleService implements CrudService<Role>{
	
	@Autowired
	private RoleRepo roleRepo;
	
	public RoleService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Role add(Role t) {
		return roleRepo.save(t);
	}

	@Override
	public Role getById(int id) {
		return roleRepo.findOne(id);
	}

	@Override
	public Set<Role> getAll() {
		return (Set<Role>) roleRepo.findAll();
	}

	@Override
	public Role update(Role t) {
		return roleRepo.save(t);
	}

	@Override
	public void delete(int id) {
		roleRepo.delete(id);
	}

	public Role getByRoleName(String name){
		return roleRepo.findByRoleName(name);
	}
}
