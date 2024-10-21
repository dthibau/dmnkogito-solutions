package org.formation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Conducteur {

	@JsonProperty("Age")
	private int age;
	@JsonProperty("Incidents")
	int incidents;
	@JsonProperty("ancienneté")
	int anciennete;
	@JsonProperty("Vehicule")
	private Vehicule vehicule;

	public Conducteur(int age, int anciennete, int incidents , Vehicule vehicule) {
		this.age = age;
		this.anciennete = anciennete;
		this.incidents = incidents;
		this.vehicule = vehicule;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIncidents() {
		return incidents;
	}

	public void setIncidents(int incidents) {
		this.incidents = incidents;
	}

	public int getAnciennete() {
		return anciennete;
	}

	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
}
