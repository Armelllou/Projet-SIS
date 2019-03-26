/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.AjouterActeInfirmier;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import listener.commun.RafraichitLesPanels;

public class BoutonAjouterActeInfirmier implements ActionListener {

    AjouterActeInfirmier ai;
    InfosMedicalesIDE im;
    Fenetre jframe;
  
    BarreDuHaut bh;

    public BoutonAjouterActeInfirmier(Fenetre jframe, AjouterActeInfirmier ai, InfosMedicalesIDE im, BarreDuHaut bh) {
        this.jframe = jframe;
        this.ai = ai;
        this.im = im;
        
        this.bh=bh;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String nom = im.getjLabelnom().getText();
        String prenom = im.getjLabelprenom().getText();
        String ipp = im.getjLabelipp().getText();
        
        Calendar date = Calendar.getInstance();
        ai.getannee().setText(Integer.toString(date.get(Calendar.YEAR)));
        ai.getmois().setText(Integer.toString(date.get(Calendar.MONTH+1)));
        ai.getjour().setText(Integer.toString(date.get(Calendar.DAY_OF_MONTH)));
        
        String nomIDE = bh.getNom().getText();
        String prenomIDE = bh.getPrenom().getText();
        
        
       ai.getNomIDE().setText(nomIDE);
       ai.getPrenomIDE().setText(prenomIDE);
        
        
         ai.getNom().setText(nom);
        ai.getPrenom().setText(prenom);
        ai.getIpp().setText(ipp);

        
        
          RafraichitLesPanels rf = new RafraichitLesPanels(jframe,ai);
    }

}
