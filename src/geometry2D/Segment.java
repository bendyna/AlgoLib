
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
        this.a = new Point(a);
        this.b = new Point(b);
        if (a.compareTo(b) > 0) {
            Point t = a;
            a = b;
            b = t;
        }
    }

    // TODO: getAX, getAY, getBX, getBY
    public Point getA() {
        return new Point(a);
    }

    public Point getB() {
        return new Point(b);
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

    public boolean isPointOnSegment(Point p) {
        double smallerX = Math.min(a.getX(), b.getX());
        double biggerX = Math.max(a.getX(), b.getX());
        double smallerY = Math.min(a.getY(), b.getY());
        double biggerY = Math.max(a.getY(), b.getY());
        if (p.getX() < smallerX - EPS || p.getX() > biggerX + EPS
                        || p.getY() < smallerY - EPS
                        || p.getY() > biggerY + EPS) {
            return false;
        }
        return expandToLine().isPointOnLine(p);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Segment)) {
            return false;
        }
        Segment anotherSegment = (Segment) obj;
        return (getA().equals(anotherSegment.getA()) && getB().equals(
                        anotherSegment.getB()))
                        || (getB().equals(anotherSegment.getA()) && getA()
                                        .equals(anotherSegment.getB()));
    }

    public boolean isSegmentsRectsIntersect(Segment otherSegment) {
        return intersection1d(a.getX(), b.getX(), otherSegment.a.getX(),
                        otherSegment.b.getX())
                        && intersection1d(a.getY(), b.getY(),
                                        otherSegment.a.getY(),
                                        otherSegment.b.getY());
    }

    // is [a, b] intersects [c, d]
    private boolean intersection1d(double a, double b, double c, double d) {
        if (a > b) {
            double t = a;
            a = b;
            b = t;
        }
        if (c > d) {
            double t = c;
            c = d;
            d = t;
        }
        return Math.max(a, c) <= Math.min(b, d) + EPS;
    }

}
