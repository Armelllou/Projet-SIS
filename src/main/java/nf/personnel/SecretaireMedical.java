package nf.personnel;

import bd.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import nf.Sih;
import nf.dossieradministratif.Dma;
import nf.patient.Patient;

public class SecretaireMedical extends Personnel {
String Service;
    public SecretaireMedical(String nom, String prenom, int id, int mdp,String Service) {
        super(nom, prenom, id, mdp);
        this.Service=Service;
    }

    
    public boolean AjouterSurBdSecretaireMedical(SecretaireMedical i) throws SQLException {
        boolean j = false;
        ConnexionBD conn = new ConnexionBD ();
        String sql = " INSERT INTO secretaireadministrative (idSA,motDePasse,Nom,Prénom, Service) VALUES(?,?,?,?,?) ";
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
        return Service;
    }


}
