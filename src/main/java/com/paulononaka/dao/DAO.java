package com.paulononaka.dao;

public interface DAO<T> {
	
	void save(T entity);

	void remove(T entity);

	T findById(Long id);
}
