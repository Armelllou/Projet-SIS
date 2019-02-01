package NF;

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

    public int getNumeroDeSejour() {
        return numeroDeSejour;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public Personnel getPhRespo() {
        return PhRespo;
    }

    public String getExamenDemandes() {
        return ExamenDemandes;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setNumeroDeSejour(int numeroDeSejour) {
        this.numeroDeSejour = numeroDeSejour;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public void setPhRespo(Personnel phRespo) {
        PhRespo = phRespo;
    }

    public void setExamenDemandes(String examenDemandes) {
        ExamenDemandes = examenDemandes;
    }
}
