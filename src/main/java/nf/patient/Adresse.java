/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf.patient;


/**
 * @author annel
 */
public class Adresse {

    String adresse;
    String ville;
    String codePostal;

    public Adresse(String adresse, String ville, String codePostal) {
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }


    public String getVille() {
        return ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

   

    @Override
    public String toString() {

        String a = (this.getAdresse() + " " + this.getVille() + " " + this.getCodePostal());

        return a;


    }
}
