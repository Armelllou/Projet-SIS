/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.commun;

import interfaces.Fenetre;
import javax.swing.JPanel;

/**
 *
 * @author annel
 */
public class RafraichitLesPanels {

    Fenetre fen;
    JPanel jp;

    public RafraichitLesPanels(Fenetre fen, JPanel jp) {
        
        fen.panelVisibleFalse();
        fen.add(jp);
        jp.setVisible(true);
        jp.revalidate();
        fen.repaint();

    }

}
