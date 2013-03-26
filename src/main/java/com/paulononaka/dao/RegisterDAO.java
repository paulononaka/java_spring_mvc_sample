package com.paulononaka.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.paulononaka.model.Register;

@Component
public class RegisterDAO extends DAOImpl<Register> {

	@SuppressWarnings("unchecked")
	public List<Register> findAll() {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("select from " + Register.class.getName());
		return q.getResultList();
	}

}