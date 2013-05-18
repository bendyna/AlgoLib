package geometry2D;/*
 * Date: 18.05.13 14:21
 * Author: ivan.bendyna
 */

import java.util.List;

public abstract class GeometricObject {
    public abstract void shift(double dx, double dy);
    public abstract void rotate(double angleDegreeCcw);
    public void rotate(Point pivot, double angleDegreeCcw){
        shift(-pivot.getX(), -pivot.getY());
        rotate(angleDegreeCcw);
        shift(pivot.getX(), pivot.getY());
    }
    public abstract List<Point> intersect(GeometricObject otherObject);
}
