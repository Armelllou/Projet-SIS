/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

/**
 *
 * @author annel
 */
public class Lit {
   String n;
   String F;
   String P;


    public Lit(String n) {
        
        if (n.equals(F)!= true) {
            System.out.println("le numéro de lit est inconnu");
        }
        if (n.equals(P) != true){
             System.out.println("le format de mlit est inconnu");
        }
        
        else this.n=n;
    }
    
   
    
}
