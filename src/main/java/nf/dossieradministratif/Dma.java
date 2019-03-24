package nf.dossieradministratif;

import nf.patient.Patient;
import nf.personnel.Personnel;

import java.util.Date;

public class Dma {
    private Patient patient;
    private int numeroDeSejour;
    private Date dateEntree;
    private Personnel phRespo;
    private String examenDemandes;

    
    // constructeur de la classe crée un dossier medicoadministratif
    
    public Dma(Patient patient, int numeroDeSejour, Date dateEntree, Personnel phRespo, String examenDemandes) {
        this.patient = patient;
        this.numeroDeSejour = numeroDeSejour;
        this.dateEntree = dateEntree;
        this.phRespo = phRespo;
        this.examenDemandes = examenDemandes;
    }

   
    
}
