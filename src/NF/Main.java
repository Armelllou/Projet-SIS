package NF;

import BD.ConnexionBD;
import interfaces.Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import static javafx.scene.input.KeyCode.F;

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
Patient p1 = new Patient("teulieres","lormand",d,s,"Bernard",a,localisation);
Patient p2 = new Patient("teulieres","lormand",d,s,"Bernard",a,localisation);
Patient p3 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p4 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);
Patient p5 = new Patient("teulieres","lormand",d,s,"Brnard",a,localisation);

p1.AjouterSurBdPatient(p1);
p2.AjouterSurBdPatient(p2);
p3.AjouterSurBdPatient(p3);
p4.AjouterSurBdPatient(p4);
p5.AjouterSurBdPatient(p5);


    }
}