package geometry2D;

/**
 * Created with IntelliJ IDEA.
 * User: ivan.bendyna
 * Date: 03.04.13
 */
public class Line {

    private float A;
    private float B;
    private float C;

    public Line(float A, float B, float C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public static Line fromPoints(Point2D a, Point2D b){
        float A = a.getY() - b.getY();
        float B = b.getX() - a.getX();
        float C = a.getX() * b.getY() - a.getY() * b.getX();
        return new Line(A, B, C);
    }

    public float getC() {
        return C;
    }

    public float getA() {
        return A;
    }

    public float getB() {
        return B;
    }


    //TODO: check arithmetic overflow
    //TODO: unit tests
    //TODO: check whether point is on line
}
