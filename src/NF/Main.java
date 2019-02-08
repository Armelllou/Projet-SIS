package NF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/bd1";
        String login = "root";
        String passwd = "";
        Connection cn = null;
        Statement st = null;

        //try {
            // 1. Get a connection to database
            //Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dem", "id", "mdp");
            //Class.forName("com.mysql.jdbc.Driver");
            //cn = DriverManager.getConnection(url, login, passwd);
            //st = cn.createStatement();
            // Chargement du driver
            // Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            // Connexion à la base de données "DBurl"
            // this.conn = DriverManager.getConnection(String.valueOf(myConn));

            //if (this.conn.isValid(0)) {
            System.out.println("===>Connexion effectuée");

            //3. Execute SQL query
            //4. Process the result set
            //  }

            // } catch (IllegalAccessException | InstantiationException | SQLException e) {
            //    e.printStackTrace();
            // }

            Ipp ipp = new Ipp();
            Ipp ipp3 = new Ipp();
            Ipp ipp4 = new Ipp();
            Ipp ipp5 = new Ipp();
            Ipp ipp6 = new Ipp();
        } //catch (SQLException e) {
           // e.printStackTrace();
        }
    //}}