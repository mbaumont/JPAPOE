package com.filrouge.poe.lyon.JPAPOE.service;

import java.util.List;


import com.filrouge.poe.lyon.JPAPOE.model.User;

public interface IUserService {

	
	List<User> listeUsers();
	void ajouterUser(User u);
	void modifierUser(User u);
	void supprimerUser(User u);
	User findUser(Integer i);
	List<User> requetenamed(String requete);
	List<User> requetenamed(String requete, Object...tab);
}


