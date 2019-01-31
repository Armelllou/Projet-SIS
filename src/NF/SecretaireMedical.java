package NF;

public class SecretaireMedical extends Personnel {

    public void nouveauPatient(Patient patient) {
        Sih.ajoutPatient(patient);

    }

public void admission(Dma dma){
    Sih.nouvelleAdmission(dma);
}
}
