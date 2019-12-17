package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.VehiculeDao;
import com.filrouge.poe.lyon.JPAPOE.model.Vehicule;
import com.filrouge.poe.lyon.JPAPOE.service.IVehiculeService;

public class VehiculeService implements IVehiculeService {
	private IDao<Vehicule> vehiculedao;

	public VehiculeService(Dao dao) {
		super();
		this.vehiculedao = new VehiculeDao(dao);
	}

	public List<Vehicule> listeVehicules() {
		return this.vehiculedao.all();
	}

	public void ajouterVehicule(Vehicule v) {
		this.vehiculedao.ajouter(v);

	}

	public void modifierVehicule(Vehicule v) {
		// TODO Auto-generated method stub

	}

	public void supprimerVehicule(Vehicule v) {
		this.vehiculedao.supprimer(v);

	}

	public Vehicule findVehicule(Integer i) {
		return this.vehiculedao.find(i);

	}

}
