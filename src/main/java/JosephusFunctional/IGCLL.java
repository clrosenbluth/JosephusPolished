package JosephusFunctional;

/**
 * Generic Circular Linked List Interface
 *
 * @param <T> generic type
 */
public interface IGCLL<T>
{

    /**
     * add new element at the "head" of the circular list (new first element
     * pointing to the previous first)
     *
     * @param value
     */
    void addFirst(T value);

    /**
     * check if the given value is contained in the list
     *
     * @param value - value to check (of type T)
     * @return true if yes; false if no.
     */
    boolean contains(T value);

    /**
     * remove all elements from the list
     */
    void clear();

    /**
     * determines if the list is empty
     *
     * @return true of yes; false if no
     */
    boolean isEmpty();

    /**
     * @return number of nodes on the list
     */
    int size();

    /**
     * remove the node with the specified value if more than one node contains
     * the given value, then remove only the first occurrence
     *
     * @param value of type T - to be removed
     * @return true, if success; false, if no such value on the list
     */
    boolean remove(T value);

    /**
     * return the value of the first node
     * @return null, if the list is empty
     */
    T getFirst();

    /**
     * advanced the first element designation "count" number of nodes forward
     * loop if necessary (count > size)
     * @param count : int - number of places to advance first
     */
    void advance(int count);
}

