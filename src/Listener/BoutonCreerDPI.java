/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;


import interfaces.AccueilSecretaires;
import interfaces.BarreDuHaut;
import interfaces.CreationDPI;
import interfaces.Fenetre;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author annel
 */
public class BoutonCreerDPI implements ActionListener {

    CreationDPI dpi;
    AccueilSecretaires as;
    Fenetre fen;
    BarreDuHaut bh;

    public BoutonCreerDPI(AccueilSecretaires as, CreationDPI dpi, Fenetre jframe) {
        this.fen = jframe;
        this.dpi = dpi;
        this.as = as;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       fen.PanelVisibleFalse();
      
        fen.add(dpi);
        dpi.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }

}
