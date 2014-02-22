package geometry3D;

/**
 * User: capitan
 * Date: 2/21/14
 * Time: 11:18 PM
 */
public class Line extends GeometricObject {

    // x = p.x + at
    // y = p.y + bt
    // z = p.z + ct

    private Point p;
    private double a;
    private double b;
    private double c;

    public Line(Point p1, Point p2) {
        if(p1.equals(p2)) {
            throw new IllegalArgumentException("Points are equal.");
        }
        p = new Point(p1);
        a = p2.getX() - p1.getX();
        b = p2.getY() - p1.getY();
        c = p2.getZ() - p1.getZ();
    }

    public Line(Point p, double a, double b, double c) {
        if(Math.abs(a) < EPS && Math.abs(b) < EPS && Math.abs(c) < EPS) {
            throw new IllegalArgumentException();
        }
        this.p = new Point(p);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isPointOnLine(Point p) {
        if(p.equals(this.p)) {
            return true;
        }
        double dx = p.getX() - this.p.getX();
        double t = dx / a;
        if(Double.isInfinite(t)) {
            return false;
        }
        if(Double.isNaN(t)) {
            double dy = p.getY() - this.p.getY();
            t = dy / b;
            if(Double.isInfinite(t)) {
                return false;
            }
            if(Double.isNaN(t)) {
                double dz = p.getZ() - this.p.getZ();
                t = dz / c;
                if(Double.isInfinite(t)) {
                    return false;
                }
            }
        }
        double x = this.p.getX() + t * a;
        double y = this.p.getY() + t * b;
        double z = this.p.getZ() + t * c;
        return Math.abs(x - p.getX()) < EPS &&
                Math.abs(y - p.getY()) < EPS &&
                Math.abs(z - p.getZ()) < EPS;
    }

    // null - no intersect
    // Nan, NaN, NaN - lines are equal
    public Point intersectLine(Line otherLine) {
        double t;
        if(Math.abs(otherLine.a) < EPS) {
            if(Math.abs(a) < EPS) {
                if(Math.abs(p.getX() - otherLine.p.getX()) < EPS) {
                    double k = b;
                    double l = p.getY() - otherLine.p.getY();
                    k /= otherLine.b;
                    l /= otherLine.b;
                    k *= otherLine.c;
                    l *= otherLine.c;
                    k -= c;
                    l += otherLine.p.getZ() - p.getZ();
                    t = -l / k;
                    if(Double.isInfinite(t)) {
                        return null;
                    }
                    if(Double.isNaN(t)) {
                        return new Point(Double.NaN, Double.NaN, Double.NaN);
                    }
                }
                else {
                    return null;
                }
            }
            else {
                t = (otherLine.p.getX() - p.getX()) / a;
            }
        }
        else {
            double k = a;
            double l = p.getX() - otherLine.p.getX();
            k /= otherLine.a;
            l /= otherLine.a;
            k *= otherLine.b;
            l *= otherLine.b;
            k -= b;
            l += otherLine.p.getY() - p.getY();
            t = -l / k;
            if(Double.isInfinite(t)) {
                return null;
            }
            if(Double.isNaN(t)) {
                k = a;
                l = p.getX() - otherLine.p.getX();
                k /= otherLine.a;
                l /= otherLine.a;
                k *= otherLine.c;
                l *= otherLine.c;
                k -= c;
                l += otherLine.p.getZ() - p.getZ();
                t = -l / k;
                if(Double.isInfinite(t)) {
                    return null;
                }
                if(Double.isNaN(t)) {
                    return new Point(Double.NaN, Double.NaN, Double.NaN);
                }
            }
        }
        double x = p.getX() + a * t;
        double y = p.getY() + b * t;
        double z = p.getZ() + c * t;
        Point p = new Point(x, y, z);
        if(otherLine.isPointOnLine(p)) {
            return p;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Line)) {
            return false;
        }
        Line otherLine = (Line) obj;
        Point p1 = new Point(p.getX() + a, p.getY() + b, p.getZ() + c);
        return otherLine.isPointOnLine(p) && otherLine.isPointOnLine(p1);
    }

    @Override
    public void shift(double dx, double dy, double dz) {
        p.shift(dx, dy, dz);
    }

    @Override
    public String toString() {
        String s = "";
        s += p.getX() + " + " + a + "t\n";
        s += p.getY() + " + " + b + "t\n";
        s += p.getZ() + " + " + c + "t\n";
        return s;
    }
}
