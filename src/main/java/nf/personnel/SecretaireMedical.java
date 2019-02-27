package main.java.nf.personnel;

import main.java.nf.Sih;
import main.java.nf.dossieradministratif.Dma;
import main.java.nf.patient.Patient;

public class SecretaireMedical extends Personnel {

    public void nouveauPatient(Patient patient) {
        Sih.ajoutPatient(patient);
    }

    public void admission(Dma dma) {
        Sih.nouvelleAdmission(dma);
    }


}
