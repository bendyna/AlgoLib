package geometry3D;

/**
 * User: capitan
 * Date: 2/21/14
 * Time: 11:27 PM
 */
public abstract class GeometricObject {
    public final static double EPS = 0.00000001;

    public abstract void shift(double dx, double dy, double dz);
}
