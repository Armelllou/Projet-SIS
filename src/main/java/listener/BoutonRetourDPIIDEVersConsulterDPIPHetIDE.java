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
import interfaces.DPIIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manon
 */
public class BoutonRetourDPIIDEVersConsulterDPIPHetIDE implements ActionListener {

    DPIIDE dpis;
    ConsulterDPIPHetIDE cdpis;
    Fenetre jframe;
    Sih sih;
    BarreDuHaut bh;

    public BoutonRetourDPIIDEVersConsulterDPIPHetIDE(Fenetre jframe, ConsulterDPIPHetIDE cdpis, DPIIDE dpis, BarreDuHaut bh) {
        this.jframe = jframe;
        this.cdpis = cdpis;
        this.dpis = dpis;
        this.sih = sih;
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
