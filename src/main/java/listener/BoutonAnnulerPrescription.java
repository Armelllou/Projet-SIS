/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.AjouterPrescription;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import interfaces.PrescriptionPH;
import interfaces.PrestationFaite;
import interfaces.Prestations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author annel
 */
public class BoutonAnnulerPrescription implements ActionListener {
   

    PrescriptionPH ap;
  InfosMedicalesPH imph;
    Fenetre fen;

    public BoutonAnnulerPrescription(PrescriptionPH ap, InfosMedicalesPH imph, Fenetre fen) {
        this.ap = ap;
        this.imph = imph;
        this.fen = fen;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        fen.panelVisibleFalse();
        fen.add(imph);
        imph.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }

}
