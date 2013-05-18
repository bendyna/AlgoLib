package geometry2D;/*
 * Date: 18.05.13 16:39
 * Author: ivan.bendyna
 */

public class LineSegmentIntersection {

    public static Point findIntersection(Line line, Segment segment) {
        if(line.pointShift(segment.getA()) * line.pointShift(segment.getB()) <= 0){
            return LinesIntersection.findIntersection(line, segment.expandToLine());
        }
        else{
            return null;
        }
    }


}
