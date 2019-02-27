package main.java.nf.sejour.consultation;

import main.java.nf.personnel.Personnel;
import main.java.nf.sejour.Prescription;

import java.util.List;

public abstract class Consultation {
    private Personnel pH;
    private List<Prescription> lp;

    public Consultation(Personnel pH,List<Prescription> lp ) {
        this.pH = pH;
        this.lp=lp;
    }
}
