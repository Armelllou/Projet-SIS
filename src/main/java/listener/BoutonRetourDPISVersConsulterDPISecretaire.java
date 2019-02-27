/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.bd.ConnexionBD;
import main.java.interfaces.Fenetre;
import main.java.interfaces.secretaire.ConsulterDPISecretaire;
import main.java.interfaces.secretaire.DPISecretaire;
import main.java.nf.Sih;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Manon
 */
public class BoutonRetourDPISVersConsulterDPISecretaire implements ActionListener {

    DPISecretaire dpis;
    ConsulterDPISecretaire cdpis;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourDPISVersConsulterDPISecretaire(Fenetre jframe, ConsulterDPISecretaire cdpis, DPISecretaire dpis, Sih sih) {
        this.jframe = jframe;
        this.cdpis = cdpis;
        this.dpis = dpis;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {

        Statement stmt;
        String Sql45;
        ResultSet rs;
        Object[] InfoAllPatient = new Object[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);

        try {
            ConnexionBD conn = ConnexionBD.getInstance();


            Sql45 = "SELECT * FROM patient";
            PreparedStatement ps = conn.getConnexion().prepareStatement(Sql45);
            ResultSet Rs = ps.executeQuery();
            ;
            rs = ps.executeQuery(Sql45);

            while (rs.next()) {
                InfoAllPatient[0] = rs.getString("NomDeNaissance");
                InfoAllPatient[1] = rs.getString("NomUsuel");
                InfoAllPatient[2] = rs.getString("Prénom");
                InfoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(InfoAllPatient);
            }

            cdpis.getjTable1().setModel(templatesTableModel);
            cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
            System.out.println(cdpis.getjTable1().getModel());

        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        jframe.PanelVisibleFalse();
        jframe.add(cdpis);
        cdpis.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
