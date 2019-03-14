/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.medicotech;

import interfaces.DetailsPrestation;
import interfaces.Fenetre;
import interfaces.PrestationFaite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author annel
 */
public class BoutonEnvoyerResultats implements ActionListener {
    PrestationFaite pf;
    DetailsPrestation dp;
    Fenetre fen;

    public BoutonEnvoyerResultats(PrestationFaite pf, DetailsPrestation dp, Fenetre fen) {
        this.pf = pf;
        this.dp = dp;
        this.fen = fen;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        pf.getNomMedecin().setText(dp.getNomMedecin().getText());
        pf.getNomPatient().setText(dp.getNomPatient().getText());
        pf.getPrenomPatient().setText(dp.getPrenomPatient().getText());
        pf.getIpp().setText(dp.getIPP().getText());
        
        
        
       fen.panelVisibleFalse();
        fen.add(pf);
        pf.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }
    
}
