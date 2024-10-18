package org.formation.model;

public class Vehicule {

    private int valeur;
    private int puissance;
    private TypeCarburant typeCarburant;

    public Vehicule(int valeur, int puissance, TypeCarburant typeCarburant) {
        this.valeur = valeur;
        this.puissance = puissance;
        this.typeCarburant = typeCarburant;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public TypeCarburant getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(TypeCarburant typeCarburant) {
        this.typeCarburant = typeCarburant;
    }
}
