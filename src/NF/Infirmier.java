package NF;

import BD.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Infirmier extends Personnel {
public int idIDE;
public int mdp;
public String nom;
public String prenom;
public String service;

ConnexionBD conn = new ConnexionBD();

    public Infirmier(int idIDE, int mdp, String nom, String prenom, String service) {
        this.idIDE = idIDE;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.service = service;
    }

    public int getIdIDE() throws SQLException {
         /// problème pour avoir li' id d'une IDE pour une seule personne et pas pour toute la table 
          int idIDEs=0;
        String Sql1 =  "SELECT idIDE FROM ide";
        PreparedStatement ps = conn.getConnexion().prepareStatement(Sql1);
        ResultSet resultSet = ps.executeQuery();

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {

                }
                String columnValue = resultSet.getString(i);
                String columnInteressant = columnValue.substring(5);
                
                 idIDEs = Integer.parseInt(columnInteressant);
                //System.out.print(idIDEs);
            } 
        
    }
            return idIDEs;

        }
        
        
    public int getMdp() {
        return mdp;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getService() {
        return service;
    }



}
