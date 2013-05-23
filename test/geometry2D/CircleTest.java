/*
 * Filename: CircleTest.java
 * Date: May 23, 2013 10:51:50 PM
 * Author: Bendyna Ivan
 */

package geometry2D;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;

public class CircleTest {

    @Test
    public void testEquality() {
        Circle circle1 = new Circle(new Point(5, 5), 5);
        Circle circle2 = new Circle(new Point(5, 6), 5);
        Circle circle3 = new Circle(new Point(5, 5), 6);
        Circle circle4 = new Circle(new Point(5, 5), 5);

        assertEquals(circle1, circle1);
        assertNotEquals(circle1, circle2);
        assertNotEquals(circle1, circle3);
        assertEquals(circle1, circle4);
    }

    @Test
    public void testIntersection() {
        Circle circle1 = new Circle(new Point(3, 3), 1);
        Circle circle2 = new Circle(new Point(3, 5), 1);
        Segment segment = new Segment(new Point(3, 3), new Point(5, 5));
        Point point = new Point(4, 5);
        Line line = Line.fromPoints(new Point(0, 6), new Point(1, 6));

        List<GeometricObject> intersection = circle1.intersect(circle2);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(new Point(3, 4), intersection.get(0));

        intersection = circle1.intersect(segment);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(new Point(3 + Math.sqrt(0.5), 3 + Math.sqrt(0.5)),
                        intersection.get(0));

        assertEquals(0, circle1.intersect(point).size());
        assertEquals(0, circle1.intersect(line).size());
        assertEquals(0, circle2.intersect(segment).size());

        intersection = circle2.intersect(point);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(point, intersection.get(0));

        intersection = circle2.intersect(line);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(new Point(3, 6), intersection.get(0));
    }
}
