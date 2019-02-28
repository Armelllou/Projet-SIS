package nf.sejour;

import java.util.List;

public class Hospitalisation {
    private Resultat resultat;
    private List<Acte> acte;
    private List<Prescription> lp;

    public Hospitalisation(Resultat resultat, List<Prescription> lp) {
        this.resultat = resultat;
        this.lp = lp;
    }
}
