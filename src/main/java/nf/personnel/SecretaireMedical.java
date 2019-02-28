package nf.personnel;

import nf.Sih;
import nf.dossieradministratif.Dma;
import nf.patient.Patient;

public class SecretaireMedical extends Personnel {

    public void nouveauPatient(Patient patient) {
        Sih.ajoutPatient(patient);
    }

    public void admission(Dma dma) {
        Sih.nouvelleAdmission(dma);
    }


}
