package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.UserDao;
import com.filrouge.poe.lyon.JPAPOE.model.User;
import com.filrouge.poe.lyon.JPAPOE.service.IUserService;

public class UserService implements IUserService {
	private IDao<User> userdao;
	
	
	public UserService(Dao dao) {
		super();
		this.userdao = new UserDao(dao);
	}

	@Override
	public List<User> listeUsers() {
		return this.userdao.all();
	}

	@Override
	public void ajouterUser(User u) {
		this.userdao.ajouter(u);
		
	}

	@Override
	public void modifierUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUser(User u) {
		this.userdao.supprimer(u);
		
	}

	@Override
	public User findUser(Integer i) {
		return this.userdao.find(i);
	}

	@Override
	public List<User> requetenamed(String requete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> requetenamed(String requete, Object... tab) {
		// TODO Auto-generated method stub
		return null;
	}

}
