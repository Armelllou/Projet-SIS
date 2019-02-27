package main.java.nf;


import main.java.nf.sejour.*;
import main.java.nf.dossieradministratif.Dma;
import main.java.nf.dossiermedical.Dm;
import main.java.nf.patient.Patient;
import main.java.nf.personnel.Medecin;
import main.java.nf.personnel.SecretaireMedical;
import main.java.nf.sejour.consultation.Consultation;

import java.util.ArrayList;
import java.util.List;

public class Sih {
    private static List<Patient> patientList = new ArrayList();
    private static List<Medecin> medecinList;
    private static List<Dma> dmaList;
    private List<SecretaireMedical> secretaireMedicalList;
    private List<Dm> dmList;
    private List<Observation> observationList;
    private List<Resultat> resultatList;
    private List<Hospitalisation> hospitalisationList;
    private List<Consultation> consultationList;
    private List <Acte> acte;

    public static void ajoutPatient(Patient patient) {
        patientList.add(patient);
    }

    public static List<Medecin> getMedecinList() {
        return medecinList;
    }

    public static List<Dma> getDmaList() {
        return dmaList;
    }

    public List<SecretaireMedical> getSecretaireMedicalList() {
        return secretaireMedicalList;
    }

    public List<Dm> getDmList() {
        return dmList;
    }

    public List<Observation> getObservationList() {
        return observationList;
    }

    public List<Resultat> getResultatList() {
        return resultatList;
    }

    public List<Hospitalisation> getHospitalisationList() {
        return hospitalisationList;
    }

    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public List<Acte> getSoinInfList() {
        return acte;
    }

    public static List<Patient> getPatientList() {
        return patientList;
    }

    public static void nouvelleAdmission(Dma dma) {
        dmaList.add(dma);
    }
}
