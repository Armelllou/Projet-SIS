package main.java.bd;

import main.java.interfaces.BarreDuHaut;
import main.java.interfaces.ConsulterDPIPHetIDE;
import main.java.nf.patient.Ipp;
import main.java.nf.patient.Patient;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MethodeBD {

    private ConnexionBD comm;
    private Statement state;
    private static ConsulterDPIPHetIDE consulterDPIPHetIDE;
    Statement stmt;
    static String sql45;
    static String sql;
    static ResultSet rs;
    static DefaultTableModel templatesTableModel = new DefaultTableModel();

    static ConnexionBD conn = ConnexionBD.getInstance();
    private static BarreDuHaut bdh;

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

    public void AjouterSurBdPatient(Patient p) throws SQLException {
        {
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
    public static DefaultTableModel listePatientJTableService() throws SQLException {
        String[] infoAllPatient = new String[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);

        try {
            //System.out.println("AAA"+ bdh.getService().getText());
            sql45 = "SELECT DISTINCT * FROM patient NATURAL JOIN localisations JOIN ide ON localisations.ServiceResponsable=ide.Service OR localisations.ServiceGeographique=ide.Service ";
            PreparedStatement ps = conn.getConnexion().prepareStatement(sql45);
            rs = ps.executeQuery(sql45);

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
     * Code qui retourne dans une JTable la liste des patients de la main.java.bd
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel listeAllPatientJTable() throws SQLException {

        String sql45;
        ResultSet rs;
        String[] infoAllPatient = new String[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);

        try {
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

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return templatesTableModel;
    }

    /**
     * Retourne le patient correspondant à l'IPP renseigné
     *
     * @return DefaultTableModel
     */
    public static DefaultTableModel recherchePatientViaIPP(String ipp){
        try {
            sql45 = "Select * FROM patient WHERE IPP ='" + ipp + "'";
            PreparedStatement ps = conn.getConnexion().prepareStatement(sql45);
            rs = ps.executeQuery(sql45);
            while (rs.next()) {
                String nomDeNaissance = rs.getString("NomDeNaissance");
                String nomUsuel = rs.getString("NomUsuel");
                String prenom = rs.getString("Prénom");
                String ipp1 = rs.getString("IPP");
                System.out.println(nomDeNaissance + "\t" + prenom + "\t" + ipp1);
                templatesTableModel = new DefaultTableModel(new String[][]{{nomDeNaissance, nomUsuel, prenom, ipp1}}, new String[]{"Nom De Naissance", "Nom Usuel", "Prénom", "IPP"});
            }
            if (ipp == null) {
                 templatesTableModel = new DefaultTableModel(new String[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Nom", "Prénom", "IPP"});

        }} catch (SQLException e2) {
            e2.printStackTrace();
        }
        return templatesTableModel;
    }

    /**
     * Retourne le patient correspondant au nom et Prenom
     *
     * @return DefaultTableModel
     */
    public  static DefaultTableModel recherchePatientviaNomEtPrenomSecretaireM (String[] splitArray){
        try {
            if (splitArray[0].isEmpty()) {
               templatesTableModel= listeAllPatientJTable();
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
    public  static DefaultTableModel recherchePatientviaNomEtPrenomIdeEtPh (String[] splitArray){
        try {
            if (splitArray[0].isEmpty()) {
                templatesTableModel= listePatientJTableService();
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
}
