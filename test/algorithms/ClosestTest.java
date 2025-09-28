package main.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestTest {

    @Test
    void testSimple() {
        Closest.Point[] pts = {
                new Closest.Point(0, 0),
                new Closest.Point(3, 4),
                new Closest.Point(7, 7),
                new Closest.Point(1, 1)
        };
        double result = Closest.closestPair(pts);
        assertEquals(Math.sqrt(2), result, 1e-9);
    }

    @Test
    void testTwoPoints() {
        Closest.Point[] pts = {
                new Closest.Point(1, 2),
                new Closest.Point(4, 6)
        };
        assertEquals(5.0, Closest.closestPair(pts), 1e-9);
    }

    @Test
    void testRandom() {
        Closest.Point[] pts = new Closest.Point[100];
        for (int i = 0; i < 100; i++) {
            pts[i] = new Closest.Point(i, i * i % 17);
        }
        double result = Closest.closestPair(pts);
        assertTrue(result >= 0.0);
    }
}
