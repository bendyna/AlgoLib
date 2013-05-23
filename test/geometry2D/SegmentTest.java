
package geometry2D;/*
 * Date: 18.05.13 16:17
 * Author: ivan.bendyna
 */

import static geometry2D.GeometricObject.EPS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class SegmentTest {

    @Test
    public void testLength() {
        assertEquals(5.0,
                        new Segment(new Point(10, -4), new Point(6, -1))
                                        .length(), EPS);
        assertEquals(Math.sqrt(2), new Segment(new Point(-5, -4), new Point(-6,
                        -5)).length(), EPS);
    }

    @Test
    public void testShift() {
        Segment segment = new Segment(new Point(4, -4), new Point(2, 0));
        segment.shift(-2, 2);

        assertEquals(2.0, segment.getA().getX(), EPS);
        assertEquals(2.0, segment.getB().getY(), EPS);
    }

    @Test
    public void testRotate() {
        Segment segment = new Segment(new Point(4, -4), new Point(2, 0));
        segment.rotate(90);

        assertEquals(4.0, segment.getA().getX(), EPS);
        assertEquals(2.0, segment.getB().getY(), EPS);
    }

    @Test
    public void testIsPointOnSegment() {
        Segment segment = new Segment(new Point(-2, 2), new Point(2, 3));

        assertEquals(true, segment.isPointOnSegment(new Point(0, 2.5)));
        assertEquals(true, segment.isPointOnSegment(new Point(-2, 2)));
        assertEquals(true, segment.isPointOnSegment(new Point(2, 3)));
        assertEquals(false, segment.isPointOnSegment(new Point(-1, 4)));
        assertEquals(false, segment.isPointOnSegment(new Point(6, 4)));
    }

    @Test
    public void testEquality() {
        Segment segment1 = new Segment(new Point(4, 5), new Point(6, 7));
        Segment segment2 = new Segment(new Point(6, 7), new Point(4, 5));

        assertEquals(segment1, segment2);
    }

    @Test
    public void testSegmentsRectIntersection() {
        Segment segment1 = new Segment(new Point(0, 3), new Point(3, 0));
        Segment segment2 = new Segment(new Point(2, 2), new Point(5, 5));
        Segment segment3 = new Segment(new Point(4, 3), new Point(7, 6));

        assertEquals(true, segment1.isSegmentsRectsIntersect(segment2));
        assertEquals(false, segment1.isSegmentsRectsIntersect(segment3));
        assertEquals(true, segment3.isSegmentsRectsIntersect(segment2));
    }

    @Test
    public void testSegmentsIntersection() {
        Segment segment1 = new Segment(new Point(1, 2), new Point(5, 4));
        Segment segment2 = new Segment(new Point(4, 2), new Point(2, 4));
        Point point = new Point(2, 2.5);

        assertEquals(0, point.intersect(segment2).size());

        List<GeometricObject> intersection = segment2.intersect(segment1);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(new Point(3, 3), intersection.get(0));

        intersection = segment1.intersect(point);
        assertEquals(1, intersection.size());
        assertEquals(true, intersection.get(0) instanceof Point);
        assertEquals(point, intersection.get(0));
    }
}
