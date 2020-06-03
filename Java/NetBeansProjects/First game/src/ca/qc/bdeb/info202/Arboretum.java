package ca.qc.bdeb.info202;

import ca.qc.bdeb.info202.Arbre.Nom;
import static ca.qc.bdeb.info202.Arbre.Nom.couper;
import static ca.qc.bdeb.info202.Arbre.Nom.graine;
import static ca.qc.bdeb.info202.Arbre.Nom.petit;
import static ca.qc.bdeb.info202.Arbre.Nom.moyen;
import static ca.qc.bdeb.info202.Arbre.Nom.grand;
import static ca.qc.bdeb.info202.Soleil.Position.Nord;
import static ca.qc.bdeb.info202.Soleil.Position.Est;
import static ca.qc.bdeb.info202.Soleil.Position.Sud;
import static ca.qc.bdeb.info202.Soleil.Position.Ouest;
import java.util.Scanner;

public class Arboretum {

    private Scanner scanner = new Scanner(System.in);
    private Arbre[][] tab = new Arbre[5][6];  //cree un tableau 2d
    private Soleil soleil = new Soleil(Nord); //crée le soleil
    private int joueurCourant = 1;  //Le joueur courant
    private int round = 1; //le tour
    private boolean roundPlusUn = false;
    private Chlorophylle joueurA = new Chlorophylle(0, 0, 0);
    private Chlorophylle joueurB = new Chlorophylle(0, 0, 0);
    private boolean[][] tableau = new boolean[5][6];
    private int[][] pointW = new int[5][6];

    public void jouer() {

        int pointVictoire = 0;

        remplirTab();  //appele une methode qui cree les 2 premiers arbres
        joueurCourant = 1; //commence avec le joueur 1

        boolean phase1 = true;
        boolean continuer = true;

        while (round <= 12) {

            for (int i = 0; i < tableau.length; i++) {
                for (int j = 0; j < tableau[i].length; j++) {
                    tableau[i][j] = true;
                }
            }

            while (continuer) {

                if (phase1) {
                    ensoleilement(soleil); //phase1 qui est l'ensoleilement des arbres
                    phase1 = false;
                }

                afficherTab(soleil); //Affiche l'arboretum avec le soleil a sa position corespondante
                Arbre arbre = new Arbre(0, petit, "a");

                System.out.println("round: " + round);//Augmente le tour de 1 a chauqe fois

                int reponse = afficherMenu(); //Affiche les choix de l'utilisateur

                if (!phase1) {
                    switch (reponse) {
                        case 1:

                            if (joueurCourant == 1) { //Si joueur 1 plante une graine, elle diminue sa chlorophylle de sa banque
                                if (joueurA.getCapital() >= 1) {
                                    joueurA.setCapital(joueurA.getCapital() - 1);
                                    arbre = semerArbre(scanner);
                                    System.out.println("");
                                } else {
                                    System.out.println("Erreur, vous n'avez pas assez de chlorophylle"); //Si le joueur ! n'a pas assez d'argent
                                }

                            } else {
                                if (joueurB.getCapital() >= 1) { //Sinon joueur 1 plante une graine, elle diminue sa chlorophylle de sa banque
                                    arbre = semerArbre(scanner);
                                    System.out.println("");
                                } else {
                                    System.out.println("Erreur, vous n'avez pas assez de chlorophylle"); //Si le joueur ! n'a pas assez d'argent
                                }
                            }
                            break;

                        case 2:

                            changerEtatArbre(arbre); //Methode qui aggrandit les arbres

                            break;
                        case 3:
                            couperArbreMature(pointVictoire); //methode qui coupe les arbres
                            break;

                        case 4:
                            phase1 = changerJoueur(phase1); //Methodes qui change le joueur
                            break;

                        case 5:
                            System.exit(0); //:):)
                            break;
                    }

                }
            }
        }

    }

