package test;

import model.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie m1, m2;

    @Before
    public void setUp() {
        m1 = new Movie("Alien: Covenant", 18, 100);
        m2 = new Movie("Ratatouille", 0, 120);
    }

    @Test
    public void testGetters() {
        assertEquals("Alien: Covenant", m1.getTitle());
        assertEquals("Ratatouille", m2.getTitle());
        assertEquals(18, m1.getAgeRestriction());
        assertEquals(0, m2.getAgeRestriction());
        assertEquals(100, m1.getMaxSeating());
        assertEquals(120, m2.getMaxSeating());
    }

    @Test
    public void testisFull() {
        assertFalse(m1.isFull());

        while (!m1.isFull()) {
            m1.addViewer();
        }

        assertTrue(m1.isFull());
        assertEquals(100, m1.getCurrentSeating());
    }

}