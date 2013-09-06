package sort;/*
 * Date: 06.09.13 14:08
 * Author: ivan.bendyna
 */

public abstract class BaseSort implements Sort {

    @Override
    public void sort(long[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(long[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(long[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    @Override
    public void sort(int[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(int[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(int[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    @Override
    public void sort(char[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(char[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(char[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    @Override
    public void sort(short[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(short[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(short[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    @Override
    public void sort(byte[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(byte[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(byte[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    @Override
    public void sort(double[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(double[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(double[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    @Override
    public void sort(float[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(float[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(float[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    @Override
    public void sort(Object[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(Object[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(Object[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }
}
