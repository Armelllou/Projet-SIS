package NF;

import java.util.List;

public class Hospitalisation {
    private Resultat resultat;
    private List<SoinInf> lcSoinIf;
    private List<Prescription>lp;

    public Hospitalisation(Resultat resultat, List<Prescription>lp) {
        this.resultat = resultat;
        this.lp=lp;
    }
}
