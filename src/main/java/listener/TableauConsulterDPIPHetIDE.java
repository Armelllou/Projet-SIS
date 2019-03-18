/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import interfaces.DPIIDE;
import interfaces.DPIPH;
import nf.Sih;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.bd.ConnexionBD;

public class TableauConsulterDPIPHetIDE implements MouseListener {

    DPIPH imph;
    DPIIDE imide;
    ConsulterDPIPHetIDE cdpi;

    Fenetre fen;
    Sih sih;
    JTable table;
    ListenerConnexion conn;

    public TableauConsulterDPIPHetIDE(DPIPH imph, DPIIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
        this.imph = imph;
        this.imide = imide;
        this.fen = fen;
        this.sih = sih;
        this.table = table;
        this.conn = conn;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int NumLigne = table.getSelectedRow();

        if (conn.getState() == State.PH) {        

                        fen.panelVisibleFalse();
                        fen.add(imph);
                        imph.setVisible(true);
                        fen.revalidate();
                        fen.repaint();
                 }
            
        if(conn.getState() == State.IDE) {
                        
                        fen.panelVisibleFalse();
                        fen.add(imide);
                        imph.setVisible(true);
                        fen.revalidate();
                        fen.repaint();

                        }
                
                
            } 
            
            
            
          

       
        
            @Override
            public void mousePressed
            (MouseEvent e
            
            
            ) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
            public void mouseReleased
            (MouseEvent e
            
            
            ) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
            public void mouseEntered
            (MouseEvent e
            
            
            ) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
            public void mouseExited
            (MouseEvent e
            
            
        
    

) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
