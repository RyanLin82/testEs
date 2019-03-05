package org.cmsideproject.miverva.service;

import java.util.Collection;

public interface CRUDService<T> {
	public void insert(String data);

	public Collection<T> getAll();

	public void deleteById(String id);

	public T getById(String id);
	
	public void update(String data);
}
