package main.java.nf.sejour;

import main.java.bd.ConnexionBD;
import main.java.nf.Dates;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Acte {

    private Dates date;
    private String Type;
    private String idIDE;
    private String ipp;
    private String observations;
    private Dates dates;

    ConnexionBD conn = new ConnexionBD();

    public Acte(String observations, String Type, String idIDE, String ipp, Dates dates) {
        this.date = date;
        this.Type = Type;
        this.idIDE = idIDE;
        this.ipp = ipp;
        this.observations = observations;
        this.dates = dates;
    }

    public boolean AjouterActeSurBD(Acte a) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO Actes (idIDE, ,ipp, type,observation,date) VALUES(?,?,?,?,?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
        statement.setObject(1, a.getIde(), Types.INTEGER);
        statement.setObject(2, a.getipp(), Types.INTEGER);
        statement.setObject(3, a.getType(), Types.VARCHAR);
        statement.setObject(4, a.getObservation(), Types.VARCHAR);
        statement.setObject(5, a.getDates(), Types.INTEGER);
        

        statement.executeUpdate();
        j = true;
        return j;
    }

   

    public String getType() {
        return Type;
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

    public ConnexionBD getConn() {
        return conn;
    }

}