    private boolean changerJoueur(boolean phase1) {

        //Fait en sorte que chaque tour 2 joueur joue et round +=1;
        if (round <= 12) {
            if (joueurCourant == 1) {
                joueurCourant = 2;
                for (int i = 0; i < tableau.length; i++) {
                    for (int j = 0; j < tab[i].length; j++) {
                        tableau[i][j] = true;
                    }
                }
            } else {
                joueurCourant = 1;
                soleil = positionSoleil(round);
                round += 1;
                enleveLeX();
                permitionGrandir();

                for (int i = 0; i < tableau.length; i++) {
                    for (int j = 0; j < tab[i].length; j++) {
                        tableau[i][j] = true;
                    }
                }
                phase1 = true;

            }
        }

        if (joueurA.getPointVictoire() > joueurB.getPointVictoire()) {
            System.out.print("Le gagnant est:");
            System.out.println("le joueur 1");
        } else if (joueurA.getPointVictoire() < joueurB.getPointVictoire()) {
            System.out.print("Le gagnant est:");
            System.out.println("le joueur 2");
        } else {
            System.out.println("Égalite :(");
        }

        boolean continuerBro = false;

        if (round > 12) {
            do {
                int reponse = 0;

                System.out.println("Voulez-vous continuez?");
                System.out.println("1-Oui");
                System.out.println("N'importe quoi pour non");

                boolean erreur = true;

                while (erreur) {
                    try {
                        reponse = Integer.parseInt(scanner.nextLine());
                        erreur = false;
                    } catch (NumberFormatException ee) {
                        System.exit(0);
                    }
                }

                if (reponse == 1) {
                    for (Arbre[] tab1 : tab) {
                        for (int j = 0; j < tab1.length; j++) {
                            tab1[j] = null;
                        }
                        remplirTab();
                    }
                    round = 1;
                } else {
                      System.out.println("Le jeu est fini");
                System.exit(0);
                }

              

            } while (continuerBro);
        }

        return phase1;
    }

    private void remplirTab() {

        Arbre arbre1 = new Arbre(1, petit, "A"); //cree le premiere arbre
        tab[1][0] = arbre1; //le pose a sa position

        Arbre arbre2 = new Arbre(1, petit, "B"); //cree le deuxieme arbre
        tab[3][5] = arbre2; //le pose sa la position 

    }

    private int afficherMenu() {
        int reponse = 0;
        boolean erreur = true;
        //Affiche le menu et demande le choix du joueur
        System.out.println("Salut Joueur " + joueurCourant);

        System.out.println("");
        System.out.println("********************************************************");
        System.out.println("Menu");
        System.out.println("1) Semer une graine (coût de 1Θ)");
        System.out.println("2) Faire pousser un arbre (coût variant entre 1Θ et 3Θ)");
        System.out.println("3) Couper un arbre mature (coût de 4Θ)");
        System.out.println("4) Terminer son tour");
        System.out.println("5) Quitter le jeu");
        System.out.println("********************************************************");

        while (erreur) {

            try {
                do {

                    reponse = Integer.parseInt(scanner.nextLine());

                    if (reponse <= 0 || reponse > 5) {
                        System.out.println("erreur, chosissez une bonne reponse");
                    }

                } while (reponse <= 0 || reponse > 5);

                erreur = false;
            } catch (NumberFormatException ee) {
                System.out.println("erreur, entrez un nombre");
            }
        }
        return reponse;
    }

