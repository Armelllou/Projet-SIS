package listener.commun;

import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonRecherchePh implements ActionListener {

    Fenetre fen;
    ListePersonnel liste;

    public BoutonRecherchePh(Fenetre jframe, ListePersonnel liste) {
        this.fen = jframe;
        this.liste = liste;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        liste.getTablePH().setGridColor(new Color(153, 153, 153));
        liste.getTablePH().setModel(MethodeBD.recherchePHViaIPP(liste.getBarreDeRecherchePH().getText()));
        liste.getTablePH().setFont(new Font("Calibri", 0, 18));
        liste.repaint();

    }
}
