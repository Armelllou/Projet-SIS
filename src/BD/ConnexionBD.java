package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnexionBD {

    private Connection conn;

    /**
     * Constructeur de la class.
     */
    public ConnexionBD() {

        try {
            //String DBurl = "jdbc:mysql://192.168.64.2/bd1";
            String DBurl = "jdbc:mysql://localhost:3306/bd1";
            DBurl += "?serverTimezone=UTC";

            Class.forName("com.mysql.cj.jdbc.Driver");

            this.conn = DriverManager.getConnection(DBurl, "armelle", "armelle");

            if (this.conn.isValid(0)) {
                System.out.println("===>Connexion effectuée");
            }

        } catch (Exception ex) {
            System.out.println("Erreur Connection driver");
            ex.printStackTrace();
        }

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


