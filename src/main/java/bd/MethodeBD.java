package bd;

import interfaces.ConsulterDPIPHetIDE;
import java.awt.Font;
import listener.commun.State;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.TimerTask;
import javax.swing.JTable;
import javax.swing.Timer;

public class MethodeBD {

    /**
     * Constructeur de la classe, avec en paramètre la connection à la base.
     */
    public MethodeBD() {
    }

    public static ResultSet executeQuery(String query) {
        try {
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps = conn.getConnexion().prepareStatement(query);
            return ps.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
        return null;
    }

    private static DefaultTableModel execute(String query) {
        String[] infoAllPatient = new String[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if (rs == null) {
            return templatesTableModel;
        }

        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("NomDeNaissance");
                infoAllPatient[1] = rs.getString("NomUsuel");
                infoAllPatient[2] = rs.getString("Prénom");
                infoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        finally {
        }
        return templatesTableModel;
    }

    /**
     * Recupère le nombre de patient dans la BD
     *
     * @return int
     */
    public static int nbrePatientBD() throws SQLException {
        int nbre;
        String s;
        String sql = "SELECT COUNT(*) FROM `patient`";
        PreparedStatement ps = ConnexionBD.getInstance().getConnexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        rs.next();
        s = rs.getString(1);
        nbre = Integer.parseInt(s);
        return nbre;
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
            e1.printStackTrace();
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
        String title[] = {"Nom ", "Prénom", "IPP", "Prestation à effectuer", "ServiceDemandeur", "Médecin Prescripteur", "Date de Demande"};
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
            e1.printStackTrace();
        }finally {
        }
        return templatesTableModel;
    }

    public static DefaultTableModel listeResultats(String service) {
        String[] infoAllPatient = new String[6];
        String title[] = {"Nom ", "Prénom", "IPP", "résultats", "Service Demandeur", "Date de résultats"};
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
            e1.printStackTrace();
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
            e1.printStackTrace();
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
        String title[] = {"Nom", "Prénom", "IPP","Résultats","Date des Résulats"};
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
            e1.printStackTrace();
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
            e1.printStackTrace();
        }finally {
       }
        return templatesTableModel;
    }

    public static DefaultTableModel listeIDE() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", "Prénom", "Id"};
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
        String title[] = {"Nom", "Prénom", "Id"};
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
            e1.printStackTrace();
        }finally {
        }
        return templatesTableModel;
    }

    public static DefaultTableModel listeSA() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", "Prénom", "id"};
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
                infoAllPatient[1] = rs.getString("Prénom");
                infoAllPatient[2] = rs.getString("idSA");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
        }
        return templatesTableModel;
    }

    public static DefaultTableModel listeMT() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", "Prénom", "id"};
        String query = "SELECT * FROM medicotechniques";
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
                infoAllPatient[2] = rs.getString("idMT");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
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
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
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
                infoAllPatient[0] = rs.getString("NomDeNaissance");
                infoAllPatient[1] = rs.getString("NomUsuel");
                infoAllPatient[2] = rs.getString("Prénom");
                infoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
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
                infoAllPatient[0] = rs1.getString("NomDeNaissance");
                infoAllPatient[1] = rs1.getString("NomUsuel");
                infoAllPatient[2] = rs1.getString("Prénom");
                infoAllPatient[3] = rs1.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
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
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
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
                infoAllPatient[0] = rs.getString("NomDeNaissance");
                infoAllPatient[1] = rs.getString("NomUsuel");
                infoAllPatient[2] = rs.getString("Prénom");
                infoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
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
                infoAllPatient[0] = rs1.getString("NomDeNaissance");
                infoAllPatient[1] = rs1.getString("NomUsuel");
                infoAllPatient[2] = rs1.getString("Prénom");
                infoAllPatient[3] = rs1.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
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
            System.out.println("Test :" + service);
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

     public static DefaultTableModel PatientSecretaire (JTable table) throws SQLException{
         
          String sql45;
        ResultSet rs;
        String[] infoAllPatient = new String[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);


            ConnexionBD conn = ConnexionBD.getInstance();
            sql45 = "SELECT * FROM patient";
            PreparedStatement ps = conn.getConnexion().prepareStatement(sql45);
            rs = ps.executeQuery(sql45);
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("NomDeNaissance");
                infoAllPatient[1] = rs.getString("NomUsuel");
                infoAllPatient[2] = rs.getString("Prénom");
                infoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(infoAllPatient);
            }

            table.setModel(templatesTableModel);
            table.setFont(new Font("Calibri", 0, 18));
         
            return templatesTableModel;
     }
 
    
    public static int compterTableauPrestationParService(String Service) throws SQLException {
        String sql45 = "SELECT COUNT(*) FROM `prestationsfaites` WHERE serviceDemandeur = '" + Service + "'";
        ConnexionBD conn = ConnexionBD.getInstance();
        PreparedStatement ps = conn.getConnexion().prepareStatement(sql45);
        ResultSet rs = ps.executeQuery(sql45);
        rs.next();
        String s = rs.getString(1);
        int nbre = Integer.parseInt(s);
        return nbre;
    }
    
    
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
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from Technicien WHERE idTECH ='" + id + "'");
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
