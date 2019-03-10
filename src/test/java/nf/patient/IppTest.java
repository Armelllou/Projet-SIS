package nf.patient;

import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

public class IppTest {

    @Test
    public void correctIpp() throws SQLException {
        Ipp ipp1 = new Ipp();
        Ipp ipp2 = new Ipp();
        //assertEquals("190300001", ipp1.getIpp());
        //assertEquals("190300002", ipp1.getIpp());
    }
}
