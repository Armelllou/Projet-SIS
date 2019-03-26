/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.commun;

import bd.MethodeBD;
import interfaces.BarreDuHaut;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.DPIIDE;
import interfaces.Fenetre;
import interfaces.DPIPH;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoutonRetourVersConsulterDPIPHetIDE implements ActionListener {

    DPIPH dpis;
    ConsulterDPIPHetIDE cdpis;
    Fenetre jframe;
    BarreDuHaut bh;

    public BoutonRetourVersConsulterDPIPHetIDE(Fenetre jframe, ConsulterDPIPHetIDE cdpis, DPIPH dpis,DPIIDE dpiide, BarreDuHaut bh) {
        this.jframe = jframe;
        this.cdpis = cdpis;
        this.dpis = dpis;
        this.bh = bh;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        int nombre = 0;
        try {
            nombre = MethodeBD.compterTableauPrestationParService(bh.getService().getText());
        } catch (SQLException ex) {
            Logger.getLogger(BoutonRetourVersConsulterDPIPHetIDE.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        }


        String notification = cdpis.getNotification().getText();
        int notif = Integer.parseInt(notification);
        int increment = nombre;
        String notificationFinale = Integer.toString(increment);
        cdpis.getNotification().setText(notificationFinale);
        
        cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
        cdpis.getjTable1().setModel(MethodeBD.listePatientJTableServicePH(bh.getService().getText()));
        
        cdpis.getjTextField1().setText("");
        jframe.panelVisibleFalse();
        jframe.add(cdpis);
        cdpis.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
        
        
    }

}
