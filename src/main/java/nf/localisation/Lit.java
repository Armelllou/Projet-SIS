/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf.localisation;

/**
 * @author annel
 */
public class Lit {
    String n;
    String f;
    String p;


    public Lit(String n) {
        if (!n.equals(f)) {
            System.out.println("le numéro de lit est inconnu");
        }
        if (!n.equals(p)) {
            System.out.println("le format de lit est inconnu");
        } else this.n = n;
    }


}
