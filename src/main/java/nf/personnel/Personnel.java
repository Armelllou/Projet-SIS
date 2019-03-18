package nf.personnel;

import java.util.UUID;

public abstract class Personnel {
 
    String nom;
    String prenom;
    String uniqueID = UUID.randomUUID().toString();
    int id;
    int mdp;

    public Personnel(String nom, String prenom, int id, int mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.mdp = mdp;
    }
    
    public abstract String getNom();
    public abstract String getPrenom();
    public abstract int getId() ;
    public abstract int getMdp() ;
    
    
    
    
}

