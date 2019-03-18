package nf;


import nf.dossieradministratif.Dma;
import nf.dossiermedical.Dm;
import nf.patient.Patient;
import nf.personnel.Medecin;
import nf.personnel.SecretaireMedical;
import nf.sejour.Acte;
import nf.sejour.Hospitalisation;
import nf.sejour.Observation;

import nf.sejour.consultation.Consultation;

import java.util.ArrayList;
import java.util.List;
import nf.sejour.Resultats;

public class Sih {
    private static List<Patient> patientList = new ArrayList<Patient>();
    private static List<Medecin> medecinList;
    private static List<Dma> dmaList;
    private List<SecretaireMedical> secretaireMedicalList;
    private List<Dm> dmList;
    private List<Observation> observationList;
    private List<Resultats> resultatList;
    private List<Hospitalisation> hospitalisationList;
    private List<Consultation> consultationList;
    private List<Acte> acte;

    public static void ajoutPatient(Patient patient) {
        patientList.add(patient);
    }

    public static List<Medecin> getMedecinList() {
        return medecinList;
    }

    public static List<Dma> getDmaList() {
        return dmaList;
    }

    public static List<Patient> getPatientList() {
        return patientList;
    }

    public static void nouvelleAdmission(Dma dma) {
        dmaList.add(dma);
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

    public List<Resultats> getResultatList() {
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
}