    private Arbre semerArbre(Scanner scanner) {

        //Arbre arbre = new Arbre(0, graine, "a");
        System.out.println(joueurA.getCapital());
        System.out.println(joueurB.getCapital());

        System.out.println("Position:");
        boolean erreur = true;

        while (erreur) {

            erreur = true;
            int ligne = 0;
            int colonne = 0;
            int i = 0;
            boolean caseValide = false;

            try {
                do {

                    i += 1;
                    if (i >= 2) {
                        System.out.println("erreur, choisissez une case vide");
                    }
                    System.out.print("-Ligne ( entre 1 et 5): ");

                    boolean erreur1 = true;

                    while (erreur1) {
                        try {
                            ligne = Integer.parseInt(scanner.nextLine());
                            erreur1 = false;
                        } catch (NumberFormatException ee) {
                            System.out.println("erreur, choisissez un nombre");
                        }
                    }

                    System.out.print("-Colonne ( entre 1 et 6): ");

                    while (!erreur1) {
                        try {
                            colonne = Integer.parseInt(scanner.nextLine());
                            erreur1 = true;
                        } catch (NumberFormatException ee) {
                            System.out.println("erreur, choisissez un nombre");
                        }
                    }

                } while (tab[ligne - 1][colonne - 1] != null); //Tanque la position n'est pas null l'utilisateur ne peut chosir une ligne

                if (joueurCourant == 1) {

                    int li = ligne - 1;
                    int col = colonne - 1;

                    boolean continuer = true;

                    while (continuer) {

                        for (i = li - 2; i <= li + 2 && i < tab.length; i++) { //Si il n'y a pas d'arbre dans les position permisent l'utilisateur ne pourra planter

                            while (i < 0) {
                                i++;
                            }

                            if (tab[i][col] != null && ("A".equals(tab[i][col].getEtat()) || "AA".equals(tab[i][col].getEtat()) || "AAA".equals(tab[i][col].getEtat()))) {

                                Arbre arbre = new Arbre(0, graine, "a");
                                tab[li][col] = arbre;
                                return arbre;

                            } else {
                                continuer = false;
                            }

                        }
                    }

                    for (int j = col - 2; j <= col + 2 && j < tab[ligne - 1].length; j++) { //Si il n'y a pas d'arbre dans les position permisent l'utilisateur ne pourra planter

                        while (j < 0) {
                            j++;
                        }

                        if (tab[li][j] != null && ("A".equals(tab[li][j].getEtat()) || "AA".equals(tab[li][j].getEtat()) || "AAA".equals(tab[li][j].getEtat()))) {
                            Arbre arbre = new Arbre(0, graine, "a");
                            tab[li][col] = arbre;
                            return arbre;
                        }

                    }

                } else {

                    int li = ligne - 1;
                    int col = colonne - 1;

                    boolean continuer = true;

                    while (continuer) {

                        for (i = li - 2; i <= li + 2 && i < tab.length; i++) { //Si il n'y a pas d'arbre dans les position permisent l'utilisateur ne pourra planter

                            while (i < 0) {
                                i++;
                            }

                            if (tab[i][col] != null && ("B".equals(tab[i][col].getEtat()) || "BB".equals(tab[i][col].getEtat()) || "BBB".equals(tab[i][col].getEtat()))) {

                                Arbre arbre = new Arbre(0, graine, "b");
                                tab[li][col] = arbre;
                                return arbre;

                            } else {
                                continuer = false;
                            }

                        }
                    }

                    for (int j = col - 2; j <= col + 2 && j < tab[ligne - 1].length; j++) { //Si il n'y a pas d'arbre dans les position permisent l'utilisateur ne pourra planter

                        while (j < 0) {
                            j++;
                        }

                        if (tab[li][j] != null && ("B".equals(tab[li][j].getEtat()) || "BB".equals(tab[li][j].getEtat()) || "BBB".equals(tab[li][j].getEtat()))) {
                            Arbre arbre = new Arbre(0, graine, "b");
                            tab[li][col] = arbre;
                            return arbre;
                        }

                    }
                }

                erreur = false;

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Erreur, chosir une bonne position");
            }
        }

        return null;
    }

