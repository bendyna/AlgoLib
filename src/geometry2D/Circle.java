package geometry2D;/*
 * Date: 22.05.13 17:40
 * Author: ivan.bendyna
 */

import java.util.ArrayList;
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
    public boolean equals(Object obj) {
        if(!(obj instanceof Circle)){
            return false;
        }
        Circle otherCircle = (Circle) obj;
        return otherCircle.center.equals(center) && Math.abs(radius - otherCircle.radius) < EPS;
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
        List<GeometricObject> result = new ArrayList<GeometricObject>();
        if(otherObject instanceof Point){
            if(Math.abs(center.distance((Point) otherObject) - radius) < EPS){
                result.add(otherObject);
            }
        }
        else if(otherObject instanceof Line){
            result.addAll(LineCircleIntersection.findIntersection((Line) otherObject, this));
        }
        else if(otherObject instanceof Segment){
            List<Point> points = LineCircleIntersection.findIntersection(((Segment) otherObject).expandToLine(), this);
            for(Point p : points){
                if(((Segment) otherObject).isPointOnSegment(p)){
                    result.add(p);
                }
            }
        }
        else if(otherObject instanceof Circle){
            return CirclesIntersection.findIntersection(this, (Circle) otherObject);
        }
        else{
            return otherObject.intersect(this);
        }

        return result;
    }
}
