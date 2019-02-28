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

    public Dma(Patient patient, int numeroDeSejour, Date dateEntree, Personnel phRespo, String examenDemandes) {
        this.patient = patient;
        this.numeroDeSejour = numeroDeSejour;
        this.dateEntree = dateEntree;
        this.phRespo = phRespo;
        this.examenDemandes = examenDemandes;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getNumeroDeSejour() {
        return numeroDeSejour;
    }

    public void setNumeroDeSejour(int numeroDeSejour) {
        this.numeroDeSejour = numeroDeSejour;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Personnel getPhRespo() {
        return phRespo;
    }

    public void setPhRespo(Personnel phRespo) {
        this.phRespo = phRespo;
    }

    public String getExamenDemandes() {
        return examenDemandes;
    }

    public void setExamenDemandes(String examenDemandes) {
        this.examenDemandes = examenDemandes;
    }
}
