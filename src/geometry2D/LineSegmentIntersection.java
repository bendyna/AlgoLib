
package geometry2D;/*
 * Date: 18.05.13 16:39
 * Author: ivan.bendyna
 */

public class LineSegmentIntersection {

    public static GeometricObject findIntersection(Line line, Segment segment) {
        if (line.isPointOnLine(segment.getA())
                        && line.isPointOnLine(segment.getB())) {
            return segment;
        }
        if (line.isPointOnLine(segment.getA())) {
            return segment.getA();
        }
        if (line.isPointOnLine(segment.getB())) {
            return segment.getB();
        }
        if (line.pointShift(segment.getA()) * line.pointShift(segment.getB()) <= 0) {
            return LinesIntersection.findIntersection(line,
                            segment.expandToLine());
        }
        else {
            return null;
        }
    }

}
