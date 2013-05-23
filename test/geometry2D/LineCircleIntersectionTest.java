package geometry2D;/*
 * Date: 22.05.13 18:30
 * Author: ivan.bendyna
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static geometry2D.GeometricObject.EPS;

import java.util.List;
import java.util.Random;

public class LineCircleIntersectionTest {
    private final static int COUNT_RANDOM = 10000;
    private Random random = new Random();
    @Test
    public void testIntersections(){
        Circle circle = new Circle(new Point(3, 3), 2);
        Line line1 = new Line(0, 1, -4);
        Line line2 = new Line(0, 1, -5);
        Line line3 = new Line(0, 1, -6);

        assertEquals(0, LineCircleIntersection.findIntersection(line3, circle).size());
        assertEquals(1, LineCircleIntersection.findIntersection(line2, circle).size());
        assertEquals(new Point(3, 5), LineCircleIntersection.findIntersection(line2, circle).get(0));
        assertEquals(2, LineCircleIntersection.findIntersection(line1, circle).size());
    }
    @Test
    public void testRandomIntersections(){
        for(int i = 0; i < COUNT_RANDOM; i++){
            Circle circle = new Circle(new Point(getRandom(-100, 100), getRandom(-100, 100)), getRandom(-30, 30));
            Line line = new Line(getRandom(-10, 10), getRandom(-10, 10), getRandom(-10, 10));
            List<Point> points = LineCircleIntersection.findIntersection(line, circle);
            if(points.size() == 0){
                assertEquals(true, line.distanceToPoint(circle.getCenter()) > circle.getRadius() + EPS);
            }
            else{
                for(Point p : points){
                    assertEquals(true, line.isPointOnLine(p));
                    assertEquals(circle.getRadius(), p.distance(circle.getCenter()), EPS);
                }
            }
        }
    }

    private double getRandom(double from, double to){
        return random.nextDouble() * (to - from) + from;
    }

//    @Test
//    public void testIntersection(){
//        Circle circle = new Circle(new Point(-0.8335687404848375, 2.14013012517446), 2.2826941446118294);
//        Line line = new Line(0.8385029388233478, 0.5448970743035871, -0.7325645171652329);
//
//        LineCircleIntersection.findIntersection(line,  circle);
//    }
}
