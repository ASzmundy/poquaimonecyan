package implems;

import implems.uniques.Poquaidexe;
import org.junit.Test;
import static org.junit.Assert.*;

public class PoquaidexeTest {

    @Test
    public void testPoquaidexe(){

        Poquaidexe p = new Poquaidexe();
        assertNotNull(p);
        assertNotNull(p.poquaidexe);
    }
}