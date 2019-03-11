/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import bd.MethodeBD;
import interfaces.BarreDuHaut;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.DPIPH;
import interfaces.Fenetre;
import interfaces.TransfertService;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annel
 */
public class BoutonValiderTransfert implements ActionListener {

    TransfertService ts;
    DPIPH dpiph;
    Fenetre fen;
    ConsulterDPIPHetIDE consult;
    BarreDuHaut bh;

    public BoutonValiderTransfert(TransfertService ts, Fenetre fen,DPIPH dpiph, ConsulterDPIPHetIDE consult,BarreDuHaut bh) {
        this.ts = ts;
        this.dpiph = dpiph;
        this.fen = fen;
        this.consult=consult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ServiceResponsable = ts.getServiceGeographique().getSelectedItem().toString();
        String ServiceGeographique = ts.getServiceGeographique().getSelectedItem().toString();
        String lit = ts.getChambre().getText().toString();
        String IPP = dpiph.getjLabelipp().getText();
    
        try {
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement prep2 = conn.getConnexion().prepareStatement("UPDATE localisations SET ServiceResponsable= ?, ServiceGeographique = ?,lit= ? WHERE IPP= '"+IPP+"'");
            prep2.setString(1, ServiceResponsable);
            prep2.setString(2, ServiceGeographique);
            prep2.setString(3, lit);
            
            prep2.executeUpdate();

            
            
         
                
                
            fen.panelVisibleFalse();
            fen.add(consult);
            consult.setVisible(true);
            fen.revalidate();
            fen.repaint();
            
            consult.getjTable1().setFont(new Font("Calibri", 0, 18));
         consult.getjTable1().setModel(MethodeBD.listePatientJTableServicePH(bh.getService().getText()));

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderTransfert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
