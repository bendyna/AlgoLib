package geometry2D;

import static junit.framework.Assert.*;

import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;
import org.junit.Test;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 15.04.13
 */
public class LinesIntersectionTest {

    private final static int RANDOM_COUNT = 10000;

    @Test
    public void testFindIntersectionParallel() throws Exception {
        Line line1 = new Line(5, -1, 10);
        Line line2 = new Line(15, -3, 3);

        assertEquals(null, LinesIntersection.findIntersection(line1, line2));
    }

    @Test
    public void testFindIntersectionRandom() throws Exception {
        Random rand = new Random();

        for(int i = 0; i < RANDOM_COUNT; i++){
            Line line1 = new Line(rand.nextDouble() * 200 - 100, rand.nextDouble() * 200 - 100, rand.nextDouble() * 200 - 100);
            Line line2 = new Line(rand.nextDouble() * 200 - 100, rand.nextDouble() * 200 - 100, rand.nextDouble() * 200 - 100);

            Point p = LinesIntersection.findIntersection(line1, line2);

            assertEquals(true, line1.isPointOnLine(p));
            assertEquals(true, line2.isPointOnLine(p));
        }
    }
}
