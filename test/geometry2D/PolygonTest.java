/*
 * Filename: PolygonTest.java
 * Date: May 22, 2013 11:45:09 PM
 * Author: Bendyna Ivan
 */

package geometry2D;

import org.junit.Test;

public class PolygonTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException2Sides() {
        new Polygon(new Point[] { new Point(0, 0), new Point(1, 1) });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException3Sides() {
        new Polygon(new Point[] { new Point(0, 0), new Point(1, 1),
                new Point(2, 2) });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException4Sides() {
        new Polygon(new Point[] { new Point(1, 1), new Point(1, -1),
                new Point(-1, 1), new Point(-1, -1) });

    }

    @Test()
    public void testConstructorLegal4Sides() {
        new Polygon(new Point[] { new Point(0, 0), new Point(1, 1),
                new Point(2, 2), new Point(0, 5) });
    }
}
