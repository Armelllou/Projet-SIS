/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;
import main.java.nf.Sih;
import main.java.interfaces.Fenetre;
import main.java.interfaces.ide.InfosMedicalesIDE;
import main.java.interfaces.ide.PrescriptionIDE;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
/**
 *
 * @author stifinekawtar
 */

public class TableauPrescriptionsInfosMedIDE implements MouseListener{
    
    
    InfosMedicalesIDE imph;
    PrescriptionIDE cph;
    Fenetre fen;
    Sih sih;
    JTable table;

    public TableauPrescriptionsInfosMedIDE(InfosMedicalesIDE imph, PrescriptionIDE cph, Fenetre fen, Sih sih, JTable table) {
        this.imph=imph;
        this.cph=cph;
        this.fen = fen;
        this.sih = sih;
        this.table = table;  
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
             int NumLigne;
        NumLigne = table.getSelectedRow();
        
        fen.PanelVisibleFalse();
                fen.add(cph);
                cph.setVisible(true);
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
