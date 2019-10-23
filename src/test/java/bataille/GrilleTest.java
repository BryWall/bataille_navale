package bataille;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple Bateau.
 */
public class GrilleTest {
    Grille g;
    Grille g1;
    Bateau  b1;

    @Before
    public void init(){
        g = new Grille(3, 1);
        g1 = new Grille(1, 1);
        b1 = new Bateau(1,0,0,"H");
    }

    @Test
    public void testCreateGrille() {
        assertTrue(null != g);
    }

    @Test
    public void testAddBateau(){
        assertEquals("0", g1.toString().trim());
        assertFalse(g1.getCell(0, 0).hasBateau());
        g1.addBateau(b1);
        assertTrue(g1.getCell(0, 0).hasBateau());
        assertEquals("1", g1.toString().trim());
    }


}