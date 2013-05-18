package geometry2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 03.04.13
 */
public class Point extends GeometricObject{

    private final static double EPS = 0.00000001;

    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public void shift(double dx, double dy){
        x += dx;
        y += dy;
    }

    @Override
    public void rotate(double angleDegreeCcw){
        double length = Math.sqrt(y * y + x * x);
        double currentAngle = Math.atan2(y, x) * 180.0 / Math.PI;
        currentAngle += angleDegreeCcw;
        currentAngle = currentAngle * Math.PI / 180;
        x = length * Math.cos(currentAngle);
        y = length * Math.sin(currentAngle);
    }

    @Override
    public void rotate(Point pivot, double angleDegreeCcw){
        shift(-pivot.getX(), -pivot.getY());
        rotate(angleDegreeCcw);
        shift(pivot.getX(), pivot.getY());
    }

    @Override
    public List<Point> intersect(GeometricObject otherObject) {
        return new ArrayList<Point>();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point){
            Point otherPoint = (Point) obj;
            return (Math.abs(x - otherPoint.x) < EPS) && (Math.abs(y - otherPoint.y) < EPS);
        }
        else{
            return false;
        }
    }
}
