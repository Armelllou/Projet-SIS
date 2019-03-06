/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

/**
 *
 * @author annel
 */
public class TableauPhP implements MouseListener {
     Fenetre fen;
    ListePersonnel lp;
    ModifierPersonnel mp;
    JTable table;

    public TableauPhP(Fenetre fen, ListePersonnel lp, ModifierPersonnel mp, JTable table) {
        this.fen = fen;
        this.lp = lp;
        this.mp = mp;
        this.table = table;
    }

   

    @Override
    public void mouseClicked(MouseEvent e) {
         int NumLigne = table.getSelectedRow();
        fen.panelVisibleFalse();
        fen.add(mp);
        mp.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
            }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
}
