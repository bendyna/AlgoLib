
package geometry2D;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created with IntelliJ IDEA. User: ivan.bendyna Date: 15.04.13
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ LineTest.class, LinesIntersectionTest.class,
        PointTest.class, SegmentTest.class, LineSegmentIntersectionTest.class,
        SegmentsIntersectionTest.class, LineCircleIntersectionTest.class,
        PolygonTest.class, CirclesIntersectionTest.class })
public class AllTests {}
