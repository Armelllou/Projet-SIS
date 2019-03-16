/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.technicien;

import interfaces.BarreDuHaut;
import interfaces.CreationPersonnel;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;

/**
 *
 * @author annel
 */
public class BoutonAjouterDuPersonnel implements ActionListener {
    ListePersonnel lp;
    CreationPersonnel cp;
    Fenetre jframe;
  
    BarreDuHaut bh;

    public BoutonAjouterDuPersonnel(Fenetre jframe, ListePersonnel lp, CreationPersonnel cp,  BarreDuHaut bh) {
        this.jframe = jframe;
        this.cp = cp;
        this.lp = lp;
       
        this.bh=bh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           RafraichitLesPanels rf = new RafraichitLesPanels(jframe,cp);
    }
    
    
    
}
