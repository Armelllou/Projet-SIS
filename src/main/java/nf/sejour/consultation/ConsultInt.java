package nf.sejour.consultation;

import nf.personnel.Personnel;
import nf.sejour.Prescription;

import java.util.List;

public class ConsultInt extends Consultation {

    public ConsultInt(Personnel pH, List<Prescription> lp) {
        super(pH, lp);
    }
}
