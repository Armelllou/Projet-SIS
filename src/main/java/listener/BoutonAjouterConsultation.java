/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import interfaces.AjouterConsultation;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * @author Manon
 */
public class BoutonAjouterConsultation implements ActionListener {

    AjouterConsultation ac;
    InfosMedicalesPH im;
    Fenetre jframe;
    BarreDuHaut bh;

    public BoutonAjouterConsultation(Fenetre jframe, AjouterConsultation ac, InfosMedicalesPH im, BarreDuHaut bh) {
        this.jframe = jframe;
        this.ac = ac;
        this.im = im;
        this.bh = bh;
    }

    public void actionPerformed(ActionEvent ae) {
        
        
         
       ac.getNomMedecin().setText(bh.getNom().getText()) ;
       ac.getPrenomMedecin().setText(bh.getPrenom().getText()) ;
        Calendar date = Calendar.getInstance();
        ac.getAnnee().setText(Integer.toString(date.get(Calendar.YEAR)));
        ac.getDate().setText(Integer.toString(date.get(Calendar.MONTH)));
        ac.getJour().setText(Integer.toString(date.get(Calendar.DAY_OF_MONTH)));
        
        
        jframe.panelVisibleFalse();
        jframe.add(ac);
        ac.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
        
        
        
        
        
    }

}
