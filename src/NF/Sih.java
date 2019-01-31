package NF;

import fr.polytech.tis.sis.Medecin;

import java.util.List;

public class Sih {
    private static List<Patient> patientList;
    private List<Medecin> medecinList;
    private static List<Dma> dmaList;
    private List<SecretaireMedical> secretaireMedicalList;
    private List<Dm> dmList;
    private List<Observation> observationList;
    private List<Resultat> resultatList;
    private List<Hospitalisation> hospitalisationList;
    private List<Consultation> consultationList;
    private List <SoinInf> soinInfList;

    public static void ajoutPatient(Patient patient) {
        patientList.add(patient);
    }


    public static void nouvelleAdmission(Dma dma) {
        dmaList.add(dma);
    }
}
