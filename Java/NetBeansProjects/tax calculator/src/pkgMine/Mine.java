/*
 * Nom: Devoir mine d'or
 * Date: 10/09/2016 
 * Auteur: 1629045 Christian Sfeir
 */
package pkgMine;
import java.util.Scanner;
/**
 *
 * @author 1629045
 */
public class Mine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    Scanner lire=new Scanner (System.in);
        int MASSE_VOLUMIQUE_OR=19;
        int PRIX_DE_PROD=1750000;
        int PRIX_DE_TRANS=60000;
        double TPS=0.05;
        double TVQ=0.0975;
        double PRIX_OR_GRAMME=27.65;
        System.out.println("Combien de bloc d'or desirer vous achetez? ");
        int nbDeBlocDor=lire.nextInt();
        double prixTransport=nbDeBlocDor*PRIX_DE_TRANS;
        double prixTransportTps=prixTransport*TPS;
        double prixTransportTvq=prixTransport*TVQ;
        double prixTransportBrute=prixTransportTvq+prixTransportTps+prixTransport;
        double PRIX_BLOC=PRIX_OR_GRAMME*9500000;
        double prixTotal=PRIX_BLOC+prixTransportBrute;
        System.out.println("Le prix d'un bloc d'or sera ");
        System.out.println(PRIX_BLOC);
        System.out.println("le prix de la transportation sera ");
        System.out.println(prixTransportBrute);
        System.out.println("le prix total sera de ");
        System.out.println(prixTotal);
        double gainRealiser=prixTotal-PRIX_DE_PROD;
        System.out.println("Les gain total sont de");
        System.out.println(gainRealiser);
    }
}
 
