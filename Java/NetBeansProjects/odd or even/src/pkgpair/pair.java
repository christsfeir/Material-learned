/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgpair;
import java.util.Scanner;
/**
 *
 * @author 1629045
 */
public class pair {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner lire=new Scanner(System.in);
    System.out.println(" Quelle est la valeure de a ");
    double a=lire.nextDouble();
    if (a%2==0)
        System.out.println(" a est paire ");
    else
        System.out.println(" a est impaire ");
   }
}
