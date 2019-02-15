package NF;

import BD.ConnexionBD;
import interfaces.CreationDPI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;

public class Patient {

    String NomUsuel;
    String NomDeNaissance;
    Dates DateDeNaissance;
    Sexe sexe;
    String prenom;
    Adresse adresse;
    Ipp ipp;
    Dma dma;
    Localisation localisation;
    ConnexionBD conn = new ConnexionBD();
    Sih sih = new Sih();
    boolean ajoute = false;

    CreationDPI cdpi = new CreationDPI();

    public Patient(String NomDeNaissance, Dates DateDeNaissance, String sexe, String prenom, Adresse adresse) throws SQLException {
        this.NomDeNaissance = NomDeNaissance;
        this.DateDeNaissance = DateDeNaissance;
      
        this.prenom = prenom;
        this.adresse = adresse;
        this.ipp = new Ipp();
        
           sih.ajoutPatient(this);
    }

    
  

    public void AjouterSurBdPatient(Patient p) throws SQLException {

        String sql = " INSERT INTO Patient (IPP, Nom, Prénom,DatedeNaissance,Sexe,MédecinG,idAdresse) VALUES(?,?,?,?,?,?,?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
        statement.setObject(1, this.ipp.getIpp(), Types.INTEGER);
        statement.setObject(2, p.getNomDeNaissance(), Types.VARCHAR);
        statement.setObject(3, p.getPrenom(), Types.VARCHAR);
        statement.setObject(4, p.getDateDeNaissance(), Types.VARCHAR);
        statement.setObject(5, "F", Types.VARCHAR);
        statement.setObject(6, 123, Types.INTEGER);
        statement.setObject(7, p.getAdresse(), Types.VARCHAR);

        statement.executeUpdate();

    }

    //    public void SupprimerPatients() throws SQLException{
//            String query ="DELETE FROM Patient";
//        PreparedStatement statement1 = conn.getConnexion().prepareStatement(query); 
//         
//          statement1.executeUpdate();
//    
    public String getNomUsuel() throws SQLException {

//        String NomUsuel = "SELECT Nom FROM Patient";
//        PreparedStatement statement = conn.getConnexion().prepareStatement(NomUsuel); 
//        statement.executeUpdate();
//        
        return NomUsuel;
    }

    public void setNomUsuel(String NomUsuel) {
        this.NomUsuel = NomUsuel;
    }

    public String getNomDeNaissance() {
        return NomDeNaissance;
    }

    public void setNomDeNaissance(String NomDeNaissance) {
        this.NomDeNaissance = NomDeNaissance;
    }

    public String getDateDeNaissance() {
        return DateDeNaissance.toString();
    }

    public void setDateDeNaissance(Date DateDeNaissance) {
        //this.DateDeNaissance = DateDeNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse.toString();
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Ipp getIpp() {
        return ipp;
    }

    public void setIpp(Ipp ipp) {
        this.ipp = ipp;
    }

    public Dma getDma() {
        return dma;
    }

    public void setDma(Dma dma) {
        this.dma = dma;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public Patient rechercherPatientIPP(String ipp) {
        for (Patient patient : Sih.getPatientList()) {
            if (patient.ipp.equals(ipp)) {
               return patient;
           }
        }
       return null;
   }


}
