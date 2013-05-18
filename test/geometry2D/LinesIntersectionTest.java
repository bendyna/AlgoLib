
package geometry2D;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: ivan.bendyna Date: 15.04.13
 */
public class LinesIntersectionTest {

    private final static int RANDOM_COUNT = 10000;

    @Test
    public void testFindIntersectionEqual() throws Exception {
        Line line1 = new Line(5, -1, 10);
        Line line2 = new Line(-10, 2, -20);

        GeometricObject intersection = LinesIntersection.findIntersection(
                        line1, line2);
        assertEquals(true, intersection instanceof Line);
        assertEquals(true, line1.equals(intersection));
    }

    @Test
    public void testFindIntersectionParallel() throws Exception {
        Line line1 = new Line(5, -1, 10);
        Line line2 = new Line(15, -3, 3);

        assertEquals(null, LinesIntersection.findIntersection(line1, line2));
    }

    @Test
    public void testFindIntersectionRandom() throws Exception {
        Random rand = new Random();

        for (int i = 0; i < RANDOM_COUNT; i++) {
            Line line1 = new Line(rand.nextDouble() * 200 - 100,
                            rand.nextDouble() * 200 - 100,
                            rand.nextDouble() * 200 - 100);
            Line line2 = new Line(rand.nextDouble() * 200 - 100,
                            rand.nextDouble() * 200 - 100,
                            rand.nextDouble() * 200 - 100);

            GeometricObject intersection = LinesIntersection.findIntersection(
                            line1, line2);
            assertEquals(true, intersection instanceof Point);
            Point p = (Point) intersection;

            assertEquals(true, line1.isPointOnLine(p));
            assertEquals(true, line2.isPointOnLine(p));
        }
    }
}
