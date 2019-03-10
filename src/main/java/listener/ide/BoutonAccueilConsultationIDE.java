/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import bd.MethodeBD;
import interfaces.BarreDuHaut;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import interfaces.ConsultationIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.BoutonRetourDPIIDEVersConsulterDPIPHetIDE;

/**
 * @author Manon
 */
public class BoutonAccueilConsultationIDE implements ActionListener {

    ConsultationIDE ai;
    ConsulterDPIPHetIDE dpiphide;
    Fenetre jframe;
BarreDuHaut bh;

    public BoutonAccueilConsultationIDE(Fenetre jframe, ConsultationIDE ai, ConsulterDPIPHetIDE dpiphide, BarreDuHaut bh) {
        this.jframe = jframe;
        this.ai = ai;
        this.dpiphide = dpiphide;
        this.bh = bh;
    }

    public void actionPerformed(ActionEvent ae) {
        
          int nombre = 0;
        try {
            nombre = MethodeBD.compterTableauPrestationParService(bh.getService().getText());
        } catch (SQLException ex) {
            Logger.getLogger(BoutonRetourDPIIDEVersConsulterDPIPHetIDE.class.getName()).log(Level.SEVERE, null, ex);
        }
        String notification = dpiphide.getNotification().getText();
        int notif = Integer.parseInt(notification);
        int increment = nombre;
        String notificationFinale = Integer.toString(increment);
        dpiphide.getNotification().setText(notificationFinale);
        
        
        
        
        jframe.panelVisibleFalse();
        jframe.add(dpiphide);
        dpiphide.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
