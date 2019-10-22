package bataille;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * Unit test for simple Bateau.
 */
public class BateauTest {

    @Test
    public void testBateau() {
        Bateau b = new Bateau(10, 2, 2, "H");
        assertTrue(null != b);
    }
}