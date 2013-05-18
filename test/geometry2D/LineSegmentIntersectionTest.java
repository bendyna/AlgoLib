
package geometry2D;/*
 * Date: 18.05.13 17:15
 * Author: ivan.bendyna
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LineSegmentIntersectionTest {

    @Test
    public void testIntersection() {
        Line line = Line.fromPoints(new Point(-4, 4), new Point(2, 2));
        Segment segment1 = new Segment(new Point(-4, 2), new Point(-2, 1));
        Segment segment2 = new Segment(new Point(-3, 3), new Point(0, 0));
        Segment segment3 = new Segment(new Point(-1, 0), new Point(-1, 3));
        Segment segment4 = new Segment(new Point(-2, 0), new Point(-2, 5));

        assertEquals(null, LineSegmentIntersection.findIntersection(line,
                        segment1));
        assertEquals(null, LineSegmentIntersection.findIntersection(line,
                        segment2));
        assertEquals(new Point(-1, 3),
                        LineSegmentIntersection
                                        .findIntersection(line, segment3));
        assertEquals(new Point(-2, 3.3333333333333),
                        LineSegmentIntersection
                                        .findIntersection(line, segment4));
    }
}
