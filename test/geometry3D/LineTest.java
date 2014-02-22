package geometry3D;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * User: capitan
 * Date: 2/22/14
 * Time: 12:09 AM
 */
public class LineTest {
    @Test
    public void testShift() {
        Line line = new Line(new Point(0, 1, 2), new Point(4, 2, -2));
        line.shift(1, -1, 2);
        assertTrue(line.isPointOnLine(new Point(3, 0.5, 2)));
    }

    @Test
    public void testIsPointOnLine() {
        Line line1 = new Line(new Point(4, 1, -6), new Point(2, 5, 2));
        assertTrue(line1.isPointOnLine(new Point(0, 9, 10)));
        assertTrue(line1.isPointOnLine(new Point(3, 3, -2)));
        assertTrue(line1.isPointOnLine(new Point(4, 1, -6)));
        assertTrue(line1.isPointOnLine(new Point(2, 5, 2)));
        assertFalse(line1.isPointOnLine(new Point(3, 1, 0)));
        assertFalse(line1.isPointOnLine(new Point(0, 0, 0)));
        Line line2 = new Line(new Point(7, 9, 3), 0, 0, 6);
        Line line3 = new Line(new Point(7, 9, 8), -1, -4, -1);
        Point p = new Point(7, 9 ,8);
        assertTrue(line2.isPointOnLine(p));
        assertTrue(line3.isPointOnLine(p));
    }

    @Test
    public void testEquals() {
        Line line1 = new Line(new Point(4, 1, 6), new Point(2, 3, 2));
        assertTrue(line1.equals(line1));
        assertFalse(line1.equals(new Object()));
        Line line2 = new Line(new Point(3, 2, 4), new Point(1, 4, 0));
        assertTrue(line1.equals(line2));
        assertTrue(line2.equals(line1));
        Line line3 = new Line(new Point(1, 3, 8), new Point(4, 3, 1));
        assertFalse(line3.equals(line2));
        assertFalse(line3.equals(line1));
    }

    @Test
    public void testIntersect() {
        Line line1 = new Line(new Point(4, 1, 6), new Point(2, 3, 2));
        Line line2 = new Line(new Point(3, 2, 4), new Point(1, 4, 0));
        Point p = line1.intersectLine(line2);
        assertTrue(Double.isNaN(p.getX()) && Double.isNaN(p.getY()) && Double.isNaN(p.getZ()));

        Line line3 = new Line(new Point(1, 3, 8), new Point(4, 3, 1));
        Point p1 = line1.intersectLine(line3);
        assertNull(p1);

        Random rand = new Random();
        for(int t = 0; t < 100000; t++) {
            Point p2 = new Point(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
            Point p3 = new Point(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
            Point p4 = new Point(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
            Point p5 = new Point(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
            if(p2.equals(p3) || p4.equals(p5)) {
                continue;
            }
            line1 = new Line(p2, p3);
            line2 = new Line(p4, p5);
            p = line1.intersectLine(line2);
            if(p != null && !Double.isNaN(p.getX())) {
                assertTrue(line1.isPointOnLine(p) && line2.isPointOnLine(p));
            }
        }
    }
}
