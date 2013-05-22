package geometry2D;/*
 * Date: 22.05.13 17:46
 * Author: ivan.bendyna
 */

import java.util.ArrayList;
import java.util.List;

import static geometry2D.GeometricObject.EPS;

public class LineCircleIntersection {
    public static List<Point> findIntersection(Line line, Circle circle) {
        List<Point> result = new ArrayList<Point>();
        line = new Line(line);
        circle = new Circle(circle);
        Point center = circle.getCenter();
        double dx = center.getX();
        double dy = center.getY();

        line.shift(-dx, -dy);
        circle.shift(-dx, -dy);

        double rad = circle.getRadius();
        double d = line.distanceToPoint(new Point(0, 0));
        if(d > rad + EPS){
            return result;
        }

        double A = line.getA();
        double B = line.getB();
        double C = line.getC();
        double r = A * A + B * B;
        Point D = new Point(-A * C / r, -B * C / r);
        if(Math.abs(d - circle.getRadius()) < EPS){
            D.shift(dx, dy);
            result.add(D);
            return result;
        }

        double f = Math.sqrt(rad * rad - d * d);
        double mult = Math.sqrt(f * f / r);

        result.add(new Point(D.getX() + B * mult, D.getY() - A * mult));
        result.add(new Point(D.getX() - B * mult, D.getY() + A * mult));
        result.get(0).shift(dx, dy);
        result.get(1).shift(dx, dy);
        return result;
    }
}
