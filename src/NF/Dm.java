package NF;

import java.util.List;

public abstract class Dm {
    private Observation observation;
    private Resultat resultats;
    private List<Consultation> lc;
    private List<Hospitalisation> lh;

    public Dm(Observation observation, Resultat resultats, List<Consultation> lc, List<Hospitalisation> lh) {
        this.observation = observation;
        this.resultats = resultats;
        this.lc = lc;
        this.lh = lh;
    }



}
