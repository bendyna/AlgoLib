package geometry2D;/*
 * Date: 22.05.13 17:40
 * Author: ivan.bendyna
 */

import java.util.List;

public class Circle extends GeometricObject{

    private Point center;
    private double radius;

    public Circle(Point center, double radius){
        this.center = new Point(center);
        this.radius = radius;
    }

    public Circle(Circle circle){
        this(circle.center, circle.radius);
    }

    public Point getCenter(){
        return new Point(center);
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public void shift(double dx, double dy) {
        center.shift(dx, dy);
    }

    @Override
    public void rotate(double angleDegreeCcw) {
        center.rotate(angleDegreeCcw);
    }

    @Override
    public List<GeometricObject> intersect(GeometricObject otherObject) {
        return null;
    }
}
