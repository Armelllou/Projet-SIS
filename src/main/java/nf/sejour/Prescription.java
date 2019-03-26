package nf.sejour;

import bd.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import nf.Dates;

public class Prescription {
  ConnexionBD conn = ConnexionBD.getInstance();

    private String type;
    private String idPH;
    private String ipp;
    private String details;
    private Dates dates;

    // creer une prescription
    public Prescription(String details, String Type, String idPH, String ipp) {
   
        this.type = Type;
        this.idPH = idPH;
        this.ipp = ipp;
        this.details = details;
        this.dates = dates;
    }

    // ajoute une prescription sur la base de donnée
    public boolean AjouterActeSurBD(Prescription a) throws SQLException {
        boolean j = false;
        String sql = " INSERT INTO prescription (type,ipp, idPh, Detail) VALUES(?,?,?,?) ";
        
        
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql); 

        statement.setObject(1, a.getType(), Types.VARCHAR);
        statement.setObject(2, a.getipp(), Types.INTEGER);
        statement.setObject(3, a.getIde(), Types.VARCHAR);
        statement.setObject(4, a.getDetail(), Types.VARCHAR);


        statement.executeUpdate();
        j = true;
        return j;
    }


    public String getType() {
        return type;
    }

    public String getIde() {
        return idPH;
    }

    public String getipp() {
        return ipp;
    }

    public String getDetail() {
        return details;
    }

    public Dates getDates() {
        return dates;
    }

}
