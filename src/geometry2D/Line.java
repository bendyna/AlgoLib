
package geometry2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: ivan.bendyna Date: 03.04.13
 */
public class Line extends GeometricObject {

    private double A;
    private double B;
    private double C;

    public Line(double A, double B, double C) {
        if (A == 0 && B == 0) {
            throw new IllegalArgumentException(
                            "Can't create line. A and B = 0.");
        }
        this.A = A;
        this.B = B;
        this.C = C;
        normalize();
    }

    public Line(Line line) {
        this(line.A, line.B, line.C);
    }

    private void normalize() {
        double p = Math.sqrt(A * A + B * B);
        A /= p;
        B /= p;
        C /= p;
        if (A < 0) {
            A = -A;
            B = -B;
            C = -C;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            Line line = (Line) obj;
            return (Math.abs(A - line.getA()) < EPS)
                            && (Math.abs(B - line.getB()) < EPS)
                            && (Math.abs(C - line.getC()) < EPS);
        }
        else {
            return false;
        }
    }

    public static Line fromPoints(Point a, Point b) {
        if (a.equals(b)) {
            throw new IllegalArgumentException(
                            "Can't define line. Points are equal.");
        }
        double A = a.getY() - b.getY();
        double B = b.getX() - a.getX();
        double C = a.getX() * b.getY() - a.getY() * b.getX();
        return new Line(A, B, C);
    }

    public double getC() {
        return C;
    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }

    public boolean isPointOnLine(Point p) {
        return Math.abs(A * p.getX() + B * p.getY() + C) < EPS;
    }

    @Override
    public void shift(double dx, double dy) {
        C = C - B * dy - A * dx;
    }

    @Override
    public void rotate(double angleDegreeCcw) {
        Point p1;
        Point p2;
        if (A == 0) {
            p1 = new Point(0, -C / B);
            p2 = new Point(1, -C / B);
        }
        else {
            p1 = new Point(-C / A, 0);
            p2 = new Point((-C - B) / A, 1);
        }
        p1.rotate(angleDegreeCcw);
        p2.rotate(angleDegreeCcw);
        Line newLine = Line.fromPoints(p1, p2);
        A = newLine.getA();
        B = newLine.getB();
        C = newLine.getC();
    }

    @Override
    public List<GeometricObject> intersect(GeometricObject otherObject) {
        List<GeometricObject> result = new ArrayList<GeometricObject>();
        if (otherObject instanceof Line) {
            GeometricObject intersection = LinesIntersection.findIntersection(
                            this, (Line) otherObject);
            if (intersection != null) {
                result.add(intersection);
            }
        }

        return result;
    }

    public double pointShift(Point a) {
        double result = A * a.getX() + B * a.getY() + C;
        if (Math.abs(result) < EPS) {
            result = 0;
        }
        return result;
    }

    public double distanceToPoint(Point a) {
        return Math.abs(pointShift(a));
    }

    public boolean isParallel(Line otherLine) {
        return Math.abs(A * otherLine.getB() - B * otherLine.getA()) < EPS;
    }
}
