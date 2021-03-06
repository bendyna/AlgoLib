/*
 * Filename: Polygon.java
 * Date: May 22, 2013 11:24:10 PM
 * Author: Bendyna Ivan
 */

package geometry2D;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Polygon extends GeometricObject {

    private int N;
    private Segment[] segments;

    public Polygon(Point[] points) {
        if (points.length < 3) {
            throw new IllegalArgumentException(
                            "There can't be less than 3 points in Polygon.");
        }
        N = points.length;
        segments = new Segment[N];
        for (int i = 0; i < N - 1; i++) {
            segments[i] = new Segment(points[i], points[i + 1]);
        }
        segments[N - 1] = new Segment(points[N - 1], points[0]);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int distij = Math.abs(i - j);
                if (distij == 1 || distij == N - 1) {
                    if (SegmentsIntersection.findIntersection(segments[i],
                                    segments[j]) instanceof Segment) {
                        throw new IllegalArgumentException(
                                        "Two segments lay on each other.");
                    }
                }
                else if (distij != 0) {
                    if (SegmentsIntersection.findIntersection(segments[i],
                                    segments[j]) != null) {
                        throw new IllegalArgumentException(
                                        "Two segments intersect.");
                    }
                }
            }
        }
    }

    @Override
    public void shift(double dx, double dy) {
        for (int i = 0; i < N; i++) {
            segments[i].shift(dx, dy);
        }
    }

    @Override
    public void rotate(double angleDegreeCcw) {
        for (int i = 0; i < N; i++) {
            segments[i].rotate(angleDegreeCcw);
        }
    }

    // TODO: improve intersection with Point

    @Override
    public List<GeometricObject> intersect(GeometricObject otherObject) {
        List<GeometricObject> result = new ArrayList<GeometricObject>();
        Set<Point> setPoints = new HashSet<Point>();
        for (int i = 0; i < N; i++) {
            List<GeometricObject> intersection = segments[i]
                            .intersect(otherObject);
            for (GeometricObject go : intersection) {
                if (go instanceof Point) {
                    setPoints.add((Point) go);
                }
                else {
                    result.add(go);
                }
            }
        }
        for (Point p : setPoints) {
            boolean b = true;
            for (GeometricObject go : result) {
                if (!go.intersect(p).isEmpty()) {
                    b = false;
                    break;
                }
            }
            if (b) {
                result.add(p);
            }
        }
        return result;
    }
}
