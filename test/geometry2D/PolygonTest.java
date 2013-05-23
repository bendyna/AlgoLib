/*
 * Filename: PolygonTest.java
 * Date: May 22, 2013 11:45:09 PM
 * Author: Bendyna Ivan
 */

package geometry2D;

import static org.junit.Assert.assertEquals;

import java.util.List;

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

    @Test()
    public void testIntersections() {
        Polygon polygon1 = new Polygon(new Point[] { new Point(1, 3),
                new Point(1, 6), new Point(2, 6), new Point(3, 4),
                new Point(4, 6), new Point(5, 6), new Point(5, 3) });
        Polygon polygon2 = new Polygon(new Point[] { new Point(1, 6),
                new Point(1, 8), new Point(5, 8), new Point(5, 6) });
        Polygon polygon3 = new Polygon(new Point[] { new Point(1, 5),
                new Point(1, 8), new Point(5, 8), new Point(5, 5) });
        Circle circle = new Circle(new Point(3, 3), 2);
        Point point = new Point(3, 4);
        Line line = Line.fromPoints(new Point(2, 6), new Point(5, 3));

        List<GeometricObject> intersection = polygon1.intersect(polygon2);
        assertEquals(2, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Segment);
        assertEquals(true, intersection.get(1) instanceof Segment);

        intersection = polygon1.intersect(polygon3);
        int cp = 0;
        int cs = 0;
        for (GeometricObject go : intersection) {
            if (go instanceof Segment) {
                cs++;
            }
            else if (go instanceof Point) {
                cp++;
            }
        }
        assertEquals(2, cp);
        assertEquals(2, cs);

        intersection = polygon1.intersect(circle);
        assertEquals(4, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(true, intersection.get(1) instanceof Point);
        assertEquals(true, intersection.get(2) instanceof Point);
        assertEquals(true, intersection.get(3) instanceof Point);

        intersection = polygon1.intersect(point);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(point, intersection.get(0));

        intersection = polygon1.intersect(line);
        assertEquals(3, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(true, intersection.get(1) instanceof Point);
        assertEquals(true, intersection.get(2) instanceof Point);
    }
}
