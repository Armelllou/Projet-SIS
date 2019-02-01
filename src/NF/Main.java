package fr.polytech.tis.sis;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        //a
        try{
            // 1. Get a connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dem", "id", "mdp");
            //2. Create a statement
            //3. Execute SQL query
            //4. Process the result set
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
