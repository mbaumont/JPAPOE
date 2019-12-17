package com.filrouge.poe.lyon.JPAPOE;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;
import com.filrouge.poe.lyon.JPAPOE.model.User;
import com.filrouge.poe.lyon.JPAPOE.model.Vehicule;
import com.filrouge.poe.lyon.JPAPOE.service.IClientService;
import com.filrouge.poe.lyon.JPAPOE.service.IDevisService;
import com.filrouge.poe.lyon.JPAPOE.service.IUserService;
import com.filrouge.poe.lyon.JPAPOE.service.IVehiculeService;
import com.filrouge.poe.lyon.JPAPOE.service.impl.ClientService;
import com.filrouge.poe.lyon.JPAPOE.service.impl.DevisService;
import com.filrouge.poe.lyon.JPAPOE.service.impl.UserService;
import com.filrouge.poe.lyon.JPAPOE.service.impl.VehiculeService;

public class TestDao {
	private static Dao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new Dao();
		dao.init();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao.close();
	}


	public void testfindclient() {
		IClientService clientservice = new ClientService(dao);
		System.out.println(clientservice.findClient(1));
	}
	
 
	public void testlistClients() {
		IClientService clientservice = new ClientService(dao);
		System.out.println(clientservice.listeClients());
		
	}
	
	//@Test 
	public void testAjoutDevis() {
		try {
			IUserService userservice = new UserService(dao);
			IVehiculeService vehiculeservice = new VehiculeService(dao);
			IClientService clientservice = new ClientService(dao);
			Devis d = new Devis();
			User user = userservice.findUser(1);
			Vehicule vehicule = vehiculeservice.findVehicule(2);
			Client client = clientservice.findClient(3);
			d.setDatecreation(new Date());
			d.setEtat(true);
			d.setUser(user);
			d.setVehicule(vehicule);
			d.setClient(client);
			IDevisService devisservice = new DevisService(dao);
			devisservice.ajouterDevis(d);
			System.out.println(devisservice.listeDevis());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//@Test
	public void testNamedDevis() {
		IDevisService devisservice = new DevisService(dao);
		devisservice.requetenamed("Devis.findAll").
		stream().forEach(System.out::println);	
	}	

	@Test
	public void testAfficheFiche() {
		IDevisService devisservice = new DevisService(dao);
		devisservice.afficheFiche(3,"vehicule");
	}	
	
	//@Test
	public void testNamedParamDevis() {
		IDevisService devisservice = new DevisService(dao);
		devisservice.requetenamed("Devis.findByClient",3).
		stream().forEach(System.out::println);	
	}
	
	public void testNamedClient() {
		IClientService clientservice = new ClientService(dao);
		clientservice.requetenamed("Client.findAll").
		stream().forEach(System.out::println);	
	}
	
	@Test
	public void testretourneDevisClient() {
		IClientService clientservice = new ClientService(dao);
		Client c = clientservice.findClient(1);
		//clientservice.retourneListeDevis(c);
		clientservice.methode2retourneListeDevis(c);
	}
	
	public void testNamedParamClient() {
		IClientService clientservice = new ClientService(dao);
		clientservice.requetenamed("Client.findByName","C%").
		stream().forEach(System.out::println);
	}
	/*
	@Test
	public void testAjoutUser() {
		try {
			User u = new User();
			u.setFirstName("Guillaume");
			u.setLastName("Godefroy");
			u.setLogin("godefroy");
			u.setPassword("1235");
			IUserService userservice = new UserService(dao);
			userservice.ajouterUser(u);
			System.out.println(userservice.listeUsers());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test 
	public void testAjoutClient() {
		try {
			Client c = new Client();
			c.setName("Baumont");
			c.setAdresse("19 avenue maréchal randon");
			c.setVille("Grenoble");
			c.setCodepostal("38000");
			c.setFirstname("Marie");
			c.setPortable("0695014809");
			c.setTel("");
	
			IClientService clientservice = new ClientService(dao);
			clientservice.ajouterClient(c);
			System.out.println(clientservice.listeClients());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testSupprimerClient() {
		
		IClientService clientservice = new ClientService(dao);	 
		Client c = clientservice.findClient(2);
		if (c!=null) {
			clientservice.supprimerClient(c);
			System.out.println(clientservice.listeClients());
		}}

	@Test 
	public void testFindVehicule() {
		IVehiculeService vehiculeservice = new VehiculeService(dao);
		System.out.println(vehiculeservice.findVehicule(1));
		
	}
	
	@Test
	public void testAjoutVehicule() {
		Vehicule v = new Vehicule();
		v.setModele("Citroen");
		v.setQuantite(10);
		v.setDateCreation(new Date());
		IVehiculeService vehiculeservice = new VehiculeService(dao);
		vehiculeservice.ajouterVehicule(v);
		System.out.println(vehiculeservice.listeVehicules());
	}
	
	@Test
	public void testSupprimerVehicule() {
		IVehiculeService vehiculeservice = new VehiculeService(dao);
		Vehicule v = vehiculeservice.findVehicule(3);
		if (v!=null) {
			vehiculeservice.supprimerVehicule(v);
			System.out.println(vehiculeservice.listeVehicules());
		}
	}
	*/
}
