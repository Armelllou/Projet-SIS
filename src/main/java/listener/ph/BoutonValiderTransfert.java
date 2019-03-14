/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

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
import javax.swing.JOptionPane;
import listener.secretairemedical.BoutonValiderModificationDPI;

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
  

    public BoutonValiderTransfert(TransfertService ts, Fenetre fen,DPIPH dpiph, ConsulterDPIPHetIDE consult,BarreDuHaut bh ){
        this.ts = ts;
        this.dpiph = dpiph;
        this.fen = fen;
        this.consult=consult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
       
    
         try {
          
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement prep = conn.getConnexion().prepareStatement("UPDATE localisations SET ServiceResponsable= ?, ServiceGeographique= ?, lit=? WHERE ipp = ?");
            prep.setString(1, ts.getServiceGeographique().getSelectedItem().toString());
            prep.setString(2, ts.getServiceResponsable().getSelectedItem().toString());
            prep.setString(3, ts.getChambre().getText().toString());
            prep.setString(4, ts.getjLabelipp().getText());
            prep.executeUpdate();
            
            
 
            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Informations correctement modifiées", "Information", JOptionPane.INFORMATION_MESSAGE);
            
    
           dpiph.getServiceGeo().setText(ts.getServiceGeographique().getSelectedItem().toString());
           dpiph.getServiceRespo().setText( ts.getServiceResponsable().getSelectedItem().toString());
            
            
            
            fen.panelVisibleFalse();
            fen.add(dpiph);
            dpiph.setVisible(true);
            fen.revalidate();
            fen.repaint();
            
            
        
//         consult.getjTable1().setFont(new Font("Calibri", 0, 18));
//         consult.getjTable1().setModel(MethodeBD.listePatientJTableServicePH(bh.getService().getText()));

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderModificationDPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
         
    }
}
