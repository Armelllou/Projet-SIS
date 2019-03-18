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


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import listener.commun.ListenerConnexion;
import listener.commun.State;



public class TableauConsulterDPIPHetIDE implements MouseListener {

    DPIPH imph;
    DPIIDE imide;
    ConsulterDPIPHetIDE cdpi;

    Fenetre fen;
   
    JTable table;
    ListenerConnexion conn;

    public TableauConsulterDPIPHetIDE(DPIPH imph, DPIIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
        this.imph = imph;
        this.imide = imide;
        this.fen = fen;
        
        this.table = table;
        this.conn = conn;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int NumLigne = table.getSelectedRow();

        if (ListenerConnexion.getState() == State.PH) {        

                        fen.panelVisibleFalse();
                        fen.add(imph);
                        imph.setVisible(true);
                        fen.revalidate();
                        fen.repaint();
                 }
            
        if(ListenerConnexion.getState() == State.IDE) {
                        
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
