package NF;

import BD.ConnexionBD;

import java.awt.event.ActionEvent;
import java.sql.*;

import Listener.BoutonRecherchePatient;
import interfaces.ConsulterDPISecretaire;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) throws SQLException {

        ConnexionBD conn = new ConnexionBD();
        Date d = new Date(01 - 01 - 1999);

//Sexe s = Sexe.H;
//Adresse a = new Adresse("2","Rue des fleurs","bayonne","64000");
//Service s2 = Service.CHIRURGIE;
//Service s1 = Service.GYNECOLOGIE;
//Lit lit = new Lit("F");
//Chambre chambre = null;
//Localisation localisation = new Localisation (lit,chambre,s2,s1);      
//Sih sih = new Sih();
//Patient p10 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
        String Sql1 = "Select max(IPP) from patient";
        PreparedStatement ps = conn.getConnexion().prepareStatement(Sql1);
        ResultSet resultSet = ps.executeQuery();

//Patient p10 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);


        ConsulterDPISecretaire consult = new ConsulterDPISecretaire();
        String ipp = "190200004"; //consult.getjTextField1().getText();
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

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {

                }
                String columnValue = resultSet.getString(i);
                String columnInteressant = columnValue.substring(5);
                //System.out.print(columnInteressant);
                int ipp = Integer.parseInt(columnInteressant);
            }

        }

    }
}
