package ca.qc.bdeb.info202;

public class Arbre {

    private int taille;

    public enum Nom {
        graine,
        petit,
        moyen,
        grand,
        couper;
    }
    private Nom nom;
    private int ligne, colonne;
    private String etat;


    public Arbre(int taille, Nom nom, String etat) {
        this.taille = taille;
        this.nom = nom;
        this.etat = etat;
    }

    public void afficherValeur() {
        System.out.println(nom);
    }

    public String getEtat() {
       return etat;
    }
    
    public int getTaille(){
    return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    
}
