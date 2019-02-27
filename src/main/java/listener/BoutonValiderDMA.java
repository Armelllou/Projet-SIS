/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.bd.ConnexionBD;
import main.java.interfaces.Fenetre;
import main.java.interfaces.dpi.CreationDPI;
import main.java.interfaces.secretaire.ConsulterDPISecretaire;
import main.java.nf.Dates;
import main.java.nf.localisation.Localisation;
import main.java.nf.patient.Adresse;
import main.java.nf.patient.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoutonValiderDMA implements ActionListener {

    Fenetre fen;
    ConsulterDPISecretaire cdpis;
    CreationDPI cdpi;

    public BoutonValiderDMA(ConsulterDPISecretaire cdpis, Fenetre jframe, CreationDPI cdpi) {
        this.fen = jframe;
        this.cdpis = cdpis;
        this.cdpi = cdpi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Patient p = new Patient(cdpi.getNomdeNaissance().getText(), cdpi.getNom().getText(), new Dates(cdpi.getJour().getText(), cdpi.getMois().getText(), cdpi.getAnnee().getText()), cdpi.getGenre().getSelectedItem().toString(), cdpi.getPrenom().getText(), new Adresse(cdpi.getAdresse().getText(), cdpi.getVille().getText(), cdpi.getCodePostal().getText()), cdpi.getNumSS().getText(), cdpi.getEmail().getText(), cdpi.getTelephone().getText());
            Localisation localisation;
            localisation = new Localisation(p, cdpi.getServiceGeo().getSelectedItem().toString(), cdpi.getServiceRespo().getSelectedItem().toString());
            p.AjouterSurBdPatient(p);
            localisation.AjouterSurBdLocalisation(localisation);
            JOptionPane jop1 = new JOptionPane();

            jop1.showMessageDialog(null, "Patient correctement ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
            fen.panelVisibleFalse();
            Statement stmt;
            String sql45;
            ResultSet rs;
            String[] infoallpatient = new String[4];
            String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
            DefaultTableModel templatesTableModel = new DefaultTableModel();
            templatesTableModel.setColumnIdentifiers(title);

            try {
                sql45 = "SELECT * FROM patient";
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement ps = conn.getConnexion().prepareStatement(sql45);
                rs = ps.executeQuery(sql45);

                while (rs.next()) {
                    infoallpatient[0] = rs.getString("NomDeNaissance");
                    infoallpatient[1] = rs.getString("NomUsuel");
                    infoallpatient[2] = rs.getString("Prénom");
                    infoallpatient[3] = rs.getString("IPP");
                    templatesTableModel.addRow(infoallpatient);
                }
                cdpis.getjTable1().setModel(templatesTableModel);
                cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
                System.out.println(cdpis.getjTable1().getModel());

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            fen.add(cdpis);
            cdpis.setVisible(true);
            fen.revalidate();
            fen.repaint();

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderDMA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}