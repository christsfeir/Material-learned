/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtab;
import java.util.Scanner;
/**
 *
 * @author 1629045
 */
public class ab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner lire=new Scanner(System.in);
    System.out.println("Quel est la valeure de a");
    double a=lire.nextDouble() ;
    System.out.println("Quel est la valeure de b");
    double b=lire.nextDouble();
    if (a>b)
        System.out.println("a<b");
    else if (a==b)
        System.out.println("a>b");
    else
        System.out.println("a=b");
    }    
}
