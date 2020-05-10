/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog2;;

/**
 *
 * @author 1629045
 */
public abstract class  Specimen {
    String nom;
    Double taille;
    String couleur;
    String date;
    String Personne;

    public Specimen(String nom, Double taille, String couleur, String date, String Personne) {
        this.nom = nom;
        this.taille = taille;
        this.couleur = couleur;
        this.date = date;
        this.Personne = Personne;
    }
    
    
}
