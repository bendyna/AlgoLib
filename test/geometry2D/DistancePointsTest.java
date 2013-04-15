package geometry2D;

import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 10.04.13
 */
public class DistancePointsTest {

    private final static double EPS = 0.00000000001;

    @Test
    public void testSquareDistance() throws Exception {
        Point a = new Point(4, 3);
        Point b = new Point(0, 0);

        assertEquals(25, DistancePoints.squareDistance(a, b), EPS);

        a = new Point(4, 3);
        b = new Point(4, 3);

        assertEquals(0, DistancePoints.squareDistance(a, b), EPS);

        a = new Point(4, 4);
        b = new Point(4, 3);

        assertEquals(1, DistancePoints.squareDistance(a, b), EPS);

        a = new Point(4, 2);
        b = new Point(2, 4);

        assertEquals(8, DistancePoints.squareDistance(a, b), EPS);
    }

    @Test
    public void testDistance() throws Exception {
        Point a = new Point(4, 3);
        Point b = new Point(0, 0);

        assertEquals(5, DistancePoints.distance(a, b), 0.0);
    }
}
