package geometry2D;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 03.04.13
 */
public class DistancePoints {
    public static double distance(Point2D a, Point2D b){
        float dx = a.getX() - b.getX();
        float dy = a.getY() - b.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    //TODO: check arithmetic overflow
    //TODO: unit tests
}
