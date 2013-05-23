package geometry2D;/*
 * Date: 23.05.13 18:31
 * Author: ivan.bendyna
 */

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CirclesIntersectionTest {
    @Test
    public void testIntersection() {
        Circle circle1 = new Circle(new Point(1, 2), 1);
        Circle circle2 = new Circle(new Point(1, 2), 0.5);
        Circle circle3 = new Circle(new Point(3, 2), 1);
        Circle circle4 = new Circle(new Point(3, 2), 1);
        Circle circle5 = new Circle(new Point(4, 3), 1);

        assertEquals(0, CirclesIntersection.findIntersection(circle1, circle2).size());

        List<GeometricObject> intersection = CirclesIntersection.findIntersection(circle1, circle3);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(new Point(2, 2), intersection.get(0));

        assertEquals(0, CirclesIntersection.findIntersection(circle5, circle2).size());

        intersection = CirclesIntersection.findIntersection(circle3, circle4);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Circle);
        assertEquals(circle3, intersection.get(0));

        intersection = CirclesIntersection.findIntersection(circle3, circle5);
        assertEquals(2, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(true, intersection.get(1) instanceof Point);
        assertEquals(true, intersection.get(0).equals(new Point(3, 3)) || intersection.get(1).equals(new Point(3, 3)));
        assertEquals(true, intersection.get(0).equals(new Point(4, 2)) || intersection.get(1).equals(new Point(4, 2)));
    }
}
