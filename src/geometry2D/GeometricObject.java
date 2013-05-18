
package geometry2D;/*
 * Date: 18.05.13 14:21
 * Author: ivan.bendyna
 */

import java.util.List;

public abstract class GeometricObject {

    public final static double EPS = 0.00000001;

    public abstract void shift(double dx, double dy);

    public abstract void rotate(double angleDegreeCcw);

    public void rotate(Point pivot, double angleDegreeCcw) {
        shift(-pivot.getX(), -pivot.getY());
        rotate(angleDegreeCcw);
        shift(pivot.getX(), pivot.getY());
    }

    public abstract List<GeometricObject> intersect(GeometricObject otherObject);
}
