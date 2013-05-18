package geometry2D;/*
 * Date: 18.05.13 16:17
 * Author: ivan.bendyna
 */

import static junit.framework.Assert.*;
import org.junit.Test;

public class SegmentTest {

    private final static double EPS = 0.00000001;

    @Test
    public void testLength(){
        assertEquals(5.0, new Segment(new Point(10, -4), new Point(6, -1)).length());
        assertEquals(Math.sqrt(2), new Segment(new Point(-5, -4), new Point(-6, -5)).length(), EPS);
    }

    @Test
    public void testShift(){
        Segment segment = new Segment(new Point(4, -4), new Point(2, 0));
        segment.shift(-2, 2);

        assertEquals(2.0, segment.getA().getX(), EPS);
        assertEquals(2.0, segment.getB().getY(), EPS);
    }

    @Test
    public void testRotate(){
        Segment segment = new Segment(new Point(4, -4), new Point(2, 0));
        segment.rotate(90);

        assertEquals(4.0, segment.getA().getX(), EPS);
        assertEquals(2.0, segment.getB().getY(), EPS);
    }

}
