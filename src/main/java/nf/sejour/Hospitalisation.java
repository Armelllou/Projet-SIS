package nf.sejour;

import java.util.List;

public class Hospitalisation {
    private Resultats resultat;
    private List<Acte> acte;
    private List<Prescription> lp;

    public Hospitalisation(Resultats resultat, List<Prescription> lp) {
        this.resultat = resultat;
        this.lp = lp;
    }
}
