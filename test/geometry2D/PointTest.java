package geometry2D;/*
 * Date: 18.05.13 14:29
 * Author: ivan.bendyna
 */

import org.junit.Test;
import static junit.framework.Assert.*;

public class PointTest {

    private final static double EPS = 0.00000001;

    @Test
    public void testShift() {
        Point p = new Point(10, 3);
        p.shift(2, -2);

        assertEquals(12.0, p.getX(), EPS);
        assertEquals(1.0, p.getY(), EPS);
    }

    @Test
    public void testRotate(){
        Point p = new Point(5, 3);
        p.rotate(180);

        assertEquals(-5.0, p.getX(), EPS);
        assertEquals(-3.0, p.getY(), EPS);

        p.rotate(-450);

        assertEquals(-3.0, p.getX(), EPS);
        assertEquals(5.0, p.getY(), EPS);

        p.rotate(new Point(-1, 4), 180);

        assertEquals(1.0, p.getX(), EPS);
        assertEquals(3.0, p.getY(), EPS);
    }
}
