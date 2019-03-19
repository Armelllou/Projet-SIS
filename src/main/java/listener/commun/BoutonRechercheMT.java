package listener.commun;

import bd.MethodeBD;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import interfaces.ListePersonnel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonRechercheMT implements ActionListener {

    Fenetre fen;
    ListePersonnel liste;

    public BoutonRechercheMT(Fenetre jframe, ListePersonnel liste) {
        this.fen = jframe;
        this.liste = liste;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        liste.getTableMT().setGridColor(new Color(153, 153, 153));
        liste.getTableMT().setModel(MethodeBD.rechercheMedicoTechViaIPP(((liste.getBarreDeRecherchePersonnelMT().getText()))));
        liste.getTableMT().setFont(new Font("Calibri", 0, 18));
        liste.repaint();

    }
}
