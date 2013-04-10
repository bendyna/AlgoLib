package geometry2D;

import static junit.framework.Assert.*;
import org.junit.Test;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 10.04.13
 */
public class LineTest {

    private final static int RANDOM_COUNT = 10000;

    @Test
    public void testIsPointOnLine() throws Exception {
        Line line = new Line(2, 1, 5);

        assertEquals(line.isPointOnLine(new Point(-2.5f, 0)), true);
        assertEquals(line.isPointOnLine(new Point(0, -5)), true);
        assertEquals(line.isPointOnLine(new Point(16, 0)), false);
        assertEquals(line.isPointOnLine(new Point(0, 0)), false);
        assertEquals(line.isPointOnLine(new Point(-3, 1)), true);
    }

    @Test
    public void testFromPoints() throws Exception {
        Point a = new Point(10, 20);
        Point b = new Point(7, 7);

        testLineFromPoints(a, b);
    }

    private void testLineFromPoints(Point a, Point b){
        Line line = Line.fromPoints(a, b);
        assertEquals(line.isPointOnLine(a), true);
        assertEquals(line.isPointOnLine(b), true);
    }

    @Test
    public void testFromPointsRandom() throws Exception {
        Random rand = new Random();

        for(int i = 0; i < RANDOM_COUNT; i++){
            Point a = new Point(rand.nextDouble() * 100 - 50, rand.nextDouble() * 100 - 50);
            Point b = new Point(rand.nextDouble() * 100 - 50, rand.nextDouble() * 100 - 50);

            System.out.println(a.getX() + ", " + a.getY() + "; " + b.getX() + ", " + b.getY());
            testLineFromPoints(a, b);
        }
    }
}
