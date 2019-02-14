package Listener;

import BD.ConnexionBD;
import interfaces.ConsulterDPISecretaire;
import interfaces.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BoutonRecherchePatient implements ActionListener {
    Fenetre fen;
    ConsulterDPISecretaire cdpis;
    ConnexionBD conn = new ConnexionBD();

    public BoutonRecherchePatient(Fenetre jframe, ConsulterDPISecretaire cdpis) {
        this.fen = jframe;
        this.cdpis = cdpis;
    }


    @Override
    public void actionPerformed(ActionEvent e)  {
        System.out.println("aaaaaa");

        try {
            String ipp = cdpis.getjTextField1().getText();
            String Sql1 = "Select* FROM patient WHERE IPP ='"+ipp+"'";
            PreparedStatement ps2 = conn.getConnexion().prepareStatement(Sql1);
            ResultSet Rs2 = ps2.executeQuery();

            ResultSetMetaData rsmd = Rs2.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (Rs2.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        System.out.print(",  ");
                    }
                    String columnValue = Rs2.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("aaaaaa");
            }

        } catch (SQLException ex) {
            Logger.getLogger(BoutonRecherchePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
