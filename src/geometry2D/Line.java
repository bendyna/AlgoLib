package geometry2D;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 03.04.13
 */
public class Line {

    private final static double EPS = 0.00000000001;

    private double A;
    private double B;
    private double C;

    public Line(double A, double B, double C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public static Line fromPoints(Point a, Point b){
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

    public boolean isPointOnLine(Point p){
        return Math.abs(A * p.getX() + B * p.getY() + C) < EPS;
    }

}