    private void afficherTab(Soleil soleil) {

        System.out.println(soleil.getPosition());
        switch (soleil.getPosition()) {

            case Nord:
                System.out.println("");
                System.out.println("                    (-)           ");  //le soleil pour le nord
                System.out.println("");
                System.out.println("");
                System.out.println("");

                for (int i = 0; i < tab.length; i++) {

                    if (i == 0) {
                        System.out.print("  ");
                        for (int k = 0; k <= tab.length; k++) {

                            System.out.printf("%6d", (k + 1)); //affiche les numeros de la case des colonnes 
                        }

                        System.out.println("");
                    }
                    System.out.println("    -----------------------------------");

                    for (int j = 0; j < tab[i].length; j++) {

                        if (j == 0) {
                            System.out.print((i + 1)); //affiche les numeros des lignes
                        }
                        System.out.printf("%3s", "|"); //cree 3 espaces qui vont disparaitre lorsqu'on ajoute les arbres

                        if (tab[i][j] != null) {
                            System.out.printf("%3s", tab[i][j].getEtat());
                        } else {
                            System.out.printf("%3s", "  ");
                        }

                    }
                    System.out.println("  |");
                    System.out.print("");
                }
                System.out.println("    -----------------------------------");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;
            case Est:

                for (int i = 0; i < tab.length; i++) {

                    if (i == 0) {
                        System.out.print("  ");
                        for (int k = 0; k <= tab.length; k++) {

                            System.out.printf("%6d", (k + 1)); //affiche les numeros de la case des colonnes 
                        }

                        System.out.println("");
                    }
                    System.out.println("    -----------------------------------");

                    for (int j = 0; j < tab[i].length; j++) {

                        if (j == 0) {
                            System.out.print((i + 1)); //affiche les numeros des lignes
                        }
                        System.out.printf("%3s", "|"); //cree 5 espaces qui vont disparaitre lorsqu'on ajoute les arbres

                        if (tab[i][j] != null) {

                            System.out.printf("%3s", tab[i][j].getEtat());
                        } else {
                            System.out.printf("%3s", "  ");
                        }
                    }
                    if (i == 2) {
                        System.out.println("  |          (-)");
                    } else {
                        System.out.println("  |");
                    }

                    System.out.print("");

                }

                System.out.println("    -----------------------------------");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;
            case Sud:

                for (int i = 0; i < tab.length; i++) {

                    if (i == 0) {
                        System.out.print("  ");
                        for (int k = 0; k <= tab.length; k++) {

                            System.out.printf("%6d", (k + 1)); //affiche les numeros de la case des colonnes 
                        }

                        System.out.println("");
                    }
                    System.out.println("    -----------------------------------");
                    for (int j = 0; j < tab[i].length; j++) {

                        if (j == 0) {
                            System.out.print((i + 1)); //affiche les numeros des lignes
                        }
                        System.out.printf("%3s", "|"); //cree 5 espaces qui vont disparaitre lorsqu'on ajoute les arbres

                        if (tab[i][j] != null) {
                            System.out.printf("%3s", tab[i][j].getEtat());
                        } else {
                            System.out.printf("%3s", "  ");
                        }

                    }
                    System.out.println("  |");
                    System.out.print("");
                }
                System.out.println("    -----------------------------------");

                System.out.println("");
                System.out.println("");
                System.out.println("");

                System.out.println("                    (-)           ");

                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;
            case Ouest:
                for (int i = 0; i < tab.length; i++) {

                    if (i == 0) {
                        System.out.print("        ");
                        for (int k = 0; k <= tab.length; k++) {

                            System.out.printf("%6d", (k + 1)); //affiche les numeros de la case des colonnes 
                        }

                        System.out.println("");
                    }
                    System.out.println("              -----------------------------------");
                    System.out.print("   ");

                    if (i == 2) {
                        System.out.print("(-)    ");
                    } else {
                        System.out.print("       ");
                    }
                    for (int j = 0; j < tab[i].length; j++) {

                        if (j == 0) {

                            System.out.print((i + 1)); //affiche les numeros des lignes
                        }
                        System.out.printf("%3s", "|"); //cree 5 espaces qui vont disparaitre lorsqu'on ajoute les arbres

                        if (tab[i][j] != null) {
                            System.out.printf("%3s", tab[i][j].getEtat());
                        } else {
                            System.out.printf("%3s", "  ");
                        }

                    }
                    System.out.println("  |");
                    System.out.print("");
                }
                System.out.println("              -----------------------------------");
                System.out.println("");
                System.out.println("");
                System.out.println("");

                break;
        }

    }

    private void changerEtatArbre(Arbre arbre) {

        if (!roundPlusUn) {
            System.out.println("Position:"); //L'utilisateur choisit la posiiton, les try-catch ne lui permettent pas de mettre des valeures stupide
            boolean erreur = true;

            while (erreur) {

                erreur = true;
                int ligne = 0;
                int colonne = 0;
                int i = 0;
                boolean erreur2 = true;

                try {

                    while (erreur2) {
                        do {

                            i += 1;

                            System.out.print("-Ligne ( entre 1 et 5): ");

                            boolean erreur1 = true;

                            while (erreur1) {
                                try {
                                    ligne = Integer.parseInt(scanner.nextLine());
                                    erreur1 = false;
                                } catch (NumberFormatException ee) {
                                    System.out.println("erreur, choisissez un nomnbre");
                                }
                            }

                            System.out.print("-Colonne ( entre 1 et 6): ");

                            while (!erreur1) {
                                try {
                                    colonne = Integer.parseInt(scanner.nextLine());
                                    erreur1 = true;
                                } catch (NumberFormatException ee) {
                                    System.out.println("erreur, choisissez un nombre");
                                }
                            }

                            if (tab[ligne - 1][colonne - 1] == null) {
                                System.out.println("erreur, choisissez une case remplit");
                            }

                        } while (tab[ligne - 1][colonne - 1] == null);

                        try {
                            if (joueurCourant == 1 && ("a".equals(tab[ligne - 1][colonne - 1].getEtat()) || "A".equals(tab[ligne - 1][colonne - 1].getEtat()) || "AA".equals(tab[ligne - 1][colonne - 1].getEtat()) || "AAA".equals(tab[ligne - 1][colonne - 1].getEtat()))) {
                                //Si la case est pas null et elle contient a, A, AA ou AAA
                                int taille = tab[ligne - 1][colonne - 1].getTaille();

                                Nom nom;
                                String etat;

                                switch (taille) {

                                    case 0:
                                        if (tableau[ligne - 1][colonne - 1]) {
                                            if (joueurA.getCapital() >= 1) { //si le joueur assez d'argent
                                                joueurA.setCapital(joueurA.getCapital() - 1);//reduit l'argent de sa banque
                                                taille = tab[ligne - 1][colonne - 1].getTaille() + 1;//Grandit la taille
                                                nom = petit;
                                                etat = "A";

                                                arbre = new Arbre(taille, nom, etat);
                                                tab[ligne - 1][colonne - 1] = arbre;
                                                tableau[ligne - 1][colonne - 1] = false;
                                            } else {
                                                System.out.println("Erreur pas assez de chlorophylle");//Message d'erreur si l'utilisateur n'a pas assez d'argent
                                            }

                                        } else {
                                            System.out.println("Vous avez deja planté ici");
                                        }
                                        break;

                                    case 1:
                                        if (tableau[ligne - 1][colonne - 1]) {
                                            if (joueurA.getCapital() >= 2) {//Meme chose mais passe de A a AA
                                                joueurA.setCapital(joueurA.getCapital() - 2);
                                                taille = tab[ligne - 1][colonne - 1].getTaille() + 1;
                                                nom = moyen;
                                                etat = "AA";

                                                arbre = new Arbre(taille, nom, etat);
                                                tab[ligne - 1][colonne - 1] = arbre;

                                            } else {
                                                System.out.println("Erreur pas assez de chlorophylle");//Message d'erreur si l'utilisateur n'a pas assez d'argent
                                            }
                                        } else {
                                            System.out.println("Vous avez deja planté ici");
                                        }
                                        break;

                                    case 2:
                                        if (tableau[ligne - 1][colonne - 1]) {
                                            if (joueurA.getCapital() >= 2) { //Meme chose mais passe de AA a AAA
                                                joueurA.setCapital(joueurA.getCapital() - 3);
                                                taille = tab[ligne - 1][colonne - 1].getTaille() + 1;
                                                nom = grand;
                                                etat = "AAA";

                                                arbre = new Arbre(taille, nom, etat);
                                                tab[ligne - 1][colonne - 1] = arbre;
                                            } else {
                                                System.out.println("Erreur pas assez de chlorophylle");//Message d'erreur si l'utilisateur n'a pas assez d'argent
                                            }
                                        } else {
                                            System.out.println("Vous avez deja planté ici");
                                        }
                                        break;

                                    case 3:
                                        System.out.println("Erreur, l'arbre est a la grandeur maximale");//Si l'arbre est deja a sa taille maximale
                                        break;

                                    default:
                                        System.out.println("Erreur!");
                                        break;

                                }
                            } else if (joueurCourant == 2 && ("b".equals(tab[ligne - 1][colonne - 1].getEtat()) || "B".equals(tab[ligne - 1][colonne - 1].getEtat()) || "BB".equals(tab[ligne - 1][colonne - 1].getEtat()) || "BBB".equals(tab[ligne - 1][colonne - 1].getEtat()))) {
                                //Si la case est pas null et elle contient b, BB, ou BBB
                                int taille = tab[ligne - 1][colonne - 1].getTaille();
                                Nom nom;
                                String etat;
                                switch (taille) {

                                    case 0:
                                        if (tableau[ligne - 1][colonne - 1]) {
                                            if (joueurB.getCapital() >= 1) {

                                                joueurB.setCapital(joueurB.getCapital() - 1);
                                                taille = tab[ligne - 1][colonne - 1].getTaille() + 1;
                                                nom = petit;
                                                etat = "B";

                                                arbre = new Arbre(taille, nom, etat);
                                                tab[ligne - 1][colonne - 1] = arbre;
                                            } else {
                                                System.out.println("Vous avez deja planté ici");
                                            }
                                        } else {
                                            System.out.println("Erreur pas assez de chlorophylle");
                                        }

                                        break;

                                    case 1:
                                        if (tableau[ligne - 1][colonne - 1]) {
                                            if (joueurB.getCapital() >= 2) {
                                                joueurB.setCapital(joueurB.getCapital() - 2);
                                                taille = tab[ligne - 1][colonne - 1].getTaille() + 1;
                                                nom = moyen;
                                                etat = "BB";

                                                arbre = new Arbre(taille, nom, etat);
                                                tab[ligne - 1][colonne - 1] = arbre;
                                            } else {
                                                System.out.println("Erreur pas assez de chlorophylle");
                                            }
                                        } else {
                                            System.out.println("Vous avez deja planté ici");
                                        }
                                        break;

                                    case 2:
                                        if (tableau[ligne - 1][colonne - 1]) {
                                            if (joueurB.getCapital() >= 3) {
                                                joueurB.setCapital(joueurB.getCapital() - 3);
                                                taille = tab[ligne - 1][colonne - 1].getTaille() + 1;
                                                nom = grand;
                                                etat = "BBB";

                                                arbre = new Arbre(taille, nom, etat);
                                                tab[ligne - 1][colonne - 1] = arbre;
                                            } else {
                                                System.out.println("Erreur pas assez de chlorophylle");
                                            }
                                        } else {
                                            System.out.println("Vous avez deja planté ici");
                                        }
                                        break;

                                    case 3:
                                        System.out.println("Erreur, l'arbre est a la grandeur maximale");
                                        break;

                                    default:
                                        System.out.println("Erreur!");
                                        break;

                                }

                            }
                            erreur2 = false;
                        } catch (NullPointerException ee) {
                            System.out.println("erreur");
                        }
                    }

                    erreur = false;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Erreur, chosir une bonne position");
                }

            }
        }
    }

    private void couperArbreMature(int pointVictoire) {

        boolean brr = true;

        int pointW[][] = {{5, 5, 5, 5, 5, 5}, {5, 7, 7, 7, 7, 5}, {5, 7, 9, 9, 7, 5}, {5, 7, 7, 7, 7, 5}, {5, 5, 5, 5, 5, 5}};

        int ligne = 0;
        int colonne = 0;
        String etat;
        Arbre arbre;

        arbre = new Arbre(3, grand, "AAA");

        boolean erreur = true;

        while (erreur) {    //L'utilisateur qui chosit la ligne et la colonne
            System.out.print("-Ligne ( entre 1 et 5): ");
            try {
                do {
                    ligne = Integer.parseInt(scanner.nextLine());
                    erreur = false;
                } while (ligne < 0 || ligne >= 5);
            } catch (NumberFormatException ee) {
                System.out.println("erreur, choisissez un nombre");
            }
        }

        System.out.print("-Colonne ( entre 1 et 6): ");

        while (!erreur) {
            try {
                do {
                    colonne = Integer.parseInt(scanner.nextLine());
                    erreur = true;
                } while (colonne < 0 || colonne > 5);
            } catch (NumberFormatException ee) {
                System.out.println("Erreur, choisissez un nomnbre");
            }
        }

        int r = joueurCourant;

        if (tab[ligne - 1][colonne - 1] == null) { //Au cas ou il y'a une case vide
            System.out.println("La case est vide");
        } else {

            switch (tab[ligne - 1][colonne - 1].getEtat()) {

                case "AAA":
                    //Coupe l'arbre du joueur 1

                    if (joueurA.getCapital() >= 1) {
                        joueurA.setCapital(joueurA.getCapital() - 1);
                        etat = "x";
                        arbre = new Arbre(0, couper, "x");
                        tab[ligne - 1][colonne - 1] = arbre;
                        r++;
                        roundPlusUn = true;
                        pointVictoire = pointW[ligne - 1][colonne - 1];
                        joueurA.setPointVictoire(joueurA.getPointVictoire() + pointVictoire);
                        System.out.println("Point de victoire du joueur 1:" + joueurA.getPointVictoire());
                    }

                    for (int i = 0; i < tab.length; i++) {
                        for (int j = 0; j < tab[i].length; j++) {
                            if (i == 0) {

                            }
                        }
                    }

                    break;
                case "BBB":
                    //Coupe l'arbre du joueur 2
                    if (joueurB.getCapital() >= 1) {
                        joueurB.setCapital(joueurB.getCapital() - 1);
                        etat = "x";
                        arbre = new Arbre(0, couper, etat);
                        tab[ligne - 1][colonne - 1] = arbre;
                        roundPlusUn = true;
                        pointVictoire = pointW[ligne - 1][colonne - 1];
                        joueurB.setPointVictoire(joueurB.getPointVictoire() + pointVictoire);
                        System.out.println("Point de victoire du joueur 2:" + joueurB.getPointVictoire());
                    }
                    break;
                case "A":
                case "AA":
                case "B":
                case "BB":
                    System.out.println("L'arbre ne peut etre coupé");
                    break;
                case "a":
                case "b":
                    System.out.println("La graine ne peut etre coupé");
                    break;
                default:
                    System.out.println("La case est vide");
                    break;
            }
        }

    }

