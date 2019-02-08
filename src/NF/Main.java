package NF;

import BD.ConnexionBD;

import java.sql.SQLException;
import java.util.Date;

public class Main {


//Service serviceResponsbale

<<<<<<< HEAD
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
=======
    public static void main(String[] args) throws SQLException {
        Ipp ipp = new Ipp();
        Ipp ipp3 = new Ipp();
        Ipp ipp4 = new Ipp();
        Ipp ipp5 = new Ipp();
        Ipp ipp6 = new Ipp();

        ConnexionBD conn = new ConnexionBD();
        Date d = new Date(01 - 01 - 1999);

        Sexe s = Sexe.H;
        Adresse a = new Adresse("2", "Rue des fleurs", "bayonne", "64000");
        Service s2 = Service.CHIRURGIE;
        Service s1 = Service.GYNECOLOGIE;
        Lit lit = new Lit("F");
        Chambre chambre = null;
        Localisation localisation = new Localisation(lit, chambre, s2, s1);

        Patient p1 = new Patient("teuliere","lormand",d,s,"Bernard",a,localisation);
        //p1.AjouterSurBdPatient(p1, "medecin");
        Patient p2 = new Patient("teulieres", "lormand", d, s, "Bernard", a, localisation);
        //p2.AjouterSurBdPatient(p2, "medecin");
        Patient p3 = new Patient("teulieres", "lormand", d, s, "Bernard", a, localisation);

        p3.AjouterSurBdPatient(p3, "medecin");
>>>>>>> master


    }
}