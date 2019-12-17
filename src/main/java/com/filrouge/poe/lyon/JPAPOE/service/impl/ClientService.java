package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.ClientDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;
import com.filrouge.poe.lyon.JPAPOE.service.IClientService;

public class ClientService implements IClientService {
	private IDao<Client> clientdao;
	
	public ClientService(Dao dao) {
		super();
		this.clientdao = new ClientDao(dao);
	}

	public List<Client> listeClients() {
		return this.clientdao.all();
	}

	public void ajouterClient(Client c) {
		this.clientdao.ajouter(c);
	}

	public void modifierClient(Client c) {
		// TODO Auto-generated method stub

	}

	public void supprimerClient(Client c) {
		this.clientdao.supprimer(c);

	}

	public Client findClient(Integer i) {
		return this.clientdao.find(i);
	}

	@Override	
	public List<Client> requetenamed(String n) {
		return this.clientdao.requetenamed(n);
	}

	@Override
	public List<Client> requetenamed(String requete, Object... tab) {
		return this.clientdao.requetenamed(requete, tab);
	}

	@Override
	public void retourneListeDevis(Client c) {
		clientdao.retourneListeDevis(c).
		stream().forEach(x->System.out.println("Devis "+x.getId()+" " +x.getDatecreation()));
	}
	
	public void methode2retourneListeDevis(Client c) {
	clientdao.requetenamed(Devis.class, "Client.findDevis", c.getId())
				.stream().forEach(x->System.out.println("Devis "+((Devis)x).getId()+" " +((Devis)x).getDatecreation()));
	}
}
