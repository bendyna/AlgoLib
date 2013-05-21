/*
 * Filename: SegmentsIntersection.java
 * Date: May 21, 2013 9:42:43 PM
 * Author: Bendyna Ivan
 */

package geometry2D;

//TODO: to package util
public class SegmentsIntersection {

    public static GeometricObject findIntersection(Segment segment1,
                    Segment segment2) {

        if (!segment1.isSegmentsRectsIntersect(segment2)) {
            return null;
        }
        Line line1 = segment1.expandToLine();
        Line line2 = segment2.expandToLine();

        if (!line1.isParallel(line2)) {
            Point p = (Point) line1.intersect(line2).get(0);
            if (segment1.isPointOnSegment(p) && segment2.isPointOnSegment(p)) {
                return p;
            }
            else {
                return null;
            }
        }
        else if (line1.equals(line2)) {
            Point start = segment1.getA();
            if (start.compareTo(segment2.getA()) < 0) {
                start = segment2.getA();
            }
            Point end = segment1.getB();
            if (end.compareTo(segment2.getB()) > 0) {
                end = segment2.getB();
            }
            if (!start.equals(end)) {
                return new Segment(start, end);
            }
            else {
                return start;
            }
        }
        else {
            return null;
        }
    }
}
