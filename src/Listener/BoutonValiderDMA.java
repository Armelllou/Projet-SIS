/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Adresse;
import NF.Dates;
import NF.Patient;
import interfaces.AccueilSecretaires;
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
public class BoutonValiderDMA implements ActionListener{
    AccueilSecretaires as;
    Fenetre fen;
    ConsulterDPISecretaire cdpis;
    CreationDPI cdpi;

    public BoutonValiderDMA(AccueilSecretaires as,  ConsulterDPISecretaire cdpis, Fenetre jframe, CreationDPI cdpi) {
        this.fen = jframe;
        this.cdpis = cdpis;
        this.as = as;
        this.cdpi=cdpi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        try {
            Patient p = new Patient(cdpi.getNom().getText(), new Dates(cdpi.getJour().getText(), cdpi.getMois().getText(), cdpi.getAnnee().getText()),"f", cdpi.getPrenom().getText(), new Adresse(cdpi.getAdresse().getText(), cdpi.getVille().getText(), cdpi.getCodePostal().getText()));
            p.AjouterSurBdPatient(p);

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
