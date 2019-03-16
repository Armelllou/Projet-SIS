/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.technicien;

import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import listener.commun.RafraichitLesPanels;

/**
 *
 * @author annel
 */
public class BouttonAnnulerModifPersonnel implements ActionListener {
 Fenetre fen;
    ListePersonnel lp;
    ModifierPersonnel mp;
    JTable table;

    public BouttonAnnulerModifPersonnel(Fenetre fen, ListePersonnel lp, ModifierPersonnel mp) {
        this.fen = fen;
        this.lp = lp;
        this.mp = mp;
     
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RafraichitLesPanels rf = new RafraichitLesPanels(fen,lp); 
    }
    
}
