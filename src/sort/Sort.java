package sort;

/*
 * Date: 06.09.13 13:19
 * Author: ivan.bendyna
 */

/**
 * The root interface in the sort hierarchy. Can sort the specified range of array of long or Object(must be Comparable)
 * into specified order. Some sorts are stable and others unstable. Some are fast  - &#920;(NlgN), others are not.
 *
 * @author Ivan Bendyna
 */

@SuppressWarnings("unused")
public interface Sort {

    /**
     * Sorts the specified array of longs into ascending numerical order.
     *
     * @param array the array to be sorted
     *
     * @throws NullPointerException if the specified array is null
     */
    public void sort(long[] array);

    /**
     * Sorts the specified range of the specified array of longs into ascending numerical order.
     * The range to be sorted extends from index <tt>from</tt> to index <tt>to</tt>, inclusive.
     *
     * @param array the array to be sorted
     * @param from the index of the first element (inclusive) to be sorted
     * @param to the index of the last element (inclusive) to be sorted
     *
     * @throws NullPointerException if the specified array is null
     * @throws ArrayIndexOutOfBoundsException if <tt>from &lt; 0</tt> or
     *	       <tt>to &gt;= a.length</tt>
     * @throws IllegalArgumentException if <tt>from < to</tt>
     */
    public void sort(long[] array, int from, int to);

    /**
     * Sorts the specified array of longs into specified numerical order.
     *
     * @param array the array to be sorted
     * @param ascending the order of sorting
     *
     * @throws NullPointerException if the specified array is null
     */
    public void sort(long[] array, boolean ascending);

    /**
     * Sorts the specified range of the specified array of longs into specified numerical order.
     * The range to be sorted extends from index <tt>from</tt> to index <tt>to</tt>, inclusive.
     *
     * @param array the array to be sorted
     * @param ascending the order of sorting
     * @param from the index of the first element (inclusive) to be sorted
     * @param to the index of the last element (inclusive) to be sorted
     *
     * @throws NullPointerException if the specified array is null
     * @throws ArrayIndexOutOfBoundsException if <tt>from &lt; 0</tt> or
     *	       <tt>to &gt;= a.length</tt>
     * @throws IllegalArgumentException if <tt>from < to</tt>
     */
    public void sort(long[] array, boolean ascending, int from, int to);

     /**
     * Sorts the specified array of objects into ascending order, according to the
     * {@linkplain Comparable natural ordering} of its elements.  All elements in the array
     * must implement the {@link Comparable} interface.  Also, all elements in the array
     * must be <i>mutually comparable</i> (that is, <tt>e1.compareTo(e2)</tt> must not throw
     * a <tt>ClassCastException</tt> for any elements <tt>e1</tt> and <tt>e2</tt> in the array).
     *
     * @param array the array to be sorted
     *
     * @throws ClassCastException if the array contains elements that are not <i>mutually comparable</i>.
     * @throws NullPointerException if the specified array is null
     */
    public void sort(Object[] array);

    /**
     * Sorts the specified range of the specified array of objects into ascending order, according to the
     * {@linkplain Comparable natural ordering} of its elements.
     * The range to be sorted extends from index <tt>from</tt> to index <tt>to</tt>, inclusive.
     * All elements in the array must implement the {@link Comparable} interface.  Also, all elements
     * in the array must be <i>mutually comparable</i> (that is, <tt>e1.compareTo(e2)</tt> must not throw
     * a <tt>ClassCastException</tt> for any elements <tt>e1</tt> and <tt>e2</tt> in the array).
     *
     * @param array the array to be sorted
     * @param from the index of the first element (inclusive) to be sorted
     * @param to the index of the last element (inclusive) to be sorted
     *
     * @throws ClassCastException if the array contains elements that are not <i>mutually comparable</i>.
     * @throws NullPointerException if the specified array is null
     * @throws ArrayIndexOutOfBoundsException if <tt>from &lt; 0</tt> or
     *	       <tt>to &gt;= a.length</tt>
     * @throws IllegalArgumentException if <tt>from < to</tt>
     */
    public void sort(Object[] array, int from, int to);

    /**
     * Sorts the specified array of objects into specified order, according to the
     * {@linkplain Comparable natural ordering} of its elements.  All elements in the array
     * must implement the {@link Comparable} interface.  Also, all elements in the array
     * must be <i>mutually comparable</i> (that is, <tt>e1.compareTo(e2)</tt> must not throw
     * a <tt>ClassCastException</tt> for any elements <tt>e1</tt> and <tt>e2</tt> in the array).
     *
     * @param array the array to be sorted
     * @param ascending the order of sorting
     *
     * @throws ClassCastException if the array contains elements that are not <i>mutually comparable</i>.
     * @throws NullPointerException if the specified array is null
     */
    public void sort(Object[] array, boolean ascending);

    /**
     * Sorts the specified range of the specified array of objects into specified order, according to the
     * {@linkplain Comparable natural ordering} of its elements.
     * The range to be sorted extends from index <tt>from</tt> to index <tt>to</tt>, inclusive.
     * All elements in the array must implement the {@link Comparable} interface.  Also, all elements
     * in the array must be <i>mutually comparable</i> (that is, <tt>e1.compareTo(e2)</tt> must not throw
     * a <tt>ClassCastException</tt> for any elements <tt>e1</tt> and <tt>e2</tt> in the array).
     *
     * @param array the array to be sorted
     * @param ascending the order of sorting
     * @param from the index of the first element (inclusive) to be sorted
     * @param to the index of the last element (inclusive) to be sorted
     *
     * @throws ClassCastException if the array contains elements that are not <i>mutually comparable</i>.
     * @throws NullPointerException if the specified array is null
     * @throws ArrayIndexOutOfBoundsException if <tt>from &lt; 0</tt> or
     *	       <tt>to &gt;= a.length</tt>
     * @throws IllegalArgumentException if <tt>from < to</tt>
     */
    public void sort(Object[] array, boolean ascending, int from, int to);

    /**
     * Returns <tt>true</tt> if sort is &#920;(NlgN).
     *
     * @return if sort is &#920;(NlgN)
     */
    public boolean isNlgN();

    /**
     * Returns <tt>true</tt> if sort is stable.
     *
     * @return if sort is stable
     */
    public boolean isStable();
}
