package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBD {

    private static ConnexionBD bd;
    private Connection conn;

    /**
     * Constructeur de la class.
     */
    public ConnexionBD() {
// ------------BDD local -------------
try{
            //String bBurl = "jdbc:mysql://192.168.64.2/bd2";
            String bBurl = "jdbc:mysql://localhost:3306/bd2";
           bBurl += "?serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(bBurl, "armelle", "armelle");
            //  this.conn = DriverManager.getConnection(bBurl, "root", "ok");
            if (this.conn.isValid(0)) {
                System.out.println("===> Connexion effectuee");
            }
// ------------BDD en ligne -------------
//        try {
//            System.out.println("===> Connexion en cours");
//            String bdUrl = "jdbc:mysql://sql7.freemysqlhosting.net/sql7281355";
//            bdUrl += "?serverTimezone=UTC";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.conn = DriverManager.getConnection(bdUrl, "sql7281355", "3ju17gUv79");
//            if (this.conn.isValid(0)) {
//                System.out.println("===> Connexion ok");
//            }
////
////
        } catch (Exception ex) {
            System.out.println("Erreur Connection driver");
            ex.printStackTrace();
        }
    }

    public static ConnexionBD getInstance() {
        if (bd == null) {
            bd = new ConnexionBD();
        }
        return bd;
    }

    /**
     * Retourne la connexion en cours de la class
     *
     * @return Connection conn
     */
    public Connection getConnexion() {
        return conn;
    }
}
