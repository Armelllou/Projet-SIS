package bd;

import listener.secretairemedical.TableauConsulterDPISecretaire;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class ConnexionBD {

    private static ConnexionBD bd;
    private Connection conn;

    /**
     * Constructeur de la class.
     */
    public ConnexionBD() {
 //------------BDD local -------------
//try{
//            String bBurl = "jdbc:mysql://192.168.64.2/bd2";
//            String bdUrl = "jdbc:mysql://localhost:3306/bd2";
//            bdUrl += "?serverTimezone=UTC";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.conn = DriverManager.getConnection(bdUrl, "armelle", "armelle");
//              this.conn = DriverManager.getConnection(bBurl, "root", "ok");
//            if (this.conn.isValid(0)) {
//                System.out.println("===> Connexion effectuee");
//            }
// ------------BDD en ligne -------------
        try {
            String uname = getEncryptedUser();
            String password = getEncryptedPass();
            System.out.println("===> Connexion en cours");
            String bdUrl = "jdbc:mysql://db4free.net/sqlsis1";
            bdUrl += "?serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(bdUrl, uname, password);
            if (this.conn.isValid(0)) {
                System.out.println("===> Connexion effectuee");
            }
//
        } catch (Exception ex) {
            System.out.println("Erreur Connection driver");
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);

        }finally {
        }
    }

    public static ConnexionBD getInstance() {
        if (bd == null) {
            bd = new ConnexionBD();
        }
        return bd;
    }

    /**
     * Retourne la connexion_personnel en cours de la class
     *
     * @return Connection conn
     */
    public Connection getConnexion() {
        return conn;
    }

    public String getEncryptedUser() {

        return "sqlprojetsis";
    }

    public String getEncryptedPass() {
        return "sqlprojetsis";
    }
}
