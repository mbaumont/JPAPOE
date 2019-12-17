package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;


public class DevisDao extends EntityDao<Devis> implements IDao<Devis> {

	public DevisDao(Dao dao) {
		super(dao);
	}

	@Override
	public List<Devis> all() {
		return this.findAll(Devis.class);
	}

	@Override
	public void ajouter(Devis t) {
		this.add(t);
		
	}

	@Override
	public void modifier(Devis t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(Devis t) {
		this.remove(Devis.class, t.getId());
		
	}

	@Override
	public Devis find(Object o) {
		return this.find(Devis.class, (Integer)o);
	}

	@Override
	public List<Devis> requetenamed(String requete) {
		return this.requeteNamed(Devis.class, requete);
	}

	@Override
	public List<Devis> requetenamed(String requete, Object... tab) {
		return this.requeteNamed(Devis.class, requete, tab);
	}

	@Override
	public List<Devis> retourneListeDevis(Devis t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> requetenamed(Class c, String requete, Object... tab) {
		// TODO Auto-generated method stub
		return null;
	}

}
