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
class Adresse {
    String rue;
    String numéro;
    String ville;
    String codePostal;

    public Adresse(String rue, String numéro, String ville, String codePostal) {
        this.rue = rue;
        this.numéro = numéro;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNuméro() {
        return numéro;
    }

    public void setNuméro(String numéro) {
        this.numéro = numéro;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    
    
}
