package nf.sejour.consultation;

import nf.personnel.Personnel;
import nf.sejour.Prescription;

import java.util.List;

public class ConsultExt extends Consultation {

    public ConsultExt(Personnel pH, List<Prescription> lp) {
        super(pH, lp);
    }
}
