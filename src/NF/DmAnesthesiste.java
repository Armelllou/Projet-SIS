package NF;

import java.util.List;

public class DmAnesthesiste extends Dm{

    public DmAnesthesiste(Observation observation, Resultat resultats, List<Consultation> lc, List<Hospitalisation> lh) {
        super(observation, resultats, lc, lh);
    }
}
