/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nf.personnel.Infirmier;
import nf.personnel.Medecin;
import nf.personnel.MedicoTechnique;
import nf.personnel.SecretaireMedical;
import nf.personnel.Technicien;

/**
 *
 * @author annel
 */
public class BoutonSupprimerPersonnel implements ActionListener {
    
    ListePersonnel lp;
    ModifierPersonnel mp;
    Fenetre fen;
    
    public BoutonSupprimerPersonnel(ListePersonnel lp, ModifierPersonnel mp, Fenetre fen) {
        this.lp = lp;
        this.mp = mp;
        this.fen = fen;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String id = mp.getId().getText();
        int ids = Integer.parseInt(id);
        String Personnel = mp.getType().getSelectedItem().toString();
        
        int reponse = JOptionPane.showConfirmDialog(fen,
                "Voulez-vous vraiment supprimer ce personnel ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (reponse == JOptionPane.YES_OPTION) {
            try {
                if (Personnel == "ide") {
                    
                    MethodeBD.SupprimerSurBdIDE(ids);
                    lp.getTableIDE().setFont(new Font("Calibri", 0, 18));
                    lp.getTableIDE().setModel(new MethodeBD().listeIDE());
                }
                if (Personnel == "praticienhospitaliers") {
                    
                    MethodeBD.SupprimerSurBdPH(ids);
                    lp.getTablePH().setFont(new Font("Calibri", 0, 18));
                    lp.getTablePH().setModel(new MethodeBD().listePH());
                }
                if (Personnel == "Technicien") {
                    
                    MethodeBD.SupprimerSurBdTechnicien(ids);
                }
                if (Personnel == "medicotechniques") {
                    MethodeBD.SupprimerSurBdMedichoTech(ids);
                    lp.getTableMT().setFont(new Font("Calibri", 0, 18));
                    lp.getTableMT().setModel(MethodeBD.listeMT());
                    
                }
                if (Personnel == "SecretaireAdministrative") {
                    
                    MethodeBD.SupprimerSurBdSecretaire(ids);
                    lp.getTableSecretaire().setFont(new Font("Calibri", 0, 18));
                    lp.getTableSecretaire().setModel(new MethodeBD().listeSA());
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(BoutonValiderPersonnel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            fen.panelVisibleFalse();
            fen.add(lp);
            lp.setVisible(true);
            fen.revalidate();
            fen.repaint();
            
            
        } else {
            fen.panelVisibleFalse();
            fen.add(mp);
            mp.setVisible(true);
            fen.revalidate();
            fen.repaint();
            
        }
    }
}
