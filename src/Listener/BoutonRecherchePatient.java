package Listener;

import BD.ConnexionBD;
import interfaces.ConsulterDPISecretaire;
import interfaces.Fenetre;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BoutonRecherchePatient implements ActionListener {
    Fenetre fen;
    ConsulterDPISecretaire cdpis;
    ConnexionBD conn = new ConnexionBD();

    public BoutonRecherchePatient(Fenetre jframe, ConsulterDPISecretaire cdpis) {
        this.fen = jframe;
        this.cdpis = cdpis;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String ipp = cdpis.getjTextField1().getText();
            String Sql1 = "Select * FROM patient WHERE IPP ='" + ipp + "'";

            java.sql.Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1" + "?serverTimezone=UTC", "armelle", "armelle");
            Statement stmt = null;
            stmt = conn1.createStatement();
            ResultSet rs = stmt.executeQuery(Sql1);
            while (rs.next()) {
                String name = rs.getString("Nom");
                String prenom = rs.getString("Prénom");
                String ipp1 = rs.getString("IPP");
                System.out.println(name + "\t" + prenom + "\t" + ipp1);
                DefaultTableModel templatesTableModel = new DefaultTableModel(new String[][]{{name, prenom, ipp1}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}}, new String[]{"Nom", "Prénom", "IPP"});
                cdpis.getjTable1().setGridColor(new java.awt.Color(153, 153, 153));
                cdpis.getjTable1().setModel(templatesTableModel);
                cdpis.getjTable1().setFont(new java.awt.Font("Calibri", 0, 18));

            }

        } catch (SQLException e1) {
            e1.printStackTrace();
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
            String Sql2 = "Select * FROM patient WHERE Nom ='" + nom1 +"'OR Nom ='"+ prenom1+ "'and Prénom ='"+nom1+ "'OR Prénom ='" + prenom1 + "'";
            java.sql.Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1" + "?serverTimezone=UTC", "armelle", "armelle");
            Statement stmt = null;
            stmt = conn1.createStatement();
            ResultSet rs = stmt.executeQuery(Sql2);
            while (rs.next()) {
                String name = rs.getString("Nom");
                String prenom = rs.getString("Prénom");
                String ipp1 = rs.getString("IPP");
                System.out.println(name + "\t" + prenom + "\t" + ipp1);
                DefaultTableModel templatesTableModel = new DefaultTableModel(new String[][]{{name, prenom, ipp1}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}}, new String[]{"Nom", "Prénom", "IPP"});
                cdpis.getjTable1().setGridColor(new java.awt.Color(153, 153, 153));
                cdpis.getjTable1().setModel(templatesTableModel);
                cdpis.getjTable1().setFont(new java.awt.Font("Calibri", 0, 18));

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }}
