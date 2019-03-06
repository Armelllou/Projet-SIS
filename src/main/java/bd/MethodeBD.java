package bd;
import listener.State;
import nf.patient.Patient;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

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
        }
        return null;
    }

    private static DefaultTableModel execute(String query) {
        String[] infoAllPatient = new String[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if(rs == null) {
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
        if(rs == null) {
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
        return templatesTableModel;
    }

    /**
     * modèle pour remplir la Jtable avec les actes d'un patient selon service IDE
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
        if(rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("type");
                infoAllPatient[1] = rs.getString("Nom") + " " +rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("idActe");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
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
        if(rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("type");
                infoAllPatient[1] = rs.getString("Nom") + " " +rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("Date");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return templatesTableModel;
    }

    public static DefaultTableModel listeIDE() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", "Prénom", "Service"};
        String query = "SELECT * FROM ide";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if(rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");
                infoAllPatient[1] = rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("Service");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return templatesTableModel;
    }

    
    public static DefaultTableModel listePH() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", "Prénom", "Service"};
        String query = "SELECT * FROM praticienhospitaliers";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if(rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");
                infoAllPatient[1] = rs.getString("Prenom");
                infoAllPatient[2] = rs.getString("Service");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return templatesTableModel;
    }
    
    
     public static DefaultTableModel listeSA() {
        String[] infoAllPatient = new String[3];
        String title[] = {"Nom", "Prénom", "Service"};
        String query = "SELECT * FROM secretaireadministrative";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if(rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");
                infoAllPatient[1] = rs.getString("Prénom");
                infoAllPatient[2] = rs.getString("Service");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return templatesTableModel;
    }
     
     
 public static DefaultTableModel listeMT() {
        String[] infoAllPatient = new String[2];
        String title[] = {"Nom", "Prénom"};
        String query = "SELECT * FROM medicotechniques";
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);
        ResultSet rs = executeQuery(query);
        if(rs == null) {
            return templatesTableModel;
        }
        try {
            while (rs.next()) {
                infoAllPatient[0] = rs.getString("Nom");
                infoAllPatient[1] = rs.getString("Prenom");
                templatesTableModel.addRow(infoAllPatient);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return templatesTableModel;
    }


    /**
     * modèle pour remplir la Jtable avec les patients des infirmières selon son service
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listePatientJTableServiceIde(String service) {
        return execute("SELECT * FROM patient NATURAL JOIN localisations " +
                "JOIN ide ON localisations.ServiceResponsable=ide.Service " +
                "OR localisations.ServiceGeographique=ide.Service " +
                "WHERE ide.Service ='" + service + "'");

    }

    /**
     * modèle pour remplir la Jtable Avec les patients des PH selon son service
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listePatientJTableServicePH(String service) {
        return execute("SELECT * FROM patient NATURAL JOIN localisations " +
                "JOIN praticienhospitaliers ON localisations.ServiceResponsable=praticienhospitaliers.Service " +
                "OR localisations.ServiceGeographique=praticienhospitaliers.Service " +
                "WHERE praticienhospitaliers.Service ='" + service + "'");
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
     * Retourne le patient correspondant au nom et prenom pour une secrétaire medicale
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientviaNomEtPrenomSecretaireM(String[] splitArray) {
        if (splitArray[0].isEmpty()) {
            return listeAllPatientJTable();
        } else {
            String nom = splitArray[0];
            String prenom = splitArray[1];
            return execute("Select * FROM patient WHERE NomUsuel ='" + nom + "'" +
                    "OR NomUsuel ='" + prenom + "'" +
                    "OR NomDeNaissance ='" + nom + "'" +
                    "OR NomDeNaissance ='" + prenom + "'and Prénom ='" + nom + "'" +
                    "OR Prénom ='" + prenom + "'");
        }
    }

    /**
     * Retourne le patient correspondant au nom et Prenom pour un IDE ou PH
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientviaNomEtPrenomIdeEtPh(String[] splitArray, String service, State state) {
        if (splitArray[0].isEmpty()&& state == State.PH) {
            System.out.println("Test :" + service);
            return listePatientJTableServicePH(service);
        }
        if (splitArray[0].isEmpty()&& state == State.IDE) return listePatientJTableServiceIde(service);
        else {
            String nom = splitArray[0];
            String prenom = splitArray[1];
            return execute("Select * FROM patient WHERE NomUsuel ='" + nom + "'" +
                    "OR NomUsuel ='" + prenom + "'" +
                    "OR NomDeNaissance ='" + nom + "'" +
                    "OR NomDeNaissance ='" + prenom + "'and Prénom ='" + nom + "'" +
                    "OR Prénom ='" + prenom + "'");
        }
    }

    public void AjouterSurBdPatient(Patient p) throws SQLException {
        String sql = "INSERT INTO patient (IPP, Nom, Prénom,DatedeNaissance,Sexe,MédecinG) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = ConnexionBD.getInstance().getConnexion().prepareStatement(sql);
        statement.setObject(1, p.getIpp(), Types.INTEGER);
        statement.setObject(2, p.getNomDeNaissance(), Types.VARCHAR);
        statement.setObject(3, p.getPrenom(), Types.VARCHAR);
        statement.setObject(4, p.getDateDeNaissance(), Types.DATE);
        statement.setObject(5, p.getSexe(), Types.VARCHAR);
        statement.setObject(6, 123, Types.INTEGER);
        statement.executeUpdate();
    }
}
