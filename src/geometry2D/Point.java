package geometry2D;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 03.04.13
 */
public class Point {

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

    public void shift(double dx, double dy){
        x += dx;
        y += dy;
    }

    public void rotate(double angleDegreeCcw){
        double length = Math.sqrt(y * y + x * x);
        double currentAngle = Math.atan2(y, x) * 180.0 / Math.PI;
        currentAngle += angleDegreeCcw;
        currentAngle = currentAngle * Math.PI / 180;
        x = length * Math.cos(currentAngle);
        y = length * Math.sin(currentAngle);
    }

    public void rotate(Point pivot, double angleDegreeCcw){
        shift(-pivot.getX(), -pivot.getY());
        rotate(angleDegreeCcw);
        shift(pivot.getX(), pivot.getY());
    }

}