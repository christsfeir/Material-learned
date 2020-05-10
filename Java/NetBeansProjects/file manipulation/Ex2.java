package canadaqcbdeb202;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ex2 {

public static void main(String[] args) throws Exception {
    
    String []tabLignes = new String[30] ;
    String[] tabNoms = new String[30];
    int [] tabNotes = new int[30];
    
    
    chargerFichier("etudiants.txt", tabLignes);
    recupererValeurs(tabLignes , tabNoms , tabNotes);
    afficherMenu(tabNoms , tabNotes);
    
    
    }
    
public static void chargerFichier(String nomFichier, String[] tabLignes) throws Exception{
BufferedReader lecture = new BufferedReader(new FileReader(nomFichier));
        String line = lecture.readLine();
        
        for (int i = 0; line != null && i < tabLignes.length; i++) {
        tabLignes[i]  =line;
        line  = lecture.readLine();
    }
       lecture.close();
}

public static void afficherMenu(String tabNoms[], int[] tabNotes) {
Scanner scanner = new Scanner(System.in);
        
        boolean continuer = true;
        
        
        while(continuer){
            System.out.println("Les étudiants sont :");
            for (int i = 0; i < tabNoms.length && tabNoms[i] != null; i++) {
                System.out.println( (i+1) + " : " + tabNoms[i]);
            }
            
            System.out.println("X : Quitter");
            
            String reponse = scanner.nextLine();
            
            if (reponse.toLowerCase().equals("x")){
                continuer = false;
            } else {
                int position = Integer.parseInt(reponse) - 1; 
                
                afficheDetailEtudiants(position, tabNoms, tabNotes);
            }
            
        }
    }

    public static void recupererValeurs(String[] tabLignes, String[] tabNoms, int[] tabNotes) {
        for (int i = 0; i < tabLignes.length && tabLignes[i] != null; i++) {
            String[] temp = tabLignes[i].split(":");
            tabNoms[i] = temp[0];
            tabNotes[i] = Integer.parseInt(temp[1]);
  
    }


    }

    public static void afficheDetailEtudiants(int position, String[] tabNoms, int[] tabNotes) {
        System.out.println("L'etudiant: " + tabNoms[position] + "a la note: " + tabNotes[position]);
        
                if (tabNotes[position] >= 90){
            System.out.println("Bravo!");
        } else if (tabNotes[position] >= 80){
            System.out.println("Très bien");
        } else if (tabNotes[position] >= 60){
            System.out.println("Succès");
        } else {
            System.out.println("Échec");
        }
        
        
        
        
    }
    
    }