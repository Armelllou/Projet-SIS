/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import interfaces.DPIPH;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;

/**
 *
 * @author annel
 */
public class BoutonRetourPHVersDPIPH implements ActionListener {

    DPIPH dpiph;
    Fenetre fen;

    public BoutonRetourPHVersDPIPH(DPIPH dpiph, Fenetre fen) {
        this.dpiph = dpiph;
        this.fen = fen;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            RafraichitLesPanels rf = new RafraichitLesPanels(fen,dpiph);
        
    }

}
