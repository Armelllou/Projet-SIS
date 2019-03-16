/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import bd.MethodeBD;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import interfaces.InfosMedicalesPH;
import interfaces.ResultatParPatient;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.commun.ListenerConnexion;
import listener.commun.RafraichitLesPanels;

/**
 *
 * @author annel
 */
public class BoutonResultatsPh implements ActionListener {

    ResultatParPatient rp;
    Fenetre jframe;
    BarreDuHaut bh;
    InfosMedicalesIDE infoside;
    InfosMedicalesPH infosph;
    ListenerConnexion l;

    public BoutonResultatsPh(ResultatParPatient rp, Fenetre jframe, BarreDuHaut bh, InfosMedicalesIDE infoside, InfosMedicalesPH infosph, ListenerConnexion l ) {
        this.rp = rp;
        this.jframe = jframe;
        this.bh = bh;
        this.rp = rp;
        this.l = l;
        this.infoside=infoside;
        this.infosph=infosph;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (l.ConnexionPH() == true) {
                String IPP = infosph.getjLabelipp().getText();
                rp.getTablePrestation().setFont(new Font("Calibri", 0, 18));
                rp.getTablePrestation().setModel(MethodeBD.listeResultatsParPatients(IPP));
            } 
          
        } catch (SQLException ex) {
            Logger.getLogger(BoutonResultatsPh.class.getName()).log(Level.SEVERE, null, ex);
        }


           RafraichitLesPanels rf = new RafraichitLesPanels(jframe,rp);
    }
}
