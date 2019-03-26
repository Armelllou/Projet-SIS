/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import interfaces.AjouterPrescription;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import listener.commun.RafraichitLesPanels;

public class BoutonAjouterPrescriptionDansConsult implements ActionListener {

    AjouterPrescription ac;
    InfosMedicalesPH im;
    Fenetre jframe;
   
    BarreDuHaut bh;

    public BoutonAjouterPrescriptionDansConsult(Fenetre jframe, AjouterPrescription ac, InfosMedicalesPH im,  BarreDuHaut bh) {
        this.jframe = jframe;
        this.ac = ac;
        this.im = im;
     
        this.bh = bh;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String ipp = im.getjLabelipp().getText();
        String NomMedecin = bh.getNom().getText();
        String PrenomMedecin = bh.getPrenom().getText();

        Calendar date = Calendar.getInstance();
        ac.getAnnee().setText(Integer.toString(date.get(Calendar.YEAR)));
        ac.getDate().setText(Integer.toString(date.get(Calendar.MONTH)));
        ac.getJour().setText(Integer.toString(date.get(Calendar.DAY_OF_MONTH)));

        ac.getIPP().setText(ipp);
        ac.getNomMedecin().setText(NomMedecin);
        ac.getPrenomMedecin().setText(PrenomMedecin);

           RafraichitLesPanels rf = new RafraichitLesPanels(jframe,ac);

    }
}
