package listener.commun;

import bd.ConnexionBD;
import bd.MethodeBD;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class BoutonRecherchePatientPhEtIde implements ActionListener {
    Fenetre fen;
    ConsulterDPIPHetIDE cdpis;
    ConnexionBD conn = ConnexionBD.getInstance();

    public BoutonRecherchePatientPhEtIde(Fenetre jframe, ConsulterDPIPHetIDE cdpis) {
        this.fen = jframe;
        this.cdpis = cdpis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Recherche un patient via son IPP
        String ipp23 = cdpis.getjTextField1().getText();
        cdpis.getjTable1().setGridColor(new Color(153, 153, 153));
        cdpis.getjTable1().setModel(MethodeBD.recherchePatientViaIPP(ipp23));
        cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
        cdpis.repaint();

        String ipp = cdpis.getjTextField1().getText();
        if (ipp == null) {
            DefaultTableModel templatesTableModel;
            templatesTableModel = new DefaultTableModel(new String[][]{{null, null, null}}, new String[]{"Nom", "Prénom", "IPP"});
            cdpis.getjTable1().setGridColor(new Color(153, 153, 153));
            cdpis.getjTable1().setModel(templatesTableModel);
            cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
            cdpis.repaint();
        }

        //Recherche Patient via Nom et Prenom
        String nomPrenom = cdpis.getjTextField1().getText();
        String[] splitArray = null; //tableau de chaînes
        splitArray = nomPrenom.split(" ");// On découpe la chaîne à traiter et on récupère le résultat dans le tableau "splitArray"
        for (int i = 0; i < splitArray.length; i++) {
            System.out.println("élement n° " + i + "=[" + splitArray[i] + "]"); // On affiche chaque élément du tableau
        }
        cdpis.getjTable1().setModel(MethodeBD.recherchePatientviaNomEtPrenomIdeEtPh (splitArray,ListenerConnexion.getBDHService(), ListenerConnexion.getState()));
        cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
        cdpis.repaint();
        System.out.println(cdpis.getjTable1().getModel());
        
        if ((MethodeBD.recherchePatientViaIPP(ipp23)==null)&&(MethodeBD.recherchePatientviaNomEtPrenomIdeEtPh (splitArray,ListenerConnexion.getBDHService(), ListenerConnexion.getState())==null)){
            JOptionPane.showMessageDialog(null, "Aucun résultat pour le patient recherché", "Information", JOptionPane.INFORMATION_MESSAGE);
        }


    }
}
