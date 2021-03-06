/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.secretairemedical;

import interfaces.Fenetre;
import interfaces.ModificationDPI;
import interfaces.DPISecretaire;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;


public class BoutonModifierDPI implements ActionListener {

    DPISecretaire dpis;
    ModificationDPI mdpi;
    Fenetre jframe;
  

    public BoutonModifierDPI(Fenetre jframe, DPISecretaire dpis, ModificationDPI mdpi) {
        this.jframe = jframe;
        this.mdpi = mdpi;
        this.dpis = dpis;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String nom = dpis.getjLabelnom().getText();
        String nomUsuel = dpis.getjLabelnom1().getText();
        String prenom = dpis.getjLabelprenom().getText();
        String ipp = dpis.getjLabelipp().getText();
        String adresse = dpis.getjLabeladresse().getText();
        
        String numsecu = dpis.getjLabelnumsecu().getText();
        
        
        String email = dpis.getjLabelemail().getText();
        String tel = dpis.getjLabeltelephone().getText();
        String dateNiassance = dpis.getjLabelannée().getText();
        String serviceRespo = dpis.getServiceRespo().getText();
        String serviceGeo = dpis.getServiceGeo().getText();
        String chambre = dpis.getjLabelchamnre().getText();
        String sexe = dpis.getSexe().getText();
        String typesejour = dpis.getTypeDeSejour().getText();
        String etat = dpis.getEtat().getText();
        System.out.println(etat);

        mdpi.getNomDenaissance().setText(nom);
        mdpi.getNomUsuel().setText(nomUsuel);
        mdpi.getPrenom().setText(prenom);
        mdpi.getAdresse().setText(adresse);
        mdpi.getNumSS().setText(numsecu);
        mdpi.getEmail().setText(email);
        mdpi.getTel().setText(tel);
        mdpi.getDateDeNaissance().setText(dateNiassance);
        mdpi.getServicerespo().setSelectedItem(serviceRespo);
        mdpi.getServicegeo().setSelectedItem(serviceGeo);
        mdpi.getSexe().setSelectedItem(sexe);
        mdpi.getChambre().setText(chambre);
        mdpi.getjLabel3().setText(ipp);
        mdpi.getTypesejour().setSelectedItem(typesejour);
        mdpi.getEtatsejour().setSelectedItem(etat);

    RafraichitLesPanels rf = new RafraichitLesPanels(jframe,mdpi);

    }

}
