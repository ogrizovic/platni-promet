package com.poslovna.service.interfaces;

import java.util.Set;

import com.poslovna.model.users.access.User;

public interface CrudService<T> {

	public T add(T t);
	public T getById(int id);
	public Set<T> getAll();
	public T update(T t);
	public void delete(int id);
}
