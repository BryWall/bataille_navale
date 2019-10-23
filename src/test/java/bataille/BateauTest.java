package bataille;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple Bateau.
 */
public class BateauTest {
    Bateau b;

    @Before
    public void init(){
        b = new Bateau(3, 0, 0, "H");
    }

    @Test
    public void testCreateBateau() {
        assertTrue(null != b);
    }

    @Test
    public void testAttacked() {
        int pv = b.getPV();
        b.attacked();
        assertEquals(pv-1, b.getPV());
    }

    @Test
    public void testisFlowed() {
        assertFalse(b.isFlowed());
        int pv = b.getPV();
        
        while(pv !=0 ){
            b.attacked();
            pv = b.getPV();
        }  
        assertTrue(b.isFlowed());
    }
}