package org.formation.model;

public class Conducteur {

	private int age, incidents, anciennete;
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
	
}
