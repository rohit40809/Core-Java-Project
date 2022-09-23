package com.training.project.ifaces;

import java.util.List;

public interface CrudRepository<T>{
	public boolean save(T obj);
	public List<T> findAll();
}
