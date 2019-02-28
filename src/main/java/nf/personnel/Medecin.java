package nf.personnel;


import nf.Sih;

public class Medecin {
    String nom;
    String prenom;
    String ville;
    boolean medecinGeneraliste = false;

    public Medecin(String nom, String Prenom, String ville) {
        this.nom = nom;
        this.prenom = Prenom;
        this.ville = ville;
    }

    public Medecin rechercherMedecin(String nom, String prenom) {
        for (Medecin medecin : Sih.getMedecinList()) {
            if (medecin.nom.equals(nom) && medecin.prenom.equals(prenom)) {
                return medecin;
            }
        }
        return null;
    }

}

