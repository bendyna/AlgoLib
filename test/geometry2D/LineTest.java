
package geometry2D;

import static geometry2D.GeometricObject.EPS;
import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: ivan.bendyna Date: 10.04.13
 */
public class LineTest {

    private final static int RANDOM_COUNT = 10000;

    @Test
    public void testIsPointOnLine() throws Exception {
        Line line = new Line(2, 1, 5);

        assertEquals(true, line.isPointOnLine(new Point(-2.5f, 0)));
        assertEquals(true, line.isPointOnLine(new Point(0, -5)));
        assertEquals(false, line.isPointOnLine(new Point(16, 0)));
        assertEquals(false, line.isPointOnLine(new Point(0, 0)));
        assertEquals(true, line.isPointOnLine(new Point(-3, 1)));
    }

    @Test
    public void testFromPoints() throws Exception {
        Point a = new Point(10, 20);
        Point b = new Point(7, 7);

        testLineFromPoints(a, b);
    }

    private void testLineFromPoints(Point a, Point b) {
        Line line = Line.fromPoints(a, b);
        assertEquals(true, line.isPointOnLine(a));
        assertEquals(true, line.isPointOnLine(b));
    }

    @Test
    public void testFromPointsRandom() throws Exception {
        Random rand = new Random();

        for (int i = 0; i < RANDOM_COUNT; i++) {
            Point a = new Point(rand.nextDouble() * 100 - 50,
                            rand.nextDouble() * 100 - 50);
            Point b = new Point(rand.nextDouble() * 100 - 50,
                            rand.nextDouble() * 100 - 50);

            testLineFromPoints(a, b);
        }
    }

    @Test
    public void testShift() {
        Line line = Line.fromPoints(new Point(4, 6), new Point(-10, 3));
        line.shift(-3, 2);

        assertEquals(true, line.isPointOnLine(new Point(1, 8)));
        assertEquals(true, line.isPointOnLine(new Point(-13, 5)));
    }

    @Test
    public void testIntersection() {
        Line line = Line.fromPoints(new Point(5, 6), new Point(-10, 3));
        Line line1 = Line.fromPoints(new Point(5, 6), new Point(-10, 3));

        assertEquals(0, line.intersect(line1).size());

        Line line2 = Line.fromPoints(new Point(3, 6), new Point(-12, 3));

        assertEquals(0, line.intersect(line2).size());

        Line line3 = Line.fromPoints(new Point(-6, 5), new Point(-4, 3));

        assertEquals(1, line.intersect(line3).size());
        assertEquals(-5.0, line.intersect(line3).get(0).getX(), EPS);
        assertEquals(4.0, line.intersect(line3).get(0).getY(), EPS);
    }

    @Test
    public void testRotate() {
        Line line = Line.fromPoints(new Point(1, 4), new Point(5, 6));
        line.rotate(90);

        assertEquals(true, line.isPointOnLine(new Point(-5, 3)));

        line.rotate(new Point(-5, 3), -90);

        assertEquals(true, line.isPointOnLine(new Point(-3, 4)));
        assertEquals(false, line.isPointOnLine(new Point(-3, 3)));
    }

    @Test
    public void testEquality() {
        Line line1 = new Line(5, 10, 25);
        Line line2 = new Line(-1, -2, -5);
        Line line3 = new Line(0, -2, -5);

        assertEquals(true, line1.equals(line2));
        assertEquals(false, line1.equals(line3));

        Line line4 = Line.fromPoints(new Point(2, 4), new Point(3, 6));
        Line line5 = Line.fromPoints(new Point(3, 1), new Point(5, 0));
        line5.rotate(new Point(1, 2), 90);

        assertEquals(true, line4.equals(line5));
    }
}
