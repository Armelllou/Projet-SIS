package nf.dossiermedical;

import nf.sejour.Hospitalisation;
import nf.sejour.Observation;
import nf.sejour.Resultats;
import nf.sejour.consultation.Consultation;

import java.util.List;

public class DmAnesthesiste extends Dm {

    public DmAnesthesiste(Observation observation, Resultats resultats, List<Consultation> lc, List<Hospitalisation> lh) {
        super(observation, resultats, lc, lh);
    }
}
