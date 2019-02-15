package NF;

import BD.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

public class SoinInf {
    private Date date;
    private String Type;
    private Infirmier ide;
    private Ipp ipp;
    private String observation;
    private Dates dates;
    
    
    
    ConnexionBD conn = new ConnexionBD();

    public SoinInf(Date date, String Type, Infirmier ide,Ipp ipp , String observation, Dates dates) {
        this.date = date;
        this.Type = Type;
        this.ide = ide;
        this.ipp = ipp;
        this.observation = observation;
        this.dates = dates;
    }

   
    
    public boolean AjouterActeSurBD(SoinInf a) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO Actes (idIDE, ,ipp, type,observation,Sexe) VALUES(?,?,?,?,?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
//        statement.setObject(1,), Types.INTEGER);
      

        statement.executeUpdate();
        j = true;
        return j;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return Type;
    }

    public Infirmier getIde() {
        return ide;
    }

    public Ipp getipp() {
        return ipp;
    }

    public String getObservation() {
        return observation;
    }

    public Dates getDates() {
        return dates;
    }

    public ConnexionBD getConn() {
        return conn;
    }
    

}
