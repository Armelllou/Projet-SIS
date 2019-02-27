package main.java.nf.dossieradministratif;

import main.java.nf.patient.Patient;
import main.java.nf.personnel.Personnel;

import java.util.Date;

public class Dma {
    private Patient patient;
    private int numeroDeSejour;
    private Date dateEntree;
    private Personnel PhRespo;
    private String ExamenDemandes;

    public Dma(Patient patient, int numeroDeSejour, Date dateEntree, Personnel phRespo, String examenDemandes) {
        this.patient = patient;
        this.numeroDeSejour = numeroDeSejour;
        this.dateEntree = dateEntree;
        PhRespo = phRespo;
        ExamenDemandes = examenDemandes;
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
        return PhRespo;
    }

    public void setPhRespo(Personnel phRespo) {
        PhRespo = phRespo;
    }

    public String getExamenDemandes() {
        return ExamenDemandes;
    }

    public void setExamenDemandes(String examenDemandes) {
        ExamenDemandes = examenDemandes;
    }
}
