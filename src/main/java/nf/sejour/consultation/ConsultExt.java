package nf.sejour.consultation;

import bd.ConnexionBD;
import nf.patient.Patient;
import nf.personnel.Personnel;
import nf.sejour.Prescription;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class ConsultExt  {
 private Personnel pH;
    
    
    
    public ConsultExt(Personnel pH) {
         this.pH = pH;
  
    }

// permet d'ajouter une consultation externe sur la table dans la base de donnée, si pas en hospitalisation
    public static boolean AjouterPatientConsultationExterne(Patient p) throws SQLException {
        boolean j = false;
        ConnexionBD conn = ConnexionBD.getInstance();
        String sql = " INSERT INTO consultationexterne (IPP) VALUES(?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
        statement.setObject(1, p.getIpp().getIpp(), Types.INTEGER);

        statement.executeUpdate();
        j = true;
        return j;
    }
}
