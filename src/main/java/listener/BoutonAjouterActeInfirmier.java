/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.AjouterActeInfirmier;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonAjouterActeInfirmier implements ActionListener {

    AjouterActeInfirmier ai;
    InfosMedicalesIDE im;
    Fenetre jframe;
    Sih sih;
    BarreDuHaut bh;

    public BoutonAjouterActeInfirmier(Fenetre jframe, AjouterActeInfirmier ai, InfosMedicalesIDE im, Sih sih , BarreDuHaut bh) {
        this.jframe = jframe;
        this.ai = ai;
        this.im = im;
        this.sih = sih;
        this.bh=bh;
    }

    public void actionPerformed(ActionEvent ae) {

        String nom = im.getjLabelnom().getText();
        String prenom = im.getjLabelprenom().getText();
        String ipp = im.getjLabelipp().getText();
        
        String nomIDE = bh.getNom().getText();
        String prenomIDE = bh.getPrenom().getText();
        
        
       ai.getNomIDE().setText(nomIDE);
       ai.getPrenomIDE().setText(prenomIDE);
        
        
         ai.getNom().setText(nom);
        ai.getPrenom().setText(prenom);
        ai.getIpp().setText(ipp);

        
        
        jframe.panelVisibleFalse();
        jframe.add(ai);
        ai.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
