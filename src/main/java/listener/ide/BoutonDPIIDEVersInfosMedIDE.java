/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.DPIIDE;
import interfaces.InfosMedicalesIDE;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;

/**
 * @author Manon
 */
public class BoutonDPIIDEVersInfosMedIDE implements ActionListener {
    DPIIDE dpi;
    InfosMedicalesIDE im;
    Fenetre fen;
    String ipp;

    public BoutonDPIIDEVersInfosMedIDE(DPIIDE dpi, InfosMedicalesIDE im, Fenetre fen) {
        this.dpi = dpi;
        this.im = im;
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      

        
      String nom =  dpi.getjLabelnom().getText();
      String prenom =  dpi.getjLabelprenom().getText();
       String s = dpi.getjLabelipp().getText();
        
        
        im.getjLabelnom().setText(nom);
        im.getjLabelprenom().setText(prenom);
        im.getjLabelipp().setText(s);

       
        im.getjTable3().setFont(new Font("Calibri", 0, 18));
        im.getjTable3().setModel(MethodeBD.listeConsultationJTableServiceIde(s)); // rempli la JTable avec les patients de la BD


        im.getjTable2().setFont(new Font("Calibri", 0, 18));
        im.getjTable2().setModel(MethodeBD.listeActeJTableServiceIde(s)); // rempli la JTable avec les patients de la BD


        im.getjTable1().setFont(new Font("Calibri", 0, 18));
        im.getjTable1().setModel(MethodeBD.listePrescriptionJTableServiceIde(s)); // rempli la JTable avec les patients de la BD
        
        
     RafraichitLesPanels rf = new RafraichitLesPanels(fen,im);
    }
}
