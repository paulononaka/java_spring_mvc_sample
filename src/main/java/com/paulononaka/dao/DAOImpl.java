package com.paulononaka.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DAOImpl<T> implements DAO<T> {
	
	protected Class<T> entityClass;

	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEntityManager() {
		return em;//EMF.get().createEntityManager();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DAOImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[0];
	}
	
	public void save(T entity) {
		EntityManager em = getEntityManager();
		em.merge(entity);
		//em.close();
	}
	
	public void remove(Long id) {
		EntityManager em = getEntityManager();
		T entity = em.find(entityClass, id);
		if (entity != null) {
			em.remove(entity);
		}
		//em.close();
	}

	public void remove(T entity) {
		EntityManager em = getEntityManager();
		em.remove(entity);
		//em.close();
	}

	public T findById(Long id) {
		EntityManager em = getEntityManager();
		return em.find(entityClass, id);
	}
}
