package BD;

import NF.Patient;
import NF.Sih;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MethodeBD {

    private ConnexionBD comm;
    private Statement state;

    /**
     * Constructeur de la classe, avec en paramètre la connection à la base.
     *
     * @param comm
     * @throws SQLException
     */
    public MethodeBD(ConnexionBD comm) throws SQLException {
        this.state = comm.getConnexion().createStatement();
        this.comm = comm;

    }
}