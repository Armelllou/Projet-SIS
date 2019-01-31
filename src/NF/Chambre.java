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
class Chambre {
     int n;

    public Chambre(int n) {
        
        if (n<0 && n>999){
            System.out.println("Le numéro de chambre est inconnu");
        }
        this.n = n;
    }
   
}
