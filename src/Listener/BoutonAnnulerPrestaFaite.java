/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import interfaces.Fenetre;
import interfaces.PrestationFaite;
import interfaces.Prestations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAnnulerPrestaFaite implements ActionListener {
    
    PrestationFaite pf;
    Prestations p;
    Fenetre fen;
    
    public BoutonAnnulerPrestaFaite(PrestationFaite pf, Prestations p, Fenetre fen){
        this.pf=pf;
        this.p=p;
        this.fen=fen;
    }
    
    public void actionPerformed(ActionEvent ae) {
        fen.PanelVisibleFalse();
        fen.add(p);
        p.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }
}