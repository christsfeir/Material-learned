package ca.qc.bdeb.info202;

import java.util.Random;

public class Exo3 {

    public static void main(String[] args) {

        int[][] tabRandom = new int[10][10];
        Random random = new Random();

        remplirTableau(tabRandom, random);
        afficheTabRandom(tabRandom);
        tabMaximum(tabRandom);
    }

    public static void remplirTableau(int[][] tabRandom, Random random) {
        int r;

        for (int i = 0; i < tabRandom.length; i++) {
            for (int j = 0; j < tabRandom[i].length; j++) {
                r = random.nextInt(100);
                tabRandom[i][j] = r;
            }
        }

    }

    public static void afficheTabRandom(int[][] tabRandom) {
        for (int i = 0; i < tabRandom.length; i++) {
            for (int j = 0; j < tabRandom[i].length; j++) {
                System.out.printf("%5d ",tabRandom[i][j]);
            }
            System.out.println("");
        }
    }

    public static void tabMaximum(int[][] tabRandom) {
        int max = tabRandom[0][0];
        
        for (int i = 0; i < tabRandom.length; i++) {
            for (int j = 0; j < tabRandom[i].length; j++) {
            
                 
               
                if( max < tabRandom[i][j]){
            max = tabRandom[i][j];
            }   
   
            }
        }
        System.out.println("le max est: " + max);
    
    
    
    }




}
