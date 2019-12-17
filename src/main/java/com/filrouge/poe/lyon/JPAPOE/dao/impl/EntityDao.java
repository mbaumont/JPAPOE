package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public abstract class EntityDao <T> {
	private Dao dao = null;
	
	public EntityDao(Dao dao) {
		super();
		this.dao = dao;
	}
	
	public T add(T p) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			em.persist(p); // INSERT
			em.getTransaction().commit(); // ne pas oublier de commit
			return (p);
		} finally {
			dao.closeEntityManager(em);
		}
	}
	public void update(T p) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			em.merge(p); // UPDATE
			em.getTransaction().commit(); // ne pas oublier de commit
		} catch(Exception e) {
			e.printStackTrace();	
		} finally {
			dao.closeEntityManager(em);
		}
	}
	
	public void remove(Class<T> eclass,Object pk) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager(); //begin transaction
			T p = em.find(eclass, pk); // securite il faut le faire dans une transaction
			em.remove(p); // on remove le bon beans c'est un DELETE
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeEntityManager(em);
		}
	}
	public T find(Class<T> eclass, Object pk) {
		EntityManager em = null; 
		try {
			em = dao.newEntityManager();
			return em.find(eclass, pk); // pas besoin de commit car on fait juste une recherche
		} finally {
			dao.closeEntityManager(em);
		}
	}
	public List<T> findAll(Class<T> eclass){
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			String query = "SELECT x FROM "+ eclass.getSimpleName() +" x";
			TypedQuery<T> x = em.createQuery(query, eclass);
			return x.getResultList();
		} finally {
			dao.closeEntityManager(em);
		}
	}
	
	public List<T> requeteNamed(Class<T> eclass, String requete){
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			TypedQuery<T> x = em.createNamedQuery(requete, eclass);
			return x.getResultList();
		} finally {
			dao.closeEntityManager(em);
		}
	}
	
	public List<T> requeteNamed(Class<T> eclass, String requete, Object...tab){
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			TypedQuery<T> q = em.createNamedQuery(requete, eclass);
			int i = 1; //sql commence par 1 
			for (Object p : tab) {
				q.setParameter(i,p);
				i++;
			}
			return q.getResultList();
		} finally {
			dao.closeEntityManager(em);
		}
	}
	
	public List<Object> requeteNamedOject(Class eclass,String requete, Object...tab) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			Query q = em.createNamedQuery(requete);
			int i = 1; //sql commence par 1 
			for (Object p : tab) {
				q.setParameter(i,p);
				i++;
			}
			return q.getResultList();
		} finally {
			dao.closeEntityManager(em);
		}
	}
}
