package JosephusFunctional;

/**
 * A class to implement a generic circular linked list
 * @param <T> the type to be placed in the linked list
 * @author chanarosenbluth
 */
public class GCLL<T> implements IGCLL<T>
{
    private static class Node<T>
    {
        T info;
        Node<T> next = null;

        public Node(T value)
        {
            info = value;
        }
    }

    Node<T> first = null;
    Node<T> last = null;

    /**
     * Add a value to the first spot in the list
     * @param value the value to be added
     */
    @Override
    public void addFirst(T value)
    {
        Node<T> node = new Node<>(value);
        if (first == null)
        {
            first = node;
            last = node;
            first.next = last;
            last.next = first;
        }
        else
        {
            node.next = first;
            first = node;
            last.next = first;
        }
    }

    /**
     * Check if a value exists in the list
     * @param value - value to check (of type T)
     * @return true if it exists, false if not
     */
    @Override
    public boolean contains(T value)
    {
        boolean contains = false;
        if (first != null)
        {
            Node<T> curr = first;
            do
            {
                if (curr.info.equals(value))
                {
                    contains = true;
                    break;
                }
                else
                {
                    curr = curr.next;
                }
            }
            while (curr != first);
        }
        return contains;
    }

    /**
     * Clear the list, leaving it empty
     */
    @Override
    public void clear()
    {
        first = null;
        last = null;
    }

    /**
     * Check if the list is empty
     * @return true if empty, false if not
     */
    @Override
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Get the size of the list
     * @return the size of the list, an integer
     */
    @Override
    public int size()
    {
        int size = 0;
        if (first != null)
        {
            Node<T> curr = first;
            do
            {
                ++size;
                curr = curr.next;
            }
            while (curr != first);
        }
        return size;
    }

    /**
     * Remove a value from the list
     * If there is more than one, only remove the first
     * @param value of type T - to be removed
     * @return true if the value was removed, false if it wasn't found
     */
    @Override
    public boolean remove(T value)
    {
        boolean success = false;
        if (first != null)
        {
            Node<T> curr = first;
            do
            {
                if (curr.next.info.equals(value))
                {
                    if (curr.next == first && curr == first)
                    {
                        first = null;
                        last = null;
                    }
                    else if (curr.next == first)
                    {
                        first = first.next;
                        last.next = last.next.next;
                    }
                    else
                    {
                        curr.next = curr.next.next;
                    }

                    success = true;
                    break;
                }
                else
                {
                    curr = curr.next;
                }
            }
            while (curr != first);
        }
        return success;
    }

    /**
     * Get the first value in the list
     * @return the first value in the list
     */
    @Override
    public T getFirst()
    {
        T firstValue = null;
        if (first != null)
        {
            firstValue = first.info;
        }
        return firstValue;
    }

    /**
     * Advance the "first" pointer the number of places specified
     * @param count : int - number of places to advance first
     */
    @Override
    public void advance(int count)
    {
        if (first != null)
        {
            for (int position = 0; position < count; ++position)
            {
                first = first.next;
                last = last.next;
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("first->");
        if (first != null)
        {
            // add the first in the list
            Node<T> curr = first;
            builder.append("|").append(curr.info).append("|");
            curr = curr.next;

            // add the rest in the list
            while (curr != first)
            {
                builder.append("->|").append(curr.info).append("|");
                curr = curr.next;
            }

            if (this.size() > 1)
            {
                // add the first again
                builder.append("->|").append(curr.info).append("|");
            }
        }
        return builder.toString();
    }
}

