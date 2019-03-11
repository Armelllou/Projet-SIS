/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

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

/**
 *
 * @author annel
 */
public class BoutonResultatsIde implements ActionListener {

    ResultatParPatient rp;
    Fenetre jframe;
    BarreDuHaut bh;
    InfosMedicalesIDE infoside;
    InfosMedicalesPH infosph;
    ListenerConnexion l;

    public BoutonResultatsIde(ResultatParPatient rp, Fenetre jframe, BarreDuHaut bh, InfosMedicalesIDE infoside, InfosMedicalesPH infosph, ListenerConnexion l ) {
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
            if (l.ConnexionIde() == true) {
                rp.getTablePrestation().setFont(new Font("Calibri", 0, 18));
            }
            rp.getTablePrestation().setModel(new MethodeBD().listeResultatsParPatients(infoside.getjLabelipp().getText()));
        } catch (SQLException ex) {
            Logger.getLogger(BoutonResultatsIde.class.getName()).log(Level.SEVERE, null, ex);
        }

        jframe.panelVisibleFalse();
        jframe.add(rp);
        rp.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
}
