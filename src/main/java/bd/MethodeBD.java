package main.java.bd;

import main.java.nf.patient.Patient;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class MethodeBD {

    private ConnexionBD comm;
    private Statement state;

    /**
     * Constructeur de la classe, avec en paramètre la connection à la base.
     *
     * @param comm
     * @throws SQLException
     */
    public MethodeBD(ConnexionBD comm) throws SQLException {
        this.state = comm.getConnexion().createStatement();
        this.comm = comm;

    }
    
      public void AjouterSurBdPatient(Patient p) throws SQLException{{
        
        String sql = "INSERT INTO Patient (IPP, Nom, Prénom,DatedeNaissance,Sexe,MédecinG) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = comm.getConnexion().prepareStatement(sql); 
        statement.setObject(1,p.getIpp(), Types.INTEGER); 
        statement.setObject(2,p.getNomDeNaissance(),Types.VARCHAR); 
        statement.setObject(3,p.getPrenom(),Types.VARCHAR); 
        statement.setObject(4,p.getDateDeNaissance(),Types.DATE); 
        statement.setObject(5,p.getSexe(),Types.VARCHAR); 
        statement.setObject(6,123,Types.INTEGER); 
        
        statement.executeUpdate(); 
    }

      }
}