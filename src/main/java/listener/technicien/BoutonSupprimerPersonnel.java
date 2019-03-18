/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.technicien;


import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import listener.commun.RafraichitLesPanels;

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
        String personnel = mp.getType().getSelectedItem().toString();
        
        int reponse = JOptionPane.showConfirmDialog(fen,
                "Voulez-vous vraiment supprimer ce personnel ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (reponse == JOptionPane.YES_OPTION) {
            try {
                if ("ide".equals(personnel)) {
                    
                    MethodeBD.SupprimerSurBdIDE(ids);
                    lp.getTableIDE().setFont(new Font("Calibri", 0, 18));
                    lp.getTableIDE().setModel(MethodeBD.listeIDE());
                }
                if ("praticienhospitaliers".equals(personnel)) {
                    
                    MethodeBD.SupprimerSurBdPH(ids);
                    lp.getTablePH().setFont(new Font("Calibri", 0, 18));
                    lp.getTablePH().setModel(MethodeBD.listePH());
                }
                if ("Technicien".equals(personnel)) {
                    
                    MethodeBD.SupprimerSurBdTechnicien(ids);
                }
                if ("medicotechniques".equals(personnel)) {
                    MethodeBD.SupprimerSurBdMedichoTech(ids);
                    lp.getTableMT().setFont(new Font("Calibri", 0, 18));
                    lp.getTableMT().setModel(MethodeBD.listeMT());
                    
                }
                if ("SecretaireAdministrative".equals(personnel)) {
                    
                    MethodeBD.SupprimerSurBdSecretaire(ids);
                    lp.getTableSecretaire().setFont(new Font("Calibri", 0, 18));
                    lp.getTableSecretaire().setModel(MethodeBD.listeSA());
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(BoutonValiderPersonnel.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
            }
            
               RafraichitLesPanels rf = new RafraichitLesPanels(fen,lp);
            
            
        } else {
                RafraichitLesPanels rf = new RafraichitLesPanels(fen,mp);
        }
    }
}
