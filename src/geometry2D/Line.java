package geometry2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 03.04.13
 */
public class Line extends GeometricObject{

    private final static double EPS = 0.00000001;

    private double A;
    private double B;
    private double C;

    public Line(double A, double B, double C){
        if(A == 0 && B == 0){
            throw new IllegalArgumentException("Can't create line. A and B = 0.");
        }
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public static Line fromPoints(Point a, Point b){
        if(a.equals(b)){
            throw new IllegalArgumentException("Can't define line. Points are equal.");
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

    public boolean isPointOnLine(Point p){
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
        if(A == 0){
            p1 = new Point(0, -C / B);
            p2 = new Point(1, -C / B);
        }
        else{
            p1 = new Point(-C / A, 0);
            p2 = new Point((-C - B)/ A , 1);
        }
        p1.rotate(angleDegreeCcw);
        p2.rotate(angleDegreeCcw);
        Line newLine = Line.fromPoints(p1, p2);
        A = newLine.getA();
        B = newLine.getB();
        C = newLine.getC();
    }

    @Override
    public List<Point> intersect(GeometricObject otherObject) {
        List<Point> result = new ArrayList<Point>();
        if(otherObject instanceof Line){
            Point p = LinesIntersection.findIntersection(this, (Line) otherObject);
            if(p != null){
                result.add(p);
            }
        }

        return result;
    }
}
