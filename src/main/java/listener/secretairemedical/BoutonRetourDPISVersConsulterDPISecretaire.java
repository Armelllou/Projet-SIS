/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.secretairemedical;


import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ConsulterDPISecretaire;
import interfaces.DPISecretaire;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;

public class BoutonRetourDPISVersConsulterDPISecretaire implements ActionListener {

    DPISecretaire dpis;
    ConsulterDPISecretaire cdpis;
    Fenetre jframe;
   

    public BoutonRetourDPISVersConsulterDPISecretaire(Fenetre jframe, ConsulterDPISecretaire cdpis, DPISecretaire dpis) {
        this.jframe = jframe;
        this.cdpis = cdpis;
        this.dpis = dpis;
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {


            MethodeBD.PatientSecretaire(cdpis.getjTable1());
            cdpis.getjTextField1().setText("");


           RafraichitLesPanels rf = new RafraichitLesPanels(jframe,cdpis);
    }

}
