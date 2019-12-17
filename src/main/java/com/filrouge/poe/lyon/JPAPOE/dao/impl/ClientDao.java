package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;

public class ClientDao extends EntityDao<Client> implements IDao<Client> {

	public ClientDao(Dao dao) {
		super(dao);

	}

	public List<Client> all() {
		return this.findAll(Client.class);
	}

	public void ajouter(Client c) {
		this.add(c);

	}

	public void modifier(Client t) {
		// TODO Auto-generated method stub
		
	}

	public void supprimer(Client c) {
		this.remove(Client.class, c.getId());
	}

	public Client find(Object o) {
		return this.find(Client.class,(Integer)o);
	}
	public List<Devis> retourneListeDevis(Client c) {
		return c.getListeDevis();
	}
	
	public List<Client> requetenamed(String requete) {

		return this.requeteNamed(Client.class, requete);
	}

	public List<Client> requetenamed(String requete, Object... tab) {
		return this.requeteNamed(Client.class, requete, tab);
	}

	@Override
	public List<Object> requetenamed(Class c, String requete, Object... tab) {
		// TODO Auto-generated method stub
		return this.requeteNamedOject(c, requete, tab);
	}


}
