package com.filrouge.poe.lyon.JPAPOE.service;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;


public interface IClientService {
	List<Client> listeClients();
	void ajouterClient(Client c);
	void modifierClient(Client c);
	void supprimerClient(Client c);
	void retourneListeDevis(Client c);
	Client findClient(Integer i);
	List<Client> requetenamed(String requete);
	List<Client> requetenamed(String requete, Object...tab);
	void methode2retourneListeDevis(Client c);
}
