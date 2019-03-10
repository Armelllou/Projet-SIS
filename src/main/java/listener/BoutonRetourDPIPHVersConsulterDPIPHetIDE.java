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
import interfaces.DPIPH;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manon
 */
public class BoutonRetourDPIPHVersConsulterDPIPHetIDE implements ActionListener {

    DPIPH dpis;
    ConsulterDPIPHetIDE cdpis;
    Fenetre jframe;
   BarreDuHaut bh;

    public BoutonRetourDPIPHVersConsulterDPIPHetIDE(Fenetre jframe, ConsulterDPIPHetIDE cdpis, DPIPH dpis, BarreDuHaut bh) {
        this.jframe = jframe;
        this.cdpis = cdpis;
        this.dpis = dpis;
        this.bh = bh;
    }

    public void actionPerformed(ActionEvent ae) {
        
        
         int nombre = 0;
        try {
            nombre = MethodeBD.compterTableauPrestationParService(bh.getService().getText());
        } catch (SQLException ex) {
            Logger.getLogger(BoutonRetourDPIIDEVersConsulterDPIPHetIDE.class.getName()).log(Level.SEVERE, null, ex);
        }
        String notification = cdpis.getNotification().getText();
        int notif = Integer.parseInt(notification);
        int increment = nombre;
        String notificationFinale = Integer.toString(increment);
        cdpis.getNotification().setText(notificationFinale);
        jframe.panelVisibleFalse();
        jframe.add(cdpis);
        cdpis.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
