package geometry2D;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 03.04.13
 */
public class DistancePoints {

    public static double squareDistance(Point a, Point b){
        float dx = a.getX() - b.getX();
        float dy = a.getY() - b.getY();
        return dx * dx + dy * dy;
    }

    public static double distance(Point a, Point b){
        return Math.sqrt(squareDistance(a, b));
    }
    //TODO: check arithmetic overflow
    //TODO: unit tests
}
