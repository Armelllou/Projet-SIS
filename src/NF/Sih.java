package NF;

import fr.polytech.tis.sis.Medecin;

import java.util.List;

public class Sih {
    private List<Patient> patientList;
    private List<Medecin> medecinList;
    private List<Dma> dmaList;
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
}
