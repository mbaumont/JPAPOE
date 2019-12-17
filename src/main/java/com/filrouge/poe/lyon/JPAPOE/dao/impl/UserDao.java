package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;
import com.filrouge.poe.lyon.JPAPOE.model.User;

public class UserDao extends EntityDao<User> implements IDao<User> {

	public UserDao(Dao dao) {
		super(dao);
	}

	@Override
	public List<User> all() {
		return this.findAll(User.class);
	}

	@Override
	public void ajouter(User t) {
		this.add(t);
		
	}

	@Override
	public void modifier(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(User t) {
		this.remove(User.class, t.getId());
		
	}

	@Override
	public User find(Object o) {
		return this.find(User.class, (Integer)o);
	}

	@Override
	public List<User> requetenamed(String requete) {
		return this.requeteNamed(User.class, requete);
	}

	@Override
	public List<User> requetenamed(String requete, Object... tab) {
		return this.requeteNamed(User.class, requete, tab);
	}

	@Override
	public List<Devis> retourneListeDevis(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> requetenamed(Class c, String requete, Object... tab) {
		// TODO Auto-generated method stub
		return null;
	}

}
