package main.java.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBD {

    private static ConnexionBD bd;
    private Connection conn;

    /**
     * Constructeur de la class.
     */
    private ConnexionBD() {

        try {

            //String DBurl = "jdbc:mysql://192.168.64.2/bd2";
            String DBurl = "jdbc:mysql://localhost:3306/bd2";

            DBurl += "?serverTimezone=UTC";

            Class.forName("com.mysql.cj.jdbc.Driver");

            this.conn = DriverManager.getConnection(DBurl, "armelle", "armelle");

            //  this.conn = DriverManager.getConnection(DBurl, "root", "ok");


            if (this.conn.isValid(0)) {
                System.out.println("===>Connexion effectuée");
            }

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
