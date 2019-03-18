/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import interfaces.AjouterPrestation;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;

/**
 * @author Manon
 */
public class BoutonAjouterPrestation implements ActionListener {

    AjouterPrestation ac;
    InfosMedicalesPH im;
    Fenetre jframe;
  BarreDuHaut bh;

    public BoutonAjouterPrestation(Fenetre jframe, AjouterPrestation ac, InfosMedicalesPH im, BarreDuHaut bh) {
        this.jframe = jframe;
        this.ac = ac;
        this.im = im;
        this.bh = bh;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      String Service =  bh.getService().getText();
        ac.getServiceDemandeur().setSelectedItem(Service);
        ac.getServiceDemandeur().setEnabled(false);
        
          RafraichitLesPanels rf = new RafraichitLesPanels(jframe,ac);
    }

}
