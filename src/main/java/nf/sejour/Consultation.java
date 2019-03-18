/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf.sejour;

import bd.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import nf.Dates;

/**
 *
 * @author annel
 */
public class Consultation {
    ConnexionBD conn = ConnexionBD.getInstance();

    private String idPH;
    private String ipp;
    private String details;
    private Dates dates;

    public Consultation(String details, String idPH, String ipp) {

        this.idPH = idPH;
        this.ipp = ipp;
        this.details = details;
        this.dates = dates;
    }

    public boolean AjouterConsultationSurBD(Consultation a) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO consultation (Observation, IPP, NomMedecin) VALUES(?,?,?) ";
        
        
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql); 

        statement.setObject(2, a.getipp(), Types.VARCHAR);
        statement.setObject(3, a.getIPH(), Types.VARCHAR);
        statement.setObject(1, a.getDetail(), Types.VARCHAR);
   


        statement.executeUpdate();
        j = true;
        return j;
    }



    public String getIPH() {
        return idPH;
    }

    public String getipp() {
        return ipp;
    }

    public String getDetail() {
        return details;
    }

    public Dates getDates() {
        return dates;
    }
}
