/*
* Nom Fichier:Cours3.java
* Description:Des exemple multiple
* auteur: 1629045 christian
* Date:08-09-2016
*/
package pkgcours3;
/**
*
* @author 1629045
*/
import java.util.Scanner;
public class Cours3 {
/**
* @param args the command line arguments
*/
public static void main(String[] args) {
// TODO code application logic here
int i,j=3;
double quotien;
int reste; 
boolean test=true;
int somme; 
int soustraction;
Scanner lire=new Scanner (System.in);
System.out.println("Donnez une valeure a val1");
int val1=lire.nextInt();
System.out.println("Entrer la valeure de vall2 ");
double val2=lire.nextDouble();
i=35;
somme=i+j;
soustraction=i-j;
double valeure=val1+val2-soustraction;
System.out.println("La valeure est egale!"+valeure);
quotien=i/j;
reste=i%j;
System.out.print("la somme est ");
System.out.println(somme);
System.out.print("la soustraction est ");
System.out.println(soustraction);
System.out.print("Le quotien est ");
System.out.println(quotien);
System.out.println("le reste de la divion est "+ reste );
} 
}
