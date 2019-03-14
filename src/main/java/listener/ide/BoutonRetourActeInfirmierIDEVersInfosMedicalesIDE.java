/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.Fenetre;
import interfaces.ActeInfirmier;
import interfaces.InfosMedicalesIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.ListenerConnexion;

/**
 * @author Manon
 */
public class BoutonRetourActeInfirmierIDEVersInfosMedicalesIDE implements ActionListener {

    ActeInfirmier ai;
    InfosMedicalesIDE im;
    Fenetre jframe;
    Sih sih;
    ListenerConnexion l;

    public BoutonRetourActeInfirmierIDEVersInfosMedicalesIDE(Fenetre jframe, InfosMedicalesIDE im, ActeInfirmier ai, Sih sih,ListenerConnexion l) {
        this.jframe = jframe;
        this.ai = ai;
        this.im = im;
        this.sih = sih;
        this.l=l;
    }

    public void actionPerformed(ActionEvent ae) {
        
       
                jframe.panelVisibleFalse();
                jframe.add(im);
                im.setVisible(true);
                jframe.revalidate();
                jframe.repaint();
         

    }}
