package main.java.nf.sejour.consultation;

import main.java.nf.personnel.Personnel;
import main.java.nf.sejour.Prescription;

import java.util.List;

public class ConsultExt extends Consultation {

    public ConsultExt(Personnel pH, List<Prescription> lp) {
        super(pH, lp);
    }
}
