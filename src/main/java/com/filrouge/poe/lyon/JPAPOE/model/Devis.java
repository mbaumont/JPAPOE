package com.filrouge.poe.lyon.JPAPOE.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

@Table(name = "devis") // SQL pas case sensitive
@NamedQueries(value =
{
	@NamedQuery( name = "Devis.findAll",
	query = "SELECT dev FROM Devis AS dev"),
	@NamedQuery( name = "Devis.findByClient",
	query = "SELECT dev FROM Devis AS dev WHERE dev.client.id like ?1")
})

public class Devis {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_creation",  nullable = false)
	private Date datecreation;

	@Column(name="etatdevis", nullable = false)
	private Boolean etat;
	
	@ManyToOne
	@JoinColumn(name="id_user",  nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_vehicule",nullable = false)
	private Vehicule vehicule;
	
	/**
	 * On décrit une jointure objet entre la colonne id_client et le beans Client 
	 * avec sa clée KP @ID c'est une jointure objet
	 */
	
	@ManyToOne
	@JoinColumn(name="id_client",  nullable = false)
	private Client client;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDatecreation() {
		return datecreation;
	}


	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}


	public Boolean getEtat() {
		return etat;
	}


	public void setEtat(Boolean etat) {
		this.etat = etat;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Vehicule getVehicule() {
		return vehicule;
	}


	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Devis [id=" + id + ", datecreation=" + datecreation + ", etat=" + etat + ", user=" + user
				+ ", vehicule=" + vehicule + ", client=" + client + "]";
	}


		
	
	
}
