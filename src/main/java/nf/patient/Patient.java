package main.java.nf.patient;

import main.java.bd.ConnexionBD;
import main.java.interfaces.dpi.CreationDPI;
import main.java.nf.Dates;
import main.java.nf.Sih;
import main.java.nf.dossieradministratif.Dma;
import main.java.nf.localisation.Localisation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

public class Patient {

    String NomUsuel;
    String NomDeNaissance;
    Dates DateDeNaissance;
    String sexe;
    String prenom;
    Adresse adresse;
    Ipp ipp;
    Dma dma;
    String numSS;
    String email;
    String telephone;

    Localisation localisation;

    ConnexionBD conn = ConnexionBD.getInstance();
    Sih sih = new Sih();
    boolean ajoute = false;

    CreationDPI cdpi = new CreationDPI();

    public Patient(String NomDeNaissance, String NomUsuel, Dates DateDeNaissance, String sexe, String prenom, Adresse adresse, String numss, String email, String telephone) throws SQLException {
        this.NomDeNaissance = NomDeNaissance;
        this.DateDeNaissance = DateDeNaissance;
        this.NomUsuel = NomUsuel;
        this.sexe = sexe;

        this.prenom = prenom;
        this.adresse = adresse;
        this.numSS = numss;
        this.email = email;
        this.telephone = telephone;
        this.ipp = new Ipp();

        sih.ajoutPatient(this);
    }


    public boolean AjouterSurBdPatient(Patient p) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO Patient (IPP, NomDeNaissance,NomUsuel, Prénom,DatedeNaissance,Sexe,MédecinG,idAdresse,NumDeSS,email,telephone) VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
        statement.setObject(1, this.ipp.getIpp(), Types.INTEGER);
        statement.setObject(2, p.getNomDeNaissance(), Types.VARCHAR);
        statement.setObject(3, p.getNomUsuel(), Types.VARCHAR);
        statement.setObject(4, p.getPrenom(), Types.VARCHAR);
        statement.setObject(5, p.getDateDeNaissance(), Types.VARCHAR);
        statement.setObject(6, p.getSexe(), Types.VARCHAR);

        statement.setObject(7, 123, Types.INTEGER);
        statement.setObject(8, p.getAdresse(), Types.VARCHAR);
        statement.setObject(9, p.getNumSS(), Types.VARCHAR);
        statement.setObject(10, p.getEmail(), Types.VARCHAR);
        statement.setObject(11, p.getTelephone(), Types.INTEGER);

        statement.executeUpdate();
        j = true;
        return j;
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

    public String getNumSS() {
        return numSS;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
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

    public String getSexe() {
        return sexe;
    }

//    public void setSexe(Sexe sexe) {
//        this.sexe = sexe;
//    }

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
