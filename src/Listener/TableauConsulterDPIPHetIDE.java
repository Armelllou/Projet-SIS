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
import interfaces.DPIIDE;
import interfaces.DPIPH;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import interfaces.InfosMedicalesPH;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author stifinekawtar
 */

public class TableauConsulterDPIPHetIDE implements MouseListener {

    InfosMedicalesPH imph;
    InfosMedicalesIDE imide;
    ConsulterDPIPHetIDE cdpi;
    DPIIDE cide;
    DPIPH cph;
    Fenetre fen;
    Sih sih;
    JTable table;
    ListenerConnexion conn;


    public TableauConsulterDPIPHetIDE(InfosMedicalesPH imph, InfosMedicalesIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
        this.imph = imph;
        this.imide = imide;
        this.fen = fen;
        this.sih = sih;
        this.table = table;
        this.conn = conn;

        
    }

  

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            int NumLigne;
            NumLigne = table.getSelectedRow();

            if (conn.ConnexionPH() == true) {
                fen.PanelVisibleFalse();
                fen.add(imph);
                imph.setVisible(true);
                fen.revalidate();
                fen.repaint();
            } else {
                if (conn.ConnexionIde() == true) {
                    fen.PanelVisibleFalse();
                    fen.add(imide);
                    imide.setVisible(true);
                    fen.revalidate();
                    fen.repaint();

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterDPIPHetIDE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
