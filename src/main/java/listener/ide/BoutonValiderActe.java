/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import bd.MethodeBD;
import interfaces.AjouterActeInfirmier;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import java.awt.Font;
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
        Acte a = new Acte(aai.getObservation().getText(), aai.getType().getText(), bh.getId().getText(), aai.getIpp().getText());
//   
        try {
            a.AjouterActeSurBD(a);

            JOptionPane jop1 = new JOptionPane();

            jop1.showMessageDialog(null, "Acte correctement ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
            MethodeBD mb = new MethodeBD();
            String ipp = aai.getIpp().getText();
            im.getjTable2().setFont(new Font("Calibri", 0, 18));
            im.getjTable2().setModel(MethodeBD.listeActeJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD
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
