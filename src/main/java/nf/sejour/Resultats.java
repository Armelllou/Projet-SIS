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
public class Resultats {

    String ServiceDemandeur;
    String NomPatient;
    String PrenomPatient;
    String IPP;
    String NomMedicoTech;
    String PrenomMedicotehc;
    int idTECH;
    String Resultats;

    
    //creer un résultats
    public Resultats(String ServiceDemandeur, String NomPatient, String PrenomPatient, String IPP, String NomMedicoTech, String PrenomMedicotehc, int idTECH,String Resultats) {
        this.ServiceDemandeur = ServiceDemandeur;
        this.NomPatient = NomPatient;
        this.PrenomPatient = PrenomPatient;
        this.IPP = IPP;
        this.NomMedicoTech = NomMedicoTech;
        this.PrenomMedicotehc = PrenomMedicotehc;
        this.idTECH = idTECH;
        this.Resultats =Resultats;
    }
// Ajouter un résultat à la base de donnée pour le transmettre au service responsable
    public boolean AjouterResutatsSurBD(Resultats r) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO prestationsfaites (ServiceDemandeur,NomPatient,PrenomPatient,IPP,NomMedicoTech,PrenomMedicotehc,idTECH,Resultats) VALUES(?,?,?,?,?,?,?,?) ";

        ConnexionBD conn = ConnexionBD.getInstance();
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);

        statement.setObject(1, r.getServiceDemandeur(), Types.VARCHAR);
        statement.setObject(2, r.getNomPatient(), Types.VARCHAR);
        statement.setObject(3,r.getPrenomPatient(), Types.VARCHAR);
        statement.setObject(4, r.getIPP(), Types.VARCHAR);
        statement.setObject(5, r.getNomMedicoTech(), Types.VARCHAR);
        statement.setObject(6,r.getPrenomMedicotehc(), Types.VARCHAR);
        statement.setObject(7,r.getIdTECH(), Types.INTEGER);
         statement.setObject(8,r.getResultats(), Types.VARCHAR);

        statement.executeUpdate();
        j = true;
        return j;
    }

    public String getResultats() {
        return Resultats;
    }

    public String getServiceDemandeur() {
        return ServiceDemandeur;
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

    public String getNomMedicoTech() {
        return NomMedicoTech;
    }

    public String getPrenomMedicotehc() {
        return PrenomMedicotehc;
    }

    public int getIdTECH() {
        return idTECH;
    }

}
