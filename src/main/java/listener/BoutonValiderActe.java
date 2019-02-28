/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.AjouterActeInfirmier;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import nf.Dates;
import nf.sejour.Acte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author annel
 */
public class BoutonValiderActe implements ActionListener {
    BarreDuHaut bh;
    Fenetre fen;
    InfosMedicalesIDE im;
    AjouterActeInfirmier aai;

    public BoutonValiderActe(BarreDuHaut bh, InfosMedicalesIDE im, Fenetre jframe, AjouterActeInfirmier aai) {
        this.fen = jframe;
        this.im = im;
        this.bh = bh;
        this.aai = aai;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Acte a = new Acte(aai.getobservation().getText(), aai.gettype().getText(), bh.getId().getText(), aai.getIpp().getText(), new Dates(aai.getjour().getText(), aai.getmois().getText(), aai.getannee().getText()));
        try {
            a.AjouterActeSurBD(a);

            JOptionPane jop1 = new JOptionPane();

            jop1.showMessageDialog(null, "Patient correctement ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);

            fen.panelVisibleFalse();

            fen.add(im);
            im.setVisible(true);
            fen.revalidate();
            fen.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderActe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}