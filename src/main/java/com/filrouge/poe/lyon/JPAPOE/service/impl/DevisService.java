package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.DevisDao;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;
import com.filrouge.poe.lyon.JPAPOE.service.IDevisService;

public class DevisService implements IDevisService {
	private IDao<Devis> devisdao;
	
	
	public DevisService(Dao dao) {
		super();
		this.devisdao = new DevisDao(dao);
	}

	@Override
	public List<Devis> listeDevis() {
		return this.devisdao.all();
	}

	@Override
	public void ajouterDevis(Devis u) {
		this.devisdao.ajouter(u);
		
	}

	@Override
	public void modifierDevis(Devis u) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void afficheFiche(Integer i, String TypeRequest ){
		Devis devis = this.findDevis(i);
		switch(TypeRequest) {
		case("client"): 
			System.out.println(devis.getClient().toString());
			break;
		case("user"): 
			System.out.println(devis.getUser().toString());
			break;
		case("vehicule"): 
			System.out.println(devis.getVehicule().toString());
			break;
		}
		
	}
	@Override
	public void supprimerDevis(Devis u) {
		this.devisdao.supprimer(u);
	}

	@Override
	public Devis findDevis(Integer i) {
		return this.devisdao.find(i);
	}

	@Override
	public List<Devis> requetenamed(String requete) {
		return this.devisdao.requetenamed(requete);
	}

	@Override
	public List<Devis> requetenamed(String requete, Object... tab) {
		return this.devisdao.requetenamed(requete, tab);
	}

}
