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
