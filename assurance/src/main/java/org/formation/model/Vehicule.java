package org.formation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Vehicule {

    private int valeur;
    @JsonProperty("Puissance")
    private int puissance;
    @JsonProperty("TypeCarburant")
    private int typeCarburant;
    @JsonProperty("toto")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String miseEnCirculation;

    public Vehicule(int valeur, int puissance, int typeCarburant, String miseEnCirculation) {
        this.valeur = valeur;
        this.puissance = puissance;
        this.typeCarburant = typeCarburant;
        this.miseEnCirculation = miseEnCirculation;
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

    public int getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(int typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public String getMiseEnCirculation() {
        return miseEnCirculation;
    }

    public void setMiseEnCirculation(String miseEnCirculation) {
        this.miseEnCirculation = miseEnCirculation;
    }
}
