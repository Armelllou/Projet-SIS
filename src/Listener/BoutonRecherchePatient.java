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

        try {
            String ipp = cdpis.getjTextField1().getText();
            String Sql1 = "Select * FROM patient WHERE IPP ='" + ipp + "'";

            java.sql.Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1"+"?serverTimezone=UTC","armelle","armelle");
            Statement stmt = null;
            stmt = conn1.createStatement();
            ResultSet rs = stmt.executeQuery(Sql1);
            while (rs.next()) {
                String name = rs.getString("Nom");
                String prenom = rs.getString("Prénom");
                String ipp1 = rs.getString("IPP");
                System.out.println(name + "\t" + prenom + "\t" + ipp1);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
