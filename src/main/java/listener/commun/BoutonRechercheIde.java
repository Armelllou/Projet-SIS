package listener.commun;

import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonRechercheIde implements ActionListener {

    Fenetre fen;
    ListePersonnel liste;

    public BoutonRechercheIde(Fenetre jframe, ListePersonnel liste) {
        this.fen = jframe;
        this.liste = liste;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        liste.getTableIDE().setGridColor(new Color(153, 153, 153));
        liste.getTableIDE().setModel(MethodeBD.rechercheIdeViaIPP((liste.getBarreDeRechercheIDE1().getText())));
        liste.getTableIDE().setFont(new Font("Calibri", 0, 18));
        liste.repaint();

    }
}
