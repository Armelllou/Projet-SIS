package Listener;

import BD.ConnexionBD;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class BoutonRecherchePatientPhEtIde implements ActionListener {
    Fenetre fen;
    ConsulterDPIPHetIDE cdpis;
    ConnexionBD conn = new ConnexionBD();

    public BoutonRecherchePatientPhEtIde(Fenetre jframe, ConsulterDPIPHetIDE cdpis) {
        this.fen = jframe;
        this.cdpis = cdpis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String ipp = cdpis.getjTextField1().getText();
            String Sql1 = "Select * FROM patient WHERE IPP ='" + ipp + "'";

            Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1" + "?serverTimezone=UTC", "armelle", "armelle");
            Statement stmt = null;
            stmt = conn1.createStatement();
            ResultSet rs = stmt.executeQuery(Sql1);
            while (rs.next()) {
                String nomDeNaissance = rs.getString("NomDeNaissance");
                String nomUsuel = rs.getString("NomUsuel");
                String prenom = rs.getString("Prénom");
                String ipp1 = rs.getString("IPP");
                System.out.println(nomDeNaissance + "\t" + prenom + "\t" + ipp1);
                DefaultTableModel templatesTableModel;

                templatesTableModel = new DefaultTableModel(new String[][]{{nomDeNaissance, nomUsuel, prenom, ipp1}}, new String[]{"Nom De Naissance", "Nom Usuel", "Prénom", "IPP"});
                cdpis.getjTable1().setGridColor(new Color(153, 153, 153));
                cdpis.getjTable1().setModel(templatesTableModel);
                cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
                cdpis.repaint();
                if (cdpis.getjTextField1().getText() == null) {
                    cdpis.repaint();
                    DefaultTableModel templatesTableMode2 = new DefaultTableModel(new String[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Nom", "Prénom", "IPP"});
                    cdpis.getjTable1().setModel(templatesTableMode2);
                    cdpis.getjTable1().clearSelection();
                }

            }

        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        try {
            String ipp = cdpis.getjTextField1().getText();
            if (ipp == null) {
                DefaultTableModel templatesTableModel;

                templatesTableModel = new DefaultTableModel(new String[][]{{null, null, null}}, new String[]{"Nom", "Prénom", "IPP"});
                cdpis.getjTable1().setGridColor(new Color(153, 153, 153));
                cdpis.getjTable1().setModel(templatesTableModel);
                cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
                cdpis.repaint();
            }
        } catch (Exception e3) {
            e3.toString();
        }

        try {
            String nomPrenom = cdpis.getjTextField1().getText();
            String[] splitArray = null; //tableau de chaînes

            // On découpe la chaîne à traiter et on récupère le résultat dans le tableau "splitArray"
            splitArray = nomPrenom.split(" ");

            for (int i = 0; i < splitArray.length; i++) {
                // On affiche chaque élément du tableau
                System.out.println("élement n° " + i + "=[" + splitArray[i] + "]");
            }
            String nom1 = splitArray[0];
            String prenom1 = splitArray[1];
            String Sql2 = "Select * FROM patient WHERE NomUsuel ='" + nom1 + "'OR NomUsuel ='" + prenom1 + "'OR NomDeNaissance ='" + nom1 + "'OR NomDeNaissance ='" + prenom1 + "'and Prénom ='" + nom1 + "'OR Prénom ='" + prenom1 + "'";
            Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1" + "?serverTimezone=UTC", "armelle", "armelle");
            Statement stmt = null;
            stmt = conn1.createStatement();
            ResultSet rs = stmt.executeQuery(Sql2);
            while (rs.next()) {
                String nomDeNaissance = rs.getString("NomDeNaissance");
                String nomUsuel = rs.getString("NomUsuel");
                String prenom = rs.getString("Prénom");
                String ipp1 = rs.getString("IPP");
                System.out.println(nomDeNaissance + "\t" + prenom + "\t" + ipp1);
                DefaultTableModel templatesTableModel;
                templatesTableModel = new DefaultTableModel(new String[][]{{nomDeNaissance, nomUsuel, prenom, ipp1}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Nom de naissance", "Nom usuel", "Prénom", "IPP"});
                cdpis.getjTable1().setGridColor(new Color(153, 153, 153));
                cdpis.getjTable1().setModel(templatesTableModel);
                cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
