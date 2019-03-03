/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import bd.MethodeBD;
import interfaces.AjouterConsultation;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nf.sejour.Consultation;
import nf.Dates;

/**
 *
 * @author annel
 */
public class BoutonValiderConsultation implements ActionListener {
AjouterConsultation ac;
    InfosMedicalesPH im;
    Fenetre fen;
    BarreDuHaut bh;

    public BoutonValiderConsultation(AjouterConsultation ac, InfosMedicalesPH im, Fenetre fen, BarreDuHaut bh) {
        this.ac = ac;
        this.im = im;
        this.fen = fen;
        this.bh = bh;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
   
     
    try {
        String ipp = im.getjLabelipp().getText();
        String NomMedecin = bh.getNom().getText();
        String PrenomMedecin = bh.getPrenom().getText();
        
        
        ac.getNomMedecin().setText(NomMedecin);
        ac.getPrenomMedecin().setText(PrenomMedecin);
        
        String observation = ac.getCompteRendu().getText();
        String idMedecin = bh.getId().getText();
        
        Dates dates = new Dates(ac.getDate().getText(), ac.getJour().getText(), ac.getAnnee().getText());
        
        Consultation p = new Consultation(observation,NomMedecin, ipp, dates);
        
        p.AjouterConsultationSurBD(p);
        
        im.getjTable3().setFont(new Font("Calibri", 0, 18));
        im.getjTable3().setModel(MethodeBD.listeConsultationJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD
        
        JOptionPane jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Consultation correctement ajoutée", "Information", JOptionPane.INFORMATION_MESSAGE);
        
        
        
        fen.panelVisibleFalse();
        fen.add(im);
        im.setVisible(true);
        fen.revalidate();
        fen.repaint();
        
        
    } catch (SQLException ex) {
        Logger.getLogger(BoutonValiderConsultation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
}
