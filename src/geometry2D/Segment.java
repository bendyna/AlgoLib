
package geometry2D;/*
 * Date: 18.05.13 16:12
 * Author: ivan.bendyna
 */

import java.util.List;

public class Segment extends GeometricObject {

    private Point a;
    private Point b;

    public Segment(Point a, Point b) {
        if (a.equals(b)) {
            throw new IllegalArgumentException("Points are equal.");
        }
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public double length() {
        return a.distance(b);
    }

    @Override
    public void shift(double dx, double dy) {
        a.shift(dx, dy);
        b.shift(dx, dy);
    }

    @Override
    public void rotate(double angleDegreeCcw) {
        a.rotate(angleDegreeCcw);
        b.rotate(angleDegreeCcw);
    }

    @Override
    public List<GeometricObject> intersect(GeometricObject otherObject) {
        return null;
    }

    public Line expandToLine() {
        return Line.fromPoints(a, b);
    }
}
