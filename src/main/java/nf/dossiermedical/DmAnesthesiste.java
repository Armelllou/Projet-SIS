package main.java.nf.dossiermedical;

import main.java.nf.sejour.Hospitalisation;
import main.java.nf.sejour.Observation;
import main.java.nf.sejour.Resultat;
import main.java.nf.sejour.consultation.Consultation;

import java.util.List;

public class DmAnesthesiste extends Dm {

    public DmAnesthesiste(Observation observation, Resultat resultats, List<Consultation> lc, List<Hospitalisation> lh) {
        super(observation, resultats, lc, lh);
    }
}
