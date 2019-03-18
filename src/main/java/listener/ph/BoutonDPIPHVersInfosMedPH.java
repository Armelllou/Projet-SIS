/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.DPIPH;
import interfaces.InfosMedicalesPH;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;

/**
 * @author Manon
 */
public class BoutonDPIPHVersInfosMedPH implements ActionListener {
    DPIPH dpi;
    InfosMedicalesPH im;
    Fenetre fen;

    public BoutonDPIPHVersInfosMedPH(DPIPH dpi, InfosMedicalesPH im, Fenetre fen) {
        this.dpi = dpi;
        this.im = im;
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         String nom =  dpi.getjLabelnom().getText();
      String prenom =  dpi.getjLabelprenom().getText();
       String ipp = dpi.getjLabelipp().getText();
        
        
        im.getjLabelnom().setText(nom);
        im.getjLabelprenom().setText(prenom);
        im.getjLabelipp().setText(ipp);

       
        im.getjTable3().setFont(new Font("Calibri", 0, 18));
        im.getjTable3().setModel(MethodeBD.listeConsultationJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD


        im.getjTable2().setFont(new Font("Calibri", 0, 18));
        im.getjTable2().setModel(MethodeBD.listeActeJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD


        im.getjTable1().setFont(new Font("Calibri", 0, 18));
        im.getjTable1().setModel(MethodeBD.listePrescriptionJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD
        
            RafraichitLesPanels rf = new RafraichitLesPanels(fen,im);
    }
}
