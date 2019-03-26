package bd;

import listener.commun.State;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class MethodeBD {
    private static final String PRENOM = "Prénom";
    private static final String NOM_NAISSANCE = "NomDeNaissance";
    private static final String NOM_USUEL = "NomUsuel";


    public static ResultSet executeQuery(String query) {
        try {
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps = conn.getConnexion().prepareStatement(query);
            return ps.executeQuery(query);
        } catch (SQLException e) {
            Logger.getLogger(ResultSet.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    private static DefaultTableModel execute(String query) {
        String[] infoAllPatient = new String[4];
        String title[] = {NOM_NAISSANCE, NOM_USUEL, PRENOM, "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString(NOM_NAISSANCE);
                infoAllPatient[1] = rs.getString(NOM_USUEL);
                infoAllPatient[2] = rs.getString(PRENOM);
                infoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }
        finally {
        }
        return templatesTableModel;
    }

    private static DefaultTableModel executeRecherchePersonnel(String query, String type) {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", PRENOM, "id"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");

                if(type.equals("ph")){ infoAllPatient[2] = rs.getString("idPH");infoAllPatient[1] = rs.getString("Prenom");}

                if(type.equals("ide")){ infoAllPatient[2] = rs.getString("idIDE");infoAllPatient[1] = rs.getString("Prenom");}
                if(type.equals("SA")) {
                    infoAllPatient[1] = rs.getString(PRENOM);
                    infoAllPatient[2] = rs.getString("idSA");
                }
                if(type.equals("MT")) { infoAllPatient[2] = rs.getString("idMT");infoAllPatient[1] = rs.getString("Prenom");}
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }
        finally {
        }
        return templatesTableModel;
    }

    /**
     * modèle pour remplir la Jtable avec les consultations d'un patient
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listeConsultationJTableServiceIde(String ipp) {
        String[] infoAllPatient = new String[2];
        String title[] = {"Nom Du Medecin", "Date"};
        String query = "SELECT * FROM consultation WHERE IPP ='" + ipp + "'";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("NomMedecin");
                infoAllPatient[1] = rs.getString("Date");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }
        finally {
        }
        return templatesTableModel;
    }

    /**
     * modèle pour remplir la Jtable avec les prestations
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listePrestation() {
        String[] infoAllPatient = new String[7];
        String title[] = {"Nom ", PRENOM, "IPP", "Prestation à effectuer", "ServiceDemandeur", "Médecin Prescripteur", "Date de Demande"};
        String query = "SELECT * FROM prestationaeffectuer ";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("NomPatient");
                infoAllPatient[1] = rs.getString("PrenomPatient");
                infoAllPatient[2] = rs.getString("IPP");
                infoAllPatient[3] = rs.getString("PrestationDemande");
                infoAllPatient[4] = rs.getString("ServiceDemandeur");
                infoAllPatient[5] = rs.getString("NomPh") + " " + rs.getString("PrenomPH");
                infoAllPatient[6] = rs.getString("DateDeDemande");

                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
        }
        return templatesTableModel;
    }

    public static DefaultTableModel listeResultats(String service) {
        String[] infoAllPatient = new String[6];
        String title[] = {"Nom ", PRENOM, "IPP", "résultats", "Service Demandeur", "Date de résultats"};
        String query = "SELECT * FROM prestationsfaites WHERE serviceDemandeur = '" + service + "'";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("NomPatient");
                infoAllPatient[1] = rs.getString("PrenomPatient");
                infoAllPatient[2] = rs.getString("IPP");
                infoAllPatient[3] = rs.getString("Resultats");
                infoAllPatient[4] = rs.getString("ServiceDemandeur");
                infoAllPatient[5] = rs.getString("DateEffectuee");

                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
        }
        return templatesTableModel;
    }

    /**
     * modèle pour remplir la Jtable avec les actes d'un patient selon service
     * IDE
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listeActeJTableServiceIde(String ipp) {
        String[] infoAllPatient = new String[3];
        String title[] = {"Type d'acte", "Nom de l'Ide", "Date"};
        String query = "SELECT * FROM ide NATURAL JOIN actes WHERE IPP ='" + ipp + "'";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("type");
                infoAllPatient[1] = rs.getString("Nom") + " " + rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("Date");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
        }
        return templatesTableModel;
    }
    
    /**
     * modèle pour remplir la Jtable avec les prescription d'un patient selon service
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listeResultatsParPatients(String ipp) {
        String[] infoAllPatient = new String[5];
        String title[] = {"Nom", PRENOM, "IPP","Résultats","Date des Résulats"};
        String query = "SELECT * FROM ResultatsLus WHERE IPP ='" + ipp + "'";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("NomPatient");
                infoAllPatient[1] = rs.getString("PrenomPatient");
                infoAllPatient[2] = rs.getString("IPP") ;
                infoAllPatient[3] = rs.getString("Resultats");
                infoAllPatient[4] = rs.getString("DateEffectuee");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
        }
        return templatesTableModel;
    }
    
    
    

    /**
     * modèle pour remplir la Jtable avec les prescription d'un patient
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listePrescriptionJTableServiceIde(String ipp) {
        String[] infoAllPatient = new String[3];
        String title[] = {"Type de prescription", "Medecin prescripteur", "Date"};
        String query = "SELECT * FROM prescription NATURAL JOIN praticienhospitaliers WHERE IPP='" + ipp + "'";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("type");
                infoAllPatient[1] = rs.getString("Nom") + " " + rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("Date");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
       }
        return templatesTableModel;
    }

    public static DefaultTableModel listeIDE() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", PRENOM, "Id"};
        String query = "SELECT * FROM ide";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");
                infoAllPatient[1] = rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("idIDE");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
        }
        return templatesTableModel;
    }

    public static DefaultTableModel listePH() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", PRENOM, "Id"};
        String query = "SELECT * FROM praticienhospitaliers";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");
                infoAllPatient[1] = rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("idPh");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
        }
        return templatesTableModel;
    }

    public static DefaultTableModel listeSA() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", PRENOM, "id"};
        String query = "SELECT * FROM secretaireadministrative";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");
                infoAllPatient[1] = rs.getString(PRENOM);
                infoAllPatient[2] = rs.getString("idSA");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
        }
        return templatesTableModel;
    }

    public static DefaultTableModel listeMT() {
        String[] infoAllPatient = new String[3];
        String title1[] = {"Nom", PRENOM, "id"};
        String query = "SELECT * FROM medicotechniques";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title1);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");
                infoAllPatient[1] = rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("idMT");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
       }
        return templatesTableModel;
    }

    /**
     * modèle pour remplir la Jtable avec les patients des infirmières selon son
     * service
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listePatientJTableServiceIde(String service) {
        String[] infoAllPatient = new String[4];
        String title[] = {NOM_NAISSANCE, NOM_USUEL, PRENOM, "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        String query = "SELECT * "
                + "FROM patient "
                + "NATURAL JOIN localisations "
                + "JOIN ide ON localisations.ServiceResponsable=ide.Service OR localisations.ServiceGeographique=ide.Service "
                + "NATURAL JOIN hospitalisation "
                + "WHERE ide.Service = '" + service + "'"
                + "AND hospitalisation.DateSortieH IS NULL ";

        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }

        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString(NOM_NAISSANCE);
                infoAllPatient[1] = rs.getString(NOM_USUEL);
                infoAllPatient[2] = rs.getString(PRENOM);
                infoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }

        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
         }
        try{
            String query1 = "SELECT * " +
                    "FROM patient " +
                    "NATURAL JOIN localisations " +
                    "JOIN ide ON localisations.ServiceResponsable=ide.Service OR localisations.ServiceGeographique=ide.Service " +
                    "NATURAL JOIN consultationexterne " +
                    "WHERE ide.Service = '" + service + "'" +
                    "AND consultationexterne.DateSortiec IS NULL ";
            ResultSet rs1 = executeQuery(query1);
            if (rs1 == null) {
                return templatesTableModel;
            }

            while (rs1.next()) {
                infoAllPatient[0] = rs1.getString(NOM_NAISSANCE);
                infoAllPatient[1] = rs1.getString(NOM_USUEL);
                infoAllPatient[2] = rs1.getString(PRENOM);
                infoAllPatient[3] = rs1.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
         }
        return templatesTableModel;

    }

    /**
     * modèle pour remplir la Jtable Avec les patients des PH selon son service
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listePatientJTableServicePH(String service) {
        String[] infoAllPatient = new String[4];
        String title[] = {NOM_NAISSANCE, NOM_USUEL, PRENOM, "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        String query = "SELECT * "
                + "FROM patient "
                + "NATURAL JOIN localisations "
                + "JOIN praticienhospitaliers ON localisations.ServiceResponsable=praticienhospitaliers.Service OR localisations.ServiceGeographique=praticienhospitaliers.Service "
                + "NATURAL JOIN hospitalisation "
                + "WHERE praticienhospitaliers.Service = '" + service + "'"
                + "AND hospitalisation.DateSortieH IS NULL ";

        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }

        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString(NOM_NAISSANCE);
                infoAllPatient[1] = rs.getString(NOM_USUEL);
                infoAllPatient[2] = rs.getString(PRENOM);
                infoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }

        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {
        }
        try{
            String query1 = "SELECT * " +
                    "FROM patient " +
                    "NATURAL JOIN localisations " +
                    "JOIN praticienhospitaliers ON localisations.ServiceResponsable=praticienhospitaliers.Service OR localisations.ServiceGeographique=praticienhospitaliers.Service " +
                    "NATURAL JOIN consultationexterne " +
                    "WHERE praticienhospitaliers.Service = '" + service + "'" +
                    "AND consultationexterne.DateSortiec IS NULL ";
            ResultSet rs1 = executeQuery(query1);
            if (rs1 == null) {
                return templatesTableModel;
            }

            while (rs1.next()) {
                infoAllPatient[0] = rs1.getString(NOM_NAISSANCE);
                infoAllPatient[1] = rs1.getString(NOM_USUEL);
                infoAllPatient[2] = rs1.getString(PRENOM);
                infoAllPatient[3] = rs1.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            Logger.getLogger(DefaultTableModel.class.getName()).log(Level.SEVERE, null, e1);
        }finally {

        }
        return templatesTableModel;

    }

    /**
     * Code qui retourne dans une JTable la liste des patients de la bd
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listeAllPatientJTable() {
        return execute("SELECT * FROM patient");
    }

    /**
     * Retourne le patient correspondant à l'IPP renseigné
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientViaIPP(String ipp) {
        return execute("Select * FROM patient WHERE IPP ='" + ipp + "'");
    }

    /**
     * Retourne le praticien hospitalier correspondant à l'id renseigné
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePHViaIPP(String id) {

        return executeRecherchePersonnel("Select * FROM praticienhospitaliers WHERE idPh ='" + id + "'","ph");
    }

    /**
     * Retourne l'ide correspondant à l'id renseigné
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel rechercheIdeViaIPP(String id) {
        return executeRecherchePersonnel("Select * FROM ide WHERE idIDE ='" + id + "'","ide");
    }

    /**
     * Retourne le medicotechnique correspondant à l'id renseigné
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel rechercheMedicoTechViaIPP(String id) {
        return executeRecherchePersonnel("Select * FROM medicotechniques WHERE idMT ='" + id + "'","MT");
    }


    /**
     * Retourne la/le secrétaire adminitrative correspondant à l'id renseigné
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel rechercheSAdViaIPP(String id) {
        return executeRecherchePersonnel("Select * FROM  secretaireadministrative WHERE idSA ='" + id + "'","SA");
    }


    /**
     * Retourne le patient correspondant au nom et prenom pour une secrétaire
     * medicale
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientviaNomEtPrenomSecretaireM(String[] splitArray) {
        if (splitArray[0].isEmpty()) {
            return listeAllPatientJTable();
        } else {
            String nom = splitArray[0];
            String prenom = splitArray[1];
            return execute("Select * FROM patient WHERE NomUsuel ='" + nom + "'"
                    + "OR NomUsuel ='" + prenom + "'"
                    + "OR NomDeNaissance ='" + nom + "'"
                    + "OR NomDeNaissance ='" + prenom + "'and Prénom ='" + nom + "'"
                    + "OR Prénom ='" + prenom + "'");
        }
    }

    /**
     * Retourne le patient correspondant au nom et Prenom pour un IDE ou PH
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientviaNomEtPrenomIdeEtPh(String[] splitArray, String service, State state) {
        if (splitArray[0].isEmpty() && state == State.PH) {
            return listePatientJTableServicePH(service);
        }
        if (splitArray[0].isEmpty() && state == State.IDE) {
            return listePatientJTableServiceIde(service);
        } else {
            String nom = splitArray[0];
            String prenom = splitArray[1];
            return execute("Select * FROM patient WHERE NomUsuel ='" + nom + "'"
                    + "OR NomUsuel ='" + prenom + "'"
                    + "OR NomDeNaissance ='" + nom + "'"
                    + "OR NomDeNaissance ='" + prenom + "'and Prénom ='" + nom + "'"
                    + "OR Prénom ='" + prenom + "'");
        }
    }

     public static DefaultTableModel PatientSecretaire (JTable table){
         return execute("SELECT * FROM patient");

     }
 
    
    public static int compterTableauPrestationParService(String Service) throws SQLException {
        ResultSet rs = executeQuery("SELECT COUNT(*) FROM `prestationsfaites` WHERE serviceDemandeur = '" + Service + "'");
        rs.next();
        String s = rs.getString(1);
        int nbre = Integer.parseInt(s);
        return nbre;
    }
    
    //méthodes de suppression Personnel 

     public static void SupprimerSurBdIDE (int id) throws SQLException{
        ConnexionBD conn = ConnexionBD.getInstance();
        PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from ide WHERE idIDE ='" + id + "'");
        prep2.executeUpdate();       
    }
     
      public static void SupprimerSurBdPH (int id) throws SQLException{
       ConnexionBD conn = ConnexionBD.getInstance();
       PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE from praticienhospitaliers WHERE idPh ='" + id + "'");
       prep2.executeUpdate();
                    
      }
       public static void SupprimerSurBdTechnicien (int id) throws SQLException{
      ConnexionBD conn = ConnexionBD.getInstance();
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from technicien WHERE idTECH ='" + id + "'");
                    prep2.executeUpdate();
       }
       
       
      public static void SupprimerSurBdMedichoTech (int id) throws SQLException{  
        ConnexionBD conn = ConnexionBD.getInstance();
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from medicotechniques WHERE idMT ='" + id + "'");
                    prep2.executeUpdate();
                    
      }
      
      public static void SupprimerSurBdSecretaire (int id) throws SQLException{  
                    ConnexionBD conn = ConnexionBD.getInstance();
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from secretaireadministrative WHERE idSA ='" + id + "'");
                    prep2.executeUpdate();
      }

      
      
}
