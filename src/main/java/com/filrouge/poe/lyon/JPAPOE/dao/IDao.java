package com.filrouge.poe.lyon.JPAPOE.dao;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.model.Devis;

public interface IDao<T> {

	List<T> all();
	void ajouter(T t);
	void modifier(T t);
	void supprimer(T t);
	List<Devis> retourneListeDevis(T t);
	T find(Object o);
	List<T> requetenamed(String requete);
	List<T> requetenamed(String requete, Object...tab);
	List<Object> requetenamed(Class c,String requete, Object...tab);
}