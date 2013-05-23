package geometry2D;/*
 * Date: 23.05.13 18:30
 * Author: ivan.bendyna
 */

import java.util.ArrayList;
import java.util.List;

//TODO: make all geometric objects immutable

public class CirclesIntersection {
    public static List<GeometricObject> findIntersection(Circle circle1, Circle circle2) {
        circle1 = new Circle(circle1);
        circle2 = new Circle(circle2);
        if(circle1.getCenter().equals(circle2.getCenter())){
            List<GeometricObject> result = new ArrayList<GeometricObject>();
            if(circle1.equals(circle2)){
                result.add(circle1);
            }
            return result;
        }
        else{
            double dx = circle1.getCenter().getX();
            double dy = circle1.getCenter().getY();
            circle1.shift(-dx, -dy);
            circle2.shift(-dx, -dy);
            double x = circle2.getCenter().getX();
            double y = circle2.getCenter().getY();
            double A = -2 * x;
            double B = -2 * y;
            double C = x * x + y * y + Math.pow(circle1.getRadius(), 2) - Math.pow(circle2.getRadius(), 2);
            Line line = new Line(A, B, C);
            List<GeometricObject> result = new ArrayList<GeometricObject>();
            for(Point p : LineCircleIntersection.findIntersection(line, circle1)){
                p.shift(dx, dy);
                result.add(p);
            }
            return result;
        }
    }
}
