/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Adresse;
import NF.Dates;
import NF.Localisation;
import NF.Patient;
import interfaces.BarreDuHaut;
import interfaces.ConsulterDPISecretaire;
import interfaces.CreationDPI;
import interfaces.Fenetre;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author annel
 */
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

            fen.PanelVisibleFalse();
            
             Statement stmt;
        String Sql45;
        ResultSet rs;
        Object[] InfoAllPatient = new Object[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);

        try {
            Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1" + "?serverTimezone=UTC", "armelle", "armelle");
            stmt = conn1.createStatement();
            Sql45 = "SELECT * FROM patient";
            rs = stmt.executeQuery(Sql45);

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
            
            
            

            fen.add(cdpis);
            cdpis.setVisible(true);
            fen.revalidate();
            fen.repaint();

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderDMA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
