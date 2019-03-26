/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf.personnel;

import bd.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author annel
 */
public class MedicoTechnique extends Personnel {
   
    // crée un MT
    public MedicoTechnique(String nom, String prenom, int id, int mdp) {
        super(nom, prenom, id, mdp);
        
    }
    
    // ajpouter le medicotech sur la BD
      public boolean AjouterSurBdMedicoTechnique(MedicoTechnique i) throws SQLException {
        boolean j = false;
        ConnexionBD conn = ConnexionBD.getInstance();
        String sql = " INSERT INTO medicotechniques (idMT,motDePasse,Nom,Prenom) VALUES(?,?,?,?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
        
        statement.setObject(1, i.getId(), Types.INTEGER);
        statement.setObject(2, i.getMdp(), Types.INTEGER);
        statement.setObject(3, i.getNom(), Types.VARCHAR);
        statement.setObject(4, i.getPrenom(), Types.VARCHAR);
       
       

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
    
    
    
}
