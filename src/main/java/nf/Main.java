package nf;

import bd.ConnexionBD;
import bd.MethodeBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws SQLException {

    //    ConnexionBD conn = ConnexionBD.getInstance();
        //Date d = new Date(01 - 01 - 1999);

        MethodeBD.nbrePatientBD();

//Sexe s = Sexe.H;
//Adresse a = new Adresse("2","Rue des fleurs","bayonne","64000");
//Service s2 = Service.CHIRURGIE;
//Service s1 = Service.GYNECOLOGIE;
//Lit lit = new Lit("F");
//Chambre chambre = null;
//Localisation localisation = new Localisation (lit,chambre,s2,s1);      
//Sih sih = new Sih();
//Patient p10 = new Patient("teulieres","lormand",d,s,"Brnard");
//        String Sql1 = "Select * from ide WHERE idIDE ='456'and motDePasse='456'";
//        PreparedStatement ps = conn.getConnexion().prepareStatement(Sql1);
//        ResultSet Rs = ps.executeQuery();;
//
//        ResultSetMetaData rsmd = Rs.getMetaData();
//        int columnsNumber = rsmd.getColumnCount();
//        while (Rs.next()) {
//
//            String Nom = Rs.getString(3);
//            String Prenom = Rs.getString(4);
//            String Service = Rs.getString(5);
//            String Total = Nom + " " + Prenom + " " + Service;
//
//            System.out.print(Total);
//                
//        }
////System.out.println("");
 
//    }
 String Sql1 = "Select * from patient WHERE IPP ='" + "19020001" + "'";
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement ps;

                ps = conn.getConnexion().prepareStatement(Sql1);

                ResultSet Rs = ps.executeQuery();;

                ResultSetMetaData rsmd = Rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (Rs.next()) {

                    String idIde = Rs.getString(1);

                    String type = Rs.getString(2);
                    String observation = Rs.getString(3);
                    String date = Rs.getString(4);
                    
                    System.out.println(type);
                    System.out.println("aaaaaa");

    
}}}
