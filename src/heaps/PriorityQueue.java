package heaps;

/**
 * User: capitan
 * Date: 9/11/13
 * Time: 10:41 PM
 */
@SuppressWarnings("unused")
public interface PriorityQueue<K extends Comparable<K>, V> {

    public void insert(K key, V value);
    public void remove(K key);
    public V getPrioritizedElement();
    public V peekPrioritizedElement();

}
