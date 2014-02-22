package geometry3D;

/**
 * User: capitan
 * Date: 2/21/14
 * Time: 11:25 PM
 */
public class Point extends GeometricObject{
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point p) {
        x = p.x;
        y = p.y;
        z = p.z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double squareDistance(Point otherPoint) {
        return (x - otherPoint.x) * (x - otherPoint.x) + (y - otherPoint.y)
                * (y - otherPoint.y) + (z - otherPoint.z) * (z - otherPoint.z);
    }

    public double distance(Point otherPoint) {
        return Math.sqrt(squareDistance(otherPoint));
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)) {
            return false;
        }
        Point p = (Point) obj;
        return Math.abs(x - p.x) < EPS &&
                Math.abs(y - p.y) < EPS &&
                Math.abs(z - p.z) < EPS;
    }

    @Override
    public void shift(double dx, double dy, double dz) {
        x += dx;
        y += dy;
        z += dz;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(x);
        int xh =  (int)(bits ^ (bits >>> 32));
        bits = Double.doubleToLongBits(y);
        int yh =  (int)(bits ^ (bits >>> 32));
        bits = Double.doubleToLongBits(z);
        int zh =  (int)(bits ^ (bits >>> 32));
        return xh + 31 * (yh + 31 * zh);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
