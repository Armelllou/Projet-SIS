/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.MethodeBD;
import interfaces.BarreDuHaut;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import interfaces.Resultat;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nf.sejour.Resultats;

/**
 *
 * @author annel
 */
public class BoutonAccederAuxResultats implements ActionListener {
    Resultat r;
    ConsulterDPIPHetIDE cdpiphetide;
    BarreDuHaut bh;
    Fenetre jframe;

    public BoutonAccederAuxResultats(Resultat r, ConsulterDPIPHetIDE cdpiphetide, BarreDuHaut bh, Fenetre jframe) {
        this.r = r;
        this.cdpiphetide = cdpiphetide;
        this.bh = bh;
        this.jframe=jframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
      
        r.getTablePrestation().setFont(new Font("Calibri", 0, 18));
        r.getTablePrestation().setModel(new MethodeBD().listeResultats(bh.getService().getText()));
        
        cdpiphetide.getNotification().setText("0");
        jframe.panelVisibleFalse();
        jframe.add(r);
        r.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
        
        
       }
    
    
}
