/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import bd.MethodeBD;
import interfaces.AjouterPrescription;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import java.awt.Font;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import listener.commun.RafraichitLesPanels;
import nf.Dates;
import nf.sejour.Prescription;

/**
 * @author Manon
 */
public class BoutonAjouterPrescription implements ActionListener {

    AjouterPrescription ac;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;
    BarreDuHaut bh;

    public BoutonAjouterPrescription(Fenetre jframe, AjouterPrescription ac, InfosMedicalesPH im, Sih sih, BarreDuHaut bh) {
        this.jframe = jframe;
        this.ac = ac;
        this.im = im;
        this.sih = sih;
        this.bh = bh;
    }

    public void actionPerformed(ActionEvent ae) {
        String ipp = im.getjLabelipp().getText();
        String NomMedecin = bh.getNom().getText();
        String PrenomMedecin = bh.getPrenom().getText();

        Calendar date = Calendar.getInstance();
        ac.getAnnee().setText(Integer.toString(date.get(Calendar.YEAR)));
        ac.getDate().setText(Integer.toString(date.get(Calendar.MONTH + 1)));
        ac.getJour().setText(Integer.toString(date.get(Calendar.DAY_OF_MONTH)));

        ac.getIPP().setText(ipp);
        ac.getNomMedecin().setText(NomMedecin);
        ac.getPrenomMedecin().setText(PrenomMedecin);

           RafraichitLesPanels rf = new RafraichitLesPanels(jframe,ac);

    }

}
