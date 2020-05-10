/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author 1629045
 */
class Pokedex {

    ArrayList<Personne> personnesList = new ArrayList();
    Encryption encrypted;
    Scanner sc = new Scanner(System.in);

    public Pokedex() {
        try {
            encrypted = new Encryption();
        } catch (Exception e) {
            System.out.println("erreur dans l'encryption");
        }
    }

    public void initialiser() {

        LireFichier();

        boolean authorized = login();

        if (authorized) {
            System.out.println("------------------------");
            System.out.println("\n\n");
            menu();
        } else {
            System.out.println("Vous n'êtes pas dans notre liste d'utilisateur. Au revoir");
            System.exit(0);
        }
    }

    public String decrypter() {
        String password = "yo";

        return password;

    }

    public void LireFichier() {
        BufferedReader lireLigne = null;
        try {

            lireLigne = new BufferedReader(new FileReader("personnes.txt"));

            String ligne;
            ligne = lireLigne.readLine();

            while (ligne != null) {
                String[] stringSplit = ligne.split(";");
                String nom = stringSplit[2];
                String passEncrypté = stringSplit[1];
                String codeAcces = stringSplit[0];
                int age = Integer.parseInt(stringSplit[3]);

                Personne personne = new Personne();

                String motDePasse = encrypted.decrypt(passEncrypté);

                personne.setNom(nom);
                personne.setCodeAcces(codeAcces);
                personne.setAge(age);
                personne.setMotDePasse(motDePasse);

                personnesList.add(personne);
                ligne = lireLigne.readLine();

            }

        } catch (IOException e) {
            System.out.println("Erreur fichier utilisateurs");
        }

    }

    public boolean login() {

        boolean authorized = false;
        int counter = 0;
        boolean authorisedTotal = false;
        boolean authorisedCodeAcces = false;
        boolean bonMotDePasse = false;
        String codeAccesEntre = null;
        int i = 0;
        String password = null;

        while (counter < 3 && authorized == false) {
            System.out.println("Entrez votre nom d'utilisateur: ");
            codeAccesEntre = sc.nextLine();

            for (i = 0; (i < personnesList.size()) && !authorisedCodeAcces; i++) {

                if (codeAccesEntre.equals(personnesList.get(i).getCodeAcces())) {
                    authorisedCodeAcces = true;

                    authorized = true;
                }
            }

            counter++;
        }

        if (authorisedCodeAcces) {

            System.out.println("------------------------");
            System.out.println("Bonjour " + codeAccesEntre + "\n------------------------" + "\nEntrez votre mot de passe");

            counter = 0;
            while (counter < 3 && bonMotDePasse == false) {

                if (counter == 0) {
                    password = sc.nextLine();
                } else {
                    System.out.println("Entrez votre mot de passe:");
                    password = sc.nextLine();
                }

                if ((personnesList.get(i - 1).getMotDePasse()).equals(password)) {
                    authorisedTotal = true;
                    bonMotDePasse = true;
                } else {
                    System.out.println("Mauvais mot de passe!");
                }

                counter++;
            }

        } else {
            System.out.println("nom d'utilisateur n'existe pas!");
        }

        return authorisedTotal;

    }

    public void menu() {
        while (true) {

            boolean erreur = true;
            int choix = 0;

            while (erreur) {
                System.out.println(
                        "   Pokedex v1.23:\n"
                        + "1- Consulter les spécimens déjà saisis\n"
                        + "2- Saisir un nouveau spécimen\n"
                        + "3- Modifier un spécimen\n"
                        + "4- Statistiques\n"
                        + "5- Quitter\n"
                        + "Choisissez une option: \n");

                try {
                    choix = Integer.parseInt(sc.nextLine());
                    erreur = false;
                } catch (NumberFormatException e) {
                    System.out.println("Entrez un nombre");
                }
            }

            switch (choix) {

                case 1:
                    while (!erreur) {
                    System.out.println("1-Afficher toutes les entrées\n"
                            + "2-Afficher toutes les entrées d’un seul type\n"
                            + "3-Afficher tous les animaux, triés par date croissante d’observation\n"
                            + "4-Retourner au menu principal\n");
                    
                    try {
                    choix = Integer.parseInt(sc.nextLine());
                    erreur = true;
                    } catch (NumberFormatException e) {
                    System.out.println("Entrez un nombre");
                }

                    }
                    switch (choix) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    while(erreur){
                    System.out.println("1-Supprimer un spécimen\n"
                            + "2-Modifier la quantité aperçue d’un spécimen donné\n"
                            + "3-Retourner au menu principal\n");
                   
                    try {
                    choix = Integer.parseInt(sc.nextLine());
                    erreur = false;
                    } catch (NumberFormatException e) {
                    System.out.println("Entrez un nombre");
                }
        }
                    switch (choix) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;

                    }
                    break;
                case 4:
                    while(!erreur){
                    System.out.println("1-Afficher le nombre d’entrées, pour chacun des types de spécimen\n"
                            + "2-Afficher le nombre d’entrées, pour chacune des personnes\n"
                            + "3-Afficher les informations des personnes du système (pas le mot de passe!)\n"
                            + "4-Retourner au menu principal\n");
                    try {
                    choix = Integer.parseInt(sc.nextLine());
                    erreur = true;
                    } catch (NumberFormatException e) {
                    System.out.println("Entrez un nombre");
                }
                    }
                    switch (choix) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }

                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }

}
