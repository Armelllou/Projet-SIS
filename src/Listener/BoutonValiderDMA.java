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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

            fen.add(cdpis);
            cdpis.setVisible(true);
            fen.revalidate();
            fen.repaint();

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderDMA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
