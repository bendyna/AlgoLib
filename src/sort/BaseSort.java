package sort;

/*
 * Date: 06.09.13 14:08
 * Author: ivan.bendyna
 */

/**
 * Base class for other sorts. Redirects overloaded methods to most complete method, and there is no
 * need to implement it in sorts every time.
 */
public abstract class BaseSort implements Sort {

    /**
     * {@inheritDoc}
     */
    @Override
    public void sort(long[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sort(long[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sort(long[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sort(Object[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sort(Object[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sort(Object[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }
}
