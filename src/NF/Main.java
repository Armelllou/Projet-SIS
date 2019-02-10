package NF;

import BD.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Main {


//Service serviceResponsbale


    public static void main(String[] args) throws SQLException{
     

        ConnexionBD conn = new ConnexionBD();
  Date d= new Date(01-01-1999) ;

Sexe s = Sexe.H;
Adresse a = new Adresse("2","Rue des fleurs","bayonne","64000");
Service s2 = Service.CHIRURGIE;
Service s1 = Service.GYNECOLOGIE;
Lit lit = new Lit("F");
Chambre chambre = null;
Localisation localisation = new Localisation (lit,chambre,s2,s1);      
Sih sih = new Sih();

String query ="DELETE FROM Patient";
  PreparedStatement statement1 = conn.getConnexion().prepareStatement(query); 
  statement1.executeUpdate();
 
Patient p1 = new Patient("teulieres","lormand",d,s,"Bernard",a,localisation);
Patient p2 = new Patient("teulieres","lormand",d,s,"Bernard",a,localisation);
Patient p3 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p4 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p5 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p6 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p7 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p8 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p9 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p10 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);

 

    }
    }