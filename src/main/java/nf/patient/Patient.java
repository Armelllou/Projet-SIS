package nf.patient;

import bd.ConnexionBD;
import interfaces.CreationDPI;
import nf.Dates;
import nf.dossieradministratif.Dma;
import nf.localisation.Localisation;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;


public class Patient {

    String NomUsuel;
    String NomDeNaissance;
    Dates DateDeNaissance;
    String sexe;
    String prenom;
    Adresse adresse;
    static Ipp ipp;
    Dma dma;
    String numSS;
    String email;
    String telephone;
    String typeSejour;
    Localisation localisation;
    
    
    
    
    
    ConnexionBD conn = ConnexionBD.getInstance();

    // crée un patient 
    public Patient(String NomDeNaissance, String NomUsuel, Dates DateDeNaissance, String sexe, String prenom, Adresse adresse, String numss, String email, String telephone, String typeSejour) throws SQLException {
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
        this.typeSejour = typeSejour;

    }

// méthode qui ajoute un patienr sur la base de données
    public boolean AjouterSurBdPatient(Patient p) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO patient (IPP, NomDeNaissance,NomUsuel, Prénom,DatedeNaissance,Sexe,MédecinG,idAdresse,NumDeSS,email,telephone,typeSejour) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
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
        statement.setObject(12, p.getTypeSejour(), Types.VARCHAR);

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
    // toutes les lignes qui suivent servent à récupérer des infos sur un patient
    public String getNomUsuel() throws SQLException {
        return NomUsuel;
    }

    public String getNumSS() {
        return numSS;
    }

    public String getEmail() {
        return email;
    }

    public String getTypeSejour() {
        return typeSejour;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getNomDeNaissance() {
        return NomDeNaissance;
    }

    public String getDateDeNaissance() {
        return DateDeNaissance.toString();
    }

    public String getSexe() {
        return sexe;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse.toString();
    }

    public Ipp getIpp() {
        return ipp;
    }

    public Dma getDma() {
        return dma;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

}
