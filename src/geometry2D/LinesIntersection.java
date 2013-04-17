package geometry2D;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 15.04.13
 */
public class LinesIntersection {

    private final static double EPS = 0.000000001;

    public static Point findIntersection(Line line1, Line line2) {
        double D = line1.getA() * line2.getB() - line1.getB() * line2.getA();
        if (Math.abs(D) < EPS) {
            return null;
        }

        double x = line1.getB() * line2.getC() - line1.getC() * line2.getB();
        x = x / D;
        double y = line1.getC() * line2.getA() - line1.getA() * line2.getC();
        y = y / D;
        return new Point(x, y);
    }
}
