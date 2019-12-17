package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;
import com.filrouge.poe.lyon.JPAPOE.model.Vehicule;

public class VehiculeDao extends EntityDao<Vehicule> implements IDao<Vehicule> {
	
		public VehiculeDao(Dao dao) {
			super(dao);

		}
	
		public List<Vehicule> all() {
			return this.findAll(Vehicule.class);
		}
		public void ajouter(Vehicule t) {
			this.add(t);

		}
		public void modifier(Vehicule t) {
			// TODO Auto-generated method stub
			
		}
		public void supprimer(Vehicule t) {
			this.remove(Vehicule.class, t.getId());
		}
		public Vehicule find(Object o) {
			return this.find(Vehicule.class, (Integer)o);
		}

		@Override
		public List<Vehicule> requetenamed(String requete) {
			return this.requeteNamed(Vehicule.class, requete);
		}

		@Override
		public List<Vehicule> requetenamed(String requete, Object... tab) {
			return this.requeteNamed(Vehicule.class, requete, tab);
		}

		@Override
		public List<Devis> retourneListeDevis(Vehicule t) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Object> requetenamed(Class c, String requete, Object... tab) {
			// TODO Auto-generated method stub
			return null;
		}


	}