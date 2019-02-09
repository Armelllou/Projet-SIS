package NF;

import BD.ConnexionBD;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

public  class Patient {
  String NomUsuel ;
  String NomDeNaissance;
  Date DateDeNaissance;
  Sexe sexe;
  String prenom;
  Adresse adresse;
  Ipp ipp;
  Dma dma;
  Localisation localisation; 
ConnexionBD conn = new ConnexionBD();
Sih sih = new Sih();


    public Patient(String NomUsuel, String NomDeNaissance, Date DateDeNaissance, Sexe sexe, String prenom, Adresse adresse, Localisation localisation) throws SQLException {
        this.NomUsuel = NomUsuel;
        this.NomDeNaissance = NomDeNaissance;
        this.DateDeNaissance = DateDeNaissance;
        this.sexe = sexe;
        this.prenom = prenom;
        this.adresse = adresse;
        ipp = new Ipp();
        this.dma = dma;
        this.localisation = localisation;

       
      AjouterSurBdPatient(this);
       
       
    } 
    
    public void SupprimerPatients() throws SQLException{
            String query ="DELETE FROM Patient";
        PreparedStatement statement1 = conn.getConnexion().prepareStatement(query); 
         
          statement1.executeUpdate();
    }
    
    
    
    public   void AjouterSurBdPatient(Patient p) throws SQLException{
     try{
         
         String sql = "INSERT INTO Patient (IPP, Nom, Prénom,DatedeNaissance,Sexe,MédecinG) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql); 
        statement.setObject(1,this.ipp.getIpp(), Types.INTEGER); 
        statement.setObject(2,p.getNomDeNaissance(),Types.VARCHAR); 
        statement.setObject(3,p.getPrenom(),Types.VARCHAR); 
        statement.setObject(4,p.getDateDeNaissance(),Types.DATE); 
        statement.setObject(5,p.getSexe(),Types.VARCHAR); 
        statement.setObject(6,123,Types.INTEGER); 
        
        statement.executeUpdate();
     }
     catch (SQLException e){
         System.out.println("Patient bien ajouté");
     }
        
   
  
    }
    
    public String getNomUsuel() {
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

    public Date getDateDeNaissance() {
        return DateDeNaissance;
    }

    public void setDateDeNaissance(Date DateDeNaissance) {
        this.DateDeNaissance = DateDeNaissance;
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

    public Adresse getAdresse() {
        return adresse;
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

    public Patient rechercherPatient(String ipp) {
        for (Patient patient : Sih.getPatientList()) {
            if (patient.ipp.equals(ipp)) {
                return patient;
            }
        }
        return null;
    }


}