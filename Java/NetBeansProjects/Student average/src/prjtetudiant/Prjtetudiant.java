/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjtetudiant;
import java.util.Scanner;
/**
 *
 * @author 1629045
 */
public class Prjtetudiant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
    Scanner lire=new Scanner (System.in);
    System.out.println("Quelle est la note du premier examen>0");
    double exam1=lire.nextDouble();
     if ((exam1>100)||(exam1<0))
        System.out.println("La note doit etre entre 0 et 100");
    double coef1=exam1+30/100;
    System.out.println("Quelle est la note du deuxieme examen>0");
    double exam2=lire.nextDouble();
     if ((exam2>100)||(exam2<0))
        System.out.println("La note doit etre entre 0 et 100");
    double coef2=exam2+20/100;
    System.out.println("Quelle est la note du troisieme examen>0");
    double exam3=lire.nextDouble();
     if ((exam3>100)||(exam3<0))
        System.out.println("La note doit etre entre 0 et 100");
    double coef3=exam3+50/100;
    double moyenne=(coef1+coef2+coef3)/3;
    
    if ((moyenne>100)||(moyenne<0))
        System.out.println("La moyenne doit etre entre 0 et 100");       
    else if (moyenne>=60 ){ 
        System.out.println("Votre moyenne est de");
        System.out.println(moyenne);
        System.out.println("Vous avez reussi");
        System.out.println("Passer de bonne vacance");}
    else {
        System.out.println("Votre moyenne est de");
        System.out.println(moyenne);
        System.out.println("Vous etes en echec");
        System.out.println("Passer de bonne vacance");}    
   } 
}
