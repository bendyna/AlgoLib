
package geometry2D;

/**
 * Created with IntelliJ IDEA. User: ivan.bendyna Date: 15.04.13
 */

public class LinesIntersection {

    public static GeometricObject findIntersection(Line line1, Line line2) {

        if (line1.equals(line2)) {
            return line1;
        }

        if (line1.isParallel(line2)) {
            return null;
        }

        double D = line1.getA() * line2.getB() - line1.getB() * line2.getA();

        double x = line1.getB() * line2.getC() - line1.getC() * line2.getB();
        x = x / D;
        double y = line1.getC() * line2.getA() - line1.getA() * line2.getC();
        y = y / D;
        return new Point(x, y);
    }
}
