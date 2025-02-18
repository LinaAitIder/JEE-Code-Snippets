package com;

public class Person {
	private String name;
	private double taille;
	private double poids;
	
	public void setName(String name) {
		this.name= name;
		
	}
	public void setTaille(double taille) {
			this.taille = taille;
	}
	
	public void setPoids(double poids) {
			this.poids = poids;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getTaille() {
		return  this.taille;
	}
	
	public double getPoids() {
		return  this.poids;
	}
	
	public double getFit() {
		return this.poids/(this.taille*this.taille);
	}
}
