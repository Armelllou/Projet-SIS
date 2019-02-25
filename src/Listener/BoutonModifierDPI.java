/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import BD.ConnexionBD;
import NF.Sih;
import interfaces.DPISecretaire;
import interfaces.Fenetre;
import interfaces.ModificationDPI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manon
 */
public class BoutonModifierDPI implements ActionListener {

    DPISecretaire dpis;
    ModificationDPI mdpi;
    Fenetre jframe;
    Sih sih;

    public BoutonModifierDPI(Fenetre jframe, DPISecretaire dpis, ModificationDPI mdpi, Sih sih) {
        this.jframe = jframe;
        this.mdpi = mdpi;
        this.dpis = dpis;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
       
            
            String nom = dpis.getjLabelnom().getText();
            String nomUsuel = dpis.getjLabelnom1().getText();
            String prenom = dpis.getjLabelprenom().getText();
            String ipp = dpis.getjLabelipp().getText();
            String adresse = dpis.getjLabeladresse().getText();
            String numsecu = dpis.getjLabelnumsecu().getText();
            String email = dpis.getjLabelemail().getText();
            String tel = dpis.getjLabeltelephone().getText();
            String dateNiassance = dpis.getjLabelannée().getText();
            String ServiceRespo = dpis.getSereviceRespo().getText();
            String ServiceGEo = dpis.getServiceGeo().getText();
            String chambre = dpis.getjLabelchamnre().getText();
            String sexe = dpis.getSexe().getText();
            
            mdpi.getNomDenaissance().setText(nom);
            mdpi.getNomUsuel().setText(nomUsuel);
            mdpi.getPrenom().setText(prenom);
            mdpi.getAdresse().setText(adresse);
            mdpi.getNumSS().setText(numsecu);
            mdpi.getEmail().setText(email);
            mdpi.getTel().setText(tel);
            mdpi.getDateDeNaissance().setText(dateNiassance);
            mdpi.getServicegeo().setActionCommand(ServiceRespo);
            mdpi.getServicegeo().setActionCommand(ServiceGEo);
            mdpi.getSexe().setActionCommand(sexe);
            mdpi.getChambre().setText(chambre);
            mdpi.getjLabel3().setText(ipp);
            
      
            
            jframe.PanelVisibleFalse();
            jframe.add(mdpi);
            mdpi.setVisible(true);
            jframe.revalidate();
            jframe.repaint();
       
    }

}
