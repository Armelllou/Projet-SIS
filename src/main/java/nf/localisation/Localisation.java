/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.nf.localisation;

import main.java.bd.ConnexionBD;
import main.java.nf.patient.Ipp;
import main.java.nf.patient.Patient;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author annel
 */
public class Localisation {

    Lit lit;
    Chambre chambre;
    String serviceGeographique;
    String serviceResponsbale;
    ConnexionBD conn = new ConnexionBD();
    Ipp ipp;
    Patient p;

    public Localisation(Patient p, String serviceGeographique, String serviceResponsbale) {
        this.p = p;
        this.serviceGeographique = serviceGeographique;
        this.serviceResponsbale = serviceResponsbale;
    }

    public boolean AjouterSurBdLocalisation(Localisation l) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO localisations (IPP, ServiceResponsable,ServiceGeographique,lit) VALUES(?,?,?,?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
        statement.setObject(1, l.getP().getIpp(), Types.VARCHAR);
        statement.setObject(2, l.getServiceResponsbale(), Types.VARCHAR);
        statement.setObject(3, l.getServiceGeographique(), Types.VARCHAR);
        statement.setObject(4, 0, Types.VARCHAR);

        statement.executeUpdate();
        j = true;
        return j;
    }

    public Patient getP() {
        return p;
    }

    public String getServiceGeographique() {
        return serviceGeographique;
    }

    public void setServiceGeographique(String serviceGeographique) {
        this.serviceGeographique = serviceGeographique;
    }

    public String getServiceResponsbale() {
        return serviceResponsbale;
    }

    public void setServiceResponsbale(String serviceResponsbale) {
        this.serviceResponsbale = serviceResponsbale;
    }

}