    private void enleveLeX() {
        //enleve le "x" apres avoir coupé un arbre(apres un tour)

        if (roundPlusUn) {
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    if (tab[i][j] != null) {
                        if (tab[i][j].getEtat().equals("x")) {
                            tab[i][j] = null;
                        }
                    }
                }
            }
        }

    }

    private void permitionGrandir() {

        if (roundPlusUn) {
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    if (tab[i][j] != null) {
                        if (tableau[i][j]) {
                            tableau[i][j] = false;
                        }
                    }
                }
            }
            roundPlusUn = false;
        }

    }

    private Soleil positionSoleil(int round) {

        int r = round % 4; //Change la position du soleil selon le round

        round = round + 1;

        switch (r) {
            case 0:
                Soleil soleil = new Soleil(Nord);
                return soleil;
            case 1:
                soleil = new Soleil(Est);
                return soleil;
            case 2:
                soleil = new Soleil(Sud);
                return soleil;
            case 3:
                soleil = new Soleil(Ouest);
                return soleil;
        }
        return null;
    }

    private void ensoleilement(Soleil soleil) {

        int taille;

        switch (soleil.getPosition()) {

            case Nord: //Case si les soleil est au nord

                for (int i = 0; i < tab[0].length; i++) { //Run la matrisse a de 0 a 6
                    int max = 0; //Reset le maximum a chaque fois
                    for (int j = 0; j < tab.length; j++) {
                        if (tab[j][i] != null) { //Si la position est pas null
                            taille = tab[j][i].getTaille();

                            if (max < taille) { //Si taille est plus grand que max il ajjoute la chlorophylle a la "Banque" de chaque joueur
                                if (tab[j][i].getEtat().equals("A") || tab[j][i].getEtat().equals("AA") || tab[j][i].getEtat().equals("AAA")) {
                                    joueurA.setCapital(joueurA.getCapital() + taille);
                                    System.out.println("Capital du joueur 1: " + joueurA.getCapital()); //Affiche le capitale de chaque joueur
                                } else {
                                    if (tab[j][i].getEtat().equals("B") || tab[j][i].getEtat().equals("BB") || tab[j][i].getEtat().equals("BBB")) {
                                        joueurB.setCapital(joueurB.getCapital() + taille);
                                        System.out.println("Capital du joueur 2: " + joueurB.getCapital());
                                    }
                                }
                            }

                        }
                    }
                }

                break;

            case Est:

                for (Arbre[] tab1 : tab) { //meme chose que Nord mais on parcour le tableau de droite a gauche
                    int max = 0;
                    for (int j = tab1.length - 1; j >= 0; j--) {
                        if (tab1[j] != null) {
                            taille = tab1[j].getTaille();
                            if (max < taille) {
                                max = taille;
                                if (tab1[j].getEtat().equals("A") || tab1[j].getEtat().equals("AA") || tab1[j].getEtat().equals("AAA")) {
                                    joueurA.setCapital(joueurA.getCapital() + taille);
                                    System.out.println("Capital du joueur 1: " + joueurA.getCapital());
                                } else {
                                    if (tab1[j].getEtat().equals("B") || tab1[j].getEtat().equals("BB") || tab1[j].getEtat().equals("BBB")) {
                                        joueurB.setCapital(joueurB.getCapital() + taille);
                                        System.out.println("Capital du joueur 2: " + joueurB.getCapital());
                                    }
                                }
                            }
                        }
                    }
                }

                break;

            case Sud:

                for (int i = 5; i >= 0; i--) { //meme chose que Nord mais on parcour le tableau de bas a en haut
                    int max = 0;
                    for (int j = 0; j < 5; j++) {
                        if (tab[j][i] != null) {
                            taille = tab[j][i].getTaille();

                            if (max < taille) {
                                max = taille;
                                if (("A".equals(tab[j][i].getEtat()) || ("AA".equals(tab[j][i].getEtat())) || ("AAA".equals(tab[j][i].getEtat())))) {
                                    joueurA.setCapital(joueurA.getCapital() + taille);
                                    System.out.println("Capital du joueur 1: " + joueurA.getCapital());
                                } else if (("B".equals(tab[j][i].getEtat()) || ("BB".equals(tab[j][i].getEtat())) || ("BBB".equals(tab[j][i].getEtat())))) {
                                    joueurB.setCapital(joueurB.getCapital() + taille);
                                    System.out.println("Capital du joueur 2: " + joueurB.getCapital());
                                }
                            }
                        }
                    }
                }

                break;

            case Ouest:

                for (Arbre[] tab1 : tab) { //meme chose que Nord mais on parcour le tableau de gauche a droite
                    int max = 0;
                    for (int j = 0; j < tab1.length; j++) {
                        if (tab1[j] != null) {
                            taille = tab1[j].getTaille();
                            if (max < taille) {
                                max = taille;
                                if (tab1[j].getEtat().equals("A") || tab1[j].getEtat().equals("AA") || tab1[j].getEtat().equals("AAA")) {
                                    joueurA.setCapital(joueurA.getCapital() + taille);
                                    System.out.println("Capital du joueur 1: " + joueurA.getCapital());
                                } else {
                                    if (tab1[j].getEtat().equals("B") || tab1[j].getEtat().equals("BB") || tab1[j].getEtat().equals("BBB")) {
                                        joueurB.setCapital(joueurB.getCapital() + taille);
                                        System.out.println("Capital du joueur 2: " + joueurB.getCapital());
                                    }
                                }
                            }
                        }
                    }
                }

                break;

        }

    }

}
