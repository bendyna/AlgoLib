/*
 * Filename: SegmentsIntersectionsTest.java
 * Date: May 21, 2013 9:43:00 PM
 * Author: Bendyna Ivan
 */

package geometry2D;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SegmentsIntersectionTest {

    @Test
    public void testIntersections() throws Exception {
        Segment segment1 = new Segment(new Point(2, 3), new Point(4, 5));
        Segment segment2 = new Segment(new Point(3, 4), new Point(5, 6));
        Segment segment3 = new Segment(new Point(5, 6), new Point(7, 8));
        Segment segment4 = new Segment(new Point(5, 4), new Point(3, 6));

        GeometricObject intersection = SegmentsIntersection.findIntersection(
                        segment1, segment2);
        assertEquals(true, intersection instanceof Segment);

        Segment intersectionSegment = (Segment) intersection;
        assertEquals(intersectionSegment, new Segment(new Point(3, 4),
                        new Point(4, 5)));

        assertEquals(null, SegmentsIntersection.findIntersection(segment1,
                        segment3));
        assertEquals(new Point(4, 5), SegmentsIntersection.findIntersection(
                        segment1, segment4));
        assertEquals(new Point(5, 6), SegmentsIntersection.findIntersection(
                        segment2, segment3));
        assertEquals(new Point(4, 5), SegmentsIntersection.findIntersection(
                        segment2, segment4));
        assertEquals(null, SegmentsIntersection.findIntersection(segment3,
                        segment4));

        Segment segment5 = new Segment(new Point(0, 4), new Point(0, 6));
        Segment segment6 = new Segment(new Point(0, 5), new Point(0, 7));
        intersection = SegmentsIntersection
                        .findIntersection(segment5, segment6);
        assertEquals(true, intersection instanceof Segment);

        intersectionSegment = (Segment) intersection;
        assertEquals(intersectionSegment, new Segment(new Point(0, 5),
                        new Point(0, 6)));
    }
}
