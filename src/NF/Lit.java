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
   int n;

    public Lit(int n) {
        if (n<000 && n>999){
            System.out.println("Ce numéro de chambre est inconnu");
        }
        else this.n=n;
    }
    
   
    
}
