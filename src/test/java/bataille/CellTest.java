package bataille;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
    Cell cellWithoutBateau;
    Cell cellWithBateau;
    Bateau b;

    @Before
    public void init(){
        cellWithoutBateau = new Cell(0, 0);
        b = new Bateau(3, 0, 0, "H");
        cellWithBateau = new Cell(b, 0, 0);
    }

    @Test
    public void testCreateCell() {
        assertEquals(0, cellWithoutBateau.x);
        assertEquals(0, cellWithoutBateau.y);
        assertEquals(null, cellWithoutBateau.getBateau());
        assertEquals(0, cellWithBateau.x);
        assertEquals(0, cellWithBateau.y);
        assertEquals(b, cellWithBateau.getBateau());
    }

    @Test
    public void testIsAttacked(){
        int pv = b.getPV();
        assertFalse(cellWithBateau.isAttacked());
        cellWithBateau.attacked();
        assertTrue(cellWithBateau.isAttacked());
        assertEquals(pv-1, b.getPV());
    }

    @Test
    public void testSetBateau(){
        assertFalse(cellWithoutBateau.hasBateau());
        cellWithoutBateau.setBateau(b);
        assertTrue(cellWithoutBateau.hasBateau());
    }

    @Test
    public void testToString(){
        assertEquals("0",cellWithoutBateau.toString());
        assertEquals("1", cellWithBateau.toString());
        cellWithBateau.attacked();
        cellWithoutBateau.attacked();
        assertEquals("3",cellWithoutBateau.toString());
        assertEquals("2", cellWithBateau.toString());
    }

    @Test
    public void testToStringHidden(){
        assertEquals("0",cellWithoutBateau.toStringHidden());
        assertEquals("0", cellWithBateau.toStringHidden());
        cellWithBateau.attacked();
        cellWithoutBateau.attacked();
        assertEquals("3",cellWithoutBateau.toStringHidden());
        assertEquals("2", cellWithBateau.toStringHidden());
    }



}

