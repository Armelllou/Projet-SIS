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
