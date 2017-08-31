package com.applicaion.pharmacie.testv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Carly Baja on 8/24/2017.
 */

public class Personne {

    private String nom;
    private String prenom;

    public Personne(){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public static ArrayList<Personne> fromListMap(List<Map> map) {
        ArrayList<Personne> personnes = new ArrayList();
        for(int i = 0; i < map.size(); i++) {
            Personne p = new Personne();
            p.setNom((String) map.get(i).get("nom"));
            p.setPrenom((String) map.get(i).get("prenom"));
            personnes.add(p);
        }
        return personnes;
    }
}


