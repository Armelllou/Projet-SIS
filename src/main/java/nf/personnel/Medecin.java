package main.java.nf.personnel;


import main.java.nf.Sih;

public class Medecin {
    String nom;
    String Prenom;
    String ville;
    boolean medecinGeneraliste=false;

    public Medecin(String nom, String Prenom, String ville) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.ville = ville;
    }

    public Medecin rechercherMedecin(String nom, String prenom) {
        for(Medecin medecin : Sih.getMedecinList()){
            if(medecin.nom.equals(nom) && medecin.Prenom.equals(prenom)){
                return medecin;
            }
        }
        return null;
    }

}

