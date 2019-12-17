package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Dao {
	private static EntityManagerFactory factory = null;
	
	public void init() {
		factory = Persistence.createEntityManagerFactory("bddFILROUGE");
	}
	
	public void close() {
		if (factory != null) {
			factory.close();
		}
	}
	
	// Créer un EM et ouvrir une transaction
	public EntityManager newEntityManager() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		return (em);
	}
	
	public void closeEntityManager(EntityManager em) {
		if (em != null) {
			if(em.isOpen()) {
				EntityTransaction t = em.getTransaction();
				if (t.isActive()) {
					try {
						t.rollback();
					} catch (PersistenceException e) {
						e.printStackTrace();
					}
				}
				em.close();
			}
		}
	}
}
