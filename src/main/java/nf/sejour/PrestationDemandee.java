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

/**
 *
 * @author annel
 */
public class PrestationDemandee {

    String ServiceDemandeur;
    String PrestationDemande;
    String NomPatient;
    String PrenomPatient;
    String IPP;
    String NomMedecin;
    String PrenomMedecin;
    int idPH;

    
    //creer une demande
    public PrestationDemandee(String ServiceDemandeur, String PrestationDemande, String NomPatient, String PrenomPatient, String IPP, String NomMedecin, String PrenomMedecin, int idPH) {
        this.ServiceDemandeur = ServiceDemandeur;
        this.PrestationDemande = PrestationDemande;
        this.NomPatient = NomPatient;
        this.PrenomPatient = PrenomPatient;
        this.IPP = IPP;
        this.NomMedecin = NomMedecin;
        this.PrenomMedecin = PrenomMedecin;
        this.idPH = idPH;

    }
// ajout cette demande à la base de donnée afin qu'elle sois transmise aux médicotechniciens
    public boolean AjouterDemandeDePrestationSurBD(PrestationDemandee pd) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO prestationaeffectuer (ServiceDemandeur,PrestationDemande, NomPatient, PrenomPatient,IPP,NomPh,PrenomPH,idPh) VALUES(?,?,?,?,?,?,?,?) ";

        ConnexionBD conn = ConnexionBD.getInstance();
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);

        statement.setObject(1, pd.getServiceDemandeur(), Types.VARCHAR);
        statement.setObject(2, pd.getPrestationDemande(), Types.VARCHAR);
        statement.setObject(3, pd.getNomPatient(), Types.VARCHAR);
        statement.setObject(4, pd.getPrenomPatient(), Types.VARCHAR);
        statement.setObject(5, pd.getIPP(), Types.VARCHAR);
        statement.setObject(6, pd.getNomMedecin(), Types.VARCHAR);
        statement.setObject(7, pd.getPrenomMedecin(), Types.VARCHAR);
        statement.setObject(8, pd.getIdPH(), Types.VARCHAR);

        statement.executeUpdate();
        j = true;
        return j;
    }

    public String getNomMedecin() {
        return NomMedecin;
    }

    public int getIdPH() {
        return idPH;
    }

    public String getPrenomMedecin() {
        return PrenomMedecin;
    }

    public String getServiceDemandeur() {
        return ServiceDemandeur;
    }

    public String getPrestationDemande() {
        return PrestationDemande;
    }

    public String getNomPatient() {
        return NomPatient;
    }

    public String getPrenomPatient() {
        return PrenomPatient;
    }

    public String getIPP() {
        return IPP;
    }

}
