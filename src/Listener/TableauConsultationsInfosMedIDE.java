/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;
import NF.Sih;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.ConsultationIDE;
import interfaces.ConsultationPH;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import interfaces.InfosMedicalesPH;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class TableauConsultationsInfosMedIDE implements MouseListener{
    
    
    InfosMedicalesIDE imph;
    ConsultationIDE cph;
    Fenetre fen;
    Sih sih;
    JTable table;

    public TableauConsultationsInfosMedIDE(InfosMedicalesIDE imph, ConsultationIDE cph, Fenetre fen, Sih sih, JTable table) {
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
