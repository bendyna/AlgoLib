
package geometry2D;/*
 * Date: 18.05.13 14:29
 * Author: ivan.bendyna
 */

import static geometry2D.GeometricObject.EPS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {

    @Test
    public void testShift() {
        Point p = new Point(10, 3);
        p.shift(2, -2);

        assertEquals(12.0, p.getX(), EPS);
        assertEquals(1.0, p.getY(), EPS);
    }

    @Test
    public void testRotate() {
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

    @Test
    public void testEquality() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(4, 3);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(4, 3);

        assertEquals(true, p2.equals(p4));
        assertEquals(false, p1.equals(p4));
        assertEquals(false, p1.equals(p3));
        assertEquals(false, p2.equals(p3));
        assertEquals(false, p2.equals(new Object()));

        p4.rotate(134);
        p4.rotate(226);
        assertEquals(true, p2.equals(p4));
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(10, 7);
        Point p2 = new Point(6, 4);

        assertEquals(25.0, p1.squareDistance(p2), EPS);
        assertEquals(5.0, p1.distance(p2), EPS);
    }

    @Test
    public void testLessThan() {
        Point p1 = new Point(5, 5);
        Point p2 = new Point(6, 5);
        Point p3 = new Point(5, 6);

        assertEquals(true, p1.compareTo(p2) < 0);
        assertEquals(true, p2.compareTo(p3) > 0);
        assertEquals(true, p1.compareTo(p3) < 0);
    }

    @Test
    public void testIntersect() {
        Point p1 = new Point(5, 5);
        Point p2 = new Point(6, 5);
        Point p3 = new Point(5, 5);

        assertEquals(0, p1.intersect(p2).size());
        assertEquals(1, p1.intersect(p3).size());
        assertEquals(true, p1.intersect(p3).get(0) instanceof Point);
        assertEquals(p1, p1.intersect(p3).get(0));
    }
}
