/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog2;

/**
 *
 * @author 1629045
 */
public abstract class Animal extends Specimen{
    
    public Animal(String nom, Double taille, String couleur, String date, String Personne) {
        super(nom, taille, couleur, date, Personne);
    }
    public void Cri(){
        
    }
}
