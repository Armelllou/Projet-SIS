/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Acte;
import NF.Adresse;
import NF.Dates;
import NF.Patient;
import interfaces.AccueilSecretaires;
import interfaces.AjouterActeInfirmier;
import interfaces.BarreDuHaut;
import interfaces.ConsulterDPISecretaire;
import interfaces.CreationDPI;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
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
public class BoutonValiderActe implements ActionListener {
    BarreDuHaut bh;
    Fenetre fen;
    InfosMedicalesPH im;
    AjouterActeInfirmier aai;

    public BoutonValiderActe(BarreDuHaut bh,InfosMedicalesPH im, Fenetre jframe, AjouterActeInfirmier aai) {
        this.fen = jframe;
        this.im = im;
        this.bh = bh;
        this.aai=aai;
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Acte a = new Acte(aai.getobservation().getText(),aai.gettype().getText(),bh.getId().getText(),aai.getIpp().getText(),new Dates(aai.getjour().getText(),aai.getmois().getText(),aai.getannee().getText()));
        try {
            a.AjouterActeSurBD(a);
            
              JOptionPane jop1 = new JOptionPane();
          
               jop1.showMessageDialog(null, "Patient correctement ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
          
            fen.PanelVisibleFalse();
            
            fen.add(im);
            im.setVisible(true);
            fen.revalidate();
            fen.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderActe.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    }