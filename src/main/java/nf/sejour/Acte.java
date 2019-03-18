package nf.sejour;

import bd.ConnexionBD;
import nf.Dates;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Acte {

    ConnexionBD conn = ConnexionBD.getInstance();
    private Dates date;
    private String type;
    private String idIDE;
    private String ipp;
    private String observations;
    private Dates dates;

    public Acte(String observations, String Type, String idIDE, String ipp) {
        this.date = date;
        this.type = Type;
        this.idIDE = idIDE;
        this.ipp = ipp;
        this.observations = observations;
        this.dates = dates;
    }

    public boolean AjouterActeSurBD(Acte a) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO actes (idIDE,ipp, type, observation) VALUES(?,?,?,?) ";
        
        
        
        
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql); 
//        statement.setObject(1, "456", Types.INTEGER);
//        statement.setObject(2,"19020003", Types.INTEGER);
//        statement.setObject(3, "prise de sang", Types.VARCHAR);
//        statement.setObject(4, "patient agité", Types.VARCHAR);
//        statement.setObject(5, new Dates ("01","03","2019"), Types.VARCHAR);
        statement.setObject(1, a.getIde(), Types.INTEGER);
        statement.setObject(2, a.getipp(), Types.INTEGER);
        statement.setObject(3, a.getType(), Types.VARCHAR);
        statement.setObject(4, a.getObservation(), Types.VARCHAR);
   


        statement.executeUpdate();
        j = true;
        return j;
    }


    public String getType() {
        return type;
    }

    public String getIde() {
        return idIDE;
    }

    public String getipp() {
        return ipp;
    }

    public String getObservation() {
        return observations;
    }

    public Dates getDates() {
        return dates;
    }

    

}
