package main.java.bd;

import main.java.interfaces.BarreDuHaut;
import main.java.interfaces.ConsulterDPIPHetIDE;
import main.java.nf.patient.Patient;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MethodeBD {

    private static ConsulterDPIPHetIDE consulterDPIPHetIDE;
    private static String sql45;
    private static String sql;
    private static ResultSet rs;
    private static DefaultTableModel templatesTableModel = new DefaultTableModel();
    private static ConnexionBD conn = ConnexionBD.getInstance();
    private static BarreDuHaut bdh;
    private ConnexionBD comm;
    private Statement state;
    private Statement stmt;

    /**
     * Constructeur de la classe, avec en paramètre la connection à la base.
     *
     * @param comm
     * @throws SQLException
     */
    public MethodeBD(ConnexionBD comm) throws SQLException {
        this.state = comm.getConnexion().createStatement();
        this.comm = comm;
    }

    /**
     * Recupère le nombre de patient dans la BD
     *
     * @return int
     */
    public static int nbrePatientBD() throws SQLException {
        int nbre;
        String s;
        sql = "SELECT COUNT(*) FROM `patient`";
        PreparedStatement ps = conn.getConnexion().prepareStatement(sql);
        rs = ps.executeQuery(sql);
        rs.next();
        s = rs.getString(1);
        nbre = Integer.parseInt(s);
        return nbre;
    }

    /**
     * modèle pour remplir la Jtable Avec les patients des infirmières selon son service
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listePatientJTableService() {
        return executeQuery("SELECT DISTINCT * FROM patient NATURAL JOIN localisations JOIN ide ON localisations.ServiceResponsable=ide.Service OR localisations.ServiceGeographique=ide.Service ");
    }

    /**
     * Code qui retourne dans une JTable la liste des patients de la main.java.bd
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listeAllPatientJTable() {
        return executeQuery("SELECT * FROM patient");
    }

    /**
     * Retourne le patient correspondant à l'IPP renseigné
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientViaIPP(String ipp) {
        return executeQuery("Select * FROM patient WHERE IPP ='" + ipp + "'");
    }

    private static DefaultTableModel executeQuery(String query) {
        String[] infoAllPatient = new String[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);

        try {
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps = conn.getConnexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

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
     * Retourne le patient correspondant au nom et prenom pour une secrétaire medicale
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientviaNomEtPrenomSecretaireM(String[] splitArray) {
        try {
            if (splitArray[0].isEmpty()) {
                templatesTableModel = listeAllPatientJTable();
            } else {
                String nom1 = splitArray[0];
                String prenom1 = splitArray[1];
                sql45 = "Select * FROM patient WHERE NomUsuel ='" + nom1 + "'OR NomUsuel ='" + prenom1 + "'OR NomDeNaissance ='" + nom1 + "'OR NomDeNaissance ='" + prenom1 + "'and Prénom ='" + nom1 + "'OR Prénom ='" + prenom1 + "'";
                PreparedStatement ps = conn.getConnexion().prepareStatement(sql45);
                rs = ps.executeQuery(sql45);
                while (rs.next()) {
                    String nomDeNaissance = rs.getString("NomDeNaissance");
                    String nomUsuel = rs.getString("NomUsuel");
                    String prenom = rs.getString("Prénom");
                    String ipp1 = rs.getString("IPP");
                    System.out.println(nomDeNaissance + "\t" + prenom + "\t" + ipp1);
                    templatesTableModel = new DefaultTableModel(new String[][]{{nomDeNaissance, nomUsuel, prenom, ipp1}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Nom de naissance", "Nom usuel", "Prénom", "IPP"});
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return templatesTableModel;
    }

    /**
     * Retourne le patient correspondant au nom et Prenom pour un IDE ou PH
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientviaNomEtPrenomIdeEtPh(String[] splitArray) {
        try {
            if (splitArray[0].isEmpty()) {
                templatesTableModel = listePatientJTableService();
            } else {
                String nom1 = splitArray[0];
                String prenom1 = splitArray[1];
                sql45 = "Select * FROM patient WHERE NomUsuel ='" + nom1 + "'OR NomUsuel ='" + prenom1 + "'OR NomDeNaissance ='" + nom1 + "'OR NomDeNaissance ='" + prenom1 + "'and Prénom ='" + nom1 + "'OR Prénom ='" + prenom1 + "'";
                PreparedStatement ps = conn.getConnexion().prepareStatement(sql45);
                rs = ps.executeQuery(sql45);
                while (rs.next()) {
                    String nomDeNaissance = rs.getString("NomDeNaissance");
                    String nomUsuel = rs.getString("NomUsuel");
                    String prenom = rs.getString("Prénom");
                    String ipp1 = rs.getString("IPP");
                    System.out.println(nomDeNaissance + "\t" + prenom + "\t" + ipp1);
                    templatesTableModel = new DefaultTableModel(new String[][]{{nomDeNaissance, nomUsuel, prenom, ipp1}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Nom de naissance", "Nom usuel", "Prénom", "IPP"});
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return templatesTableModel;
    }

    public void AjouterSurBdPatient(Patient p) throws SQLException {
        String sql = "INSERT INTO Patient (IPP, Nom, Prénom,DatedeNaissance,Sexe,MédecinG) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = comm.getConnexion().prepareStatement(sql);
        statement.setObject(1, p.getIpp(), Types.INTEGER);
        statement.setObject(2, p.getNomDeNaissance(), Types.VARCHAR);
        statement.setObject(3, p.getPrenom(), Types.VARCHAR);
        statement.setObject(4, p.getDateDeNaissance(), Types.DATE);
        statement.setObject(5, p.getSexe(), Types.VARCHAR);
        statement.setObject(6, 123, Types.INTEGER);
        statement.executeUpdate();


    }
}
