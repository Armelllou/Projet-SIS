package nf.personnel;


public abstract class Personnel {
 
    String nom;
    String prenom;
    int id;
    int mdp;

    // classe abstraite commune a tous les personnels ici on construit un personnel avec en commun pour tous
    //nom, prenom, id , mdp
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

