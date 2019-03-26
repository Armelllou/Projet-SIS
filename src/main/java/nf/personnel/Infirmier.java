package nf.personnel;

import bd.ConnexionBD;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Types;

public class Infirmier extends Personnel {
    
    private String service;

    // infirmier es un personnel avec un service propre
    
    // créerr une infirmier
    public Infirmier(String nom, String prenom, int id, int mdp,String service) {
        super(nom, prenom, id, mdp);
        this.service=service;
    }
    //Ajoute une infirmière sur la base de donnée
    public boolean AjouterSurBdIDE(Infirmier i) throws SQLException {
        boolean j = false;
        ConnexionBD conn = ConnexionBD.getInstance();
        String sql = " INSERT INTO ide (idIDE,motDePasse,Nom,Prenom, Service) VALUES(?,?,?,?,?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
        
        statement.setObject(1, i.getId(), Types.INTEGER);
        statement.setObject(2, i.getMdp(), Types.INTEGER);
        statement.setObject(3, i.getNom(), Types.VARCHAR);
        statement.setObject(4, i.getPrenom(), Types.VARCHAR);
        statement.setObject(5, i.getService(), Types.VARCHAR);
       

        statement.executeUpdate();
        j = true;
        return j;
    }
    
    @Override
    public String getNom() {
      return nom;
    }

    @Override
    public String getPrenom() {
       return prenom;
    }

    @Override
    public int getId() {
       return id;
    }

    @Override
    public int getMdp() {
        return mdp;
    }

    public String getService() {
        return service;
    }
  



}
