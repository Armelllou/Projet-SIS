/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import interfaces.AccueilSecretaires;
import interfaces.BarreDuHaut;
import interfaces.ConsulterDPISecretaire;
import interfaces.CreationDPI;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author annel
 */
public class BoutonConsulterDPE implements ActionListener{
      
    AccueilSecretaires as;
    Fenetre fen;
    BarreDuHaut bh;
    ConsulterDPISecretaire cdpis;

    public BoutonConsulterDPE(AccueilSecretaires as,  ConsulterDPISecretaire cdpis, Fenetre jframe) {
        this.fen = jframe;
        this.cdpis = cdpis;
        this.as = as;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       fen.PanelVisibleFalse();
      
        fen.add(cdpis);
        cdpis.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }
}
