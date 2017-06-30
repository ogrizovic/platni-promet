package com.poslovna.service.interfaces;

import java.util.Collection;

public interface CrudService<T> {

	public T add(T t);
	public T getById(int id);
	public Collection<T> getAll();
	public T update(T t);
	public void delete(int id);
}
