package geometry3D;

import org.junit.Test;

import static geometry3D.GeometricObject.EPS;
import static org.junit.Assert.assertEquals;

/**
 * User: capitan
 * Date: 2/21/14
 * Time: 11:30 PM
 */
public class PointTest {
    @Test
    public void testShift() {
        Point p = new Point(3, 4, 5);
        p.shift(2, -2, 3);

        assertEquals(5.0, p.getX(), EPS);
        assertEquals(2.0, p.getY(), EPS);
        assertEquals(8.0, p.getZ(), EPS);
    }

    @Test
    public void testEquality() {
        Point p1 = new Point(3, 4, 0);
        Point p2 = new Point(4, 3, 0);
        Point p3 = new Point(4, 4, 0);
        Point p4 = new Point(4, 3, 0);
        Point p5 = new Point(4, 3, 0);
        Point p6 = new Point(4, 3, 1);

        assertEquals(true, p2.equals(p4));
        assertEquals(false, p1.equals(p4));
        assertEquals(false, p1.equals(p3));
        assertEquals(false, p2.equals(p3));
        assertEquals(true, p4.equals(p5));
        assertEquals(false, p4.equals(p6));
        assertEquals(false, p2.equals(new Object()));
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(10, 7, 0);
        Point p2 = new Point(6, 4, 0);
        Point p3 = new Point(2, 9, -3);
        Point p4 = new Point(8, 3, 10);

        assertEquals(25.0, p1.squareDistance(p2), EPS);
        assertEquals(5.0, p1.distance(p2), EPS);
        assertEquals(7.071067812, p2.distance(p3), EPS);
        assertEquals(10.246950766, p2.distance(p4), EPS);
        assertEquals(15.524174696, p3.distance(p4), EPS);
        assertEquals(0.0, p4.distance(p4), EPS);
    }
}
