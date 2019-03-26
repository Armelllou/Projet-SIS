package listener.commun;

import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonRechercheSA implements ActionListener {

    Fenetre fen;
    ListePersonnel liste;

    public BoutonRechercheSA(Fenetre jframe, ListePersonnel liste) {
        this.fen = jframe;
        this.liste = liste;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        liste.getTableSecretaire().setGridColor(new Color(153, 153, 153));
        liste.getTableSecretaire().setModel(MethodeBD.rechercheSAdViaIPP(((liste.getBarreDeRechercheIDE().getText()))));
        liste.getTableSecretaire().setFont(new Font("Calibri", 0, 18));
        liste.repaint();

    }
}
