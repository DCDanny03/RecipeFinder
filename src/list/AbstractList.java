package list;

/**
 * A skeletal implementation of the List abstract data type. This class
 * contains the common implementations used acrossed different concrete
 * data structures used to implement the list abstract data type.
 * 
 * @author Daniel Cao reference CSC316 course at NC State - Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public abstract class AbstractList<E> implements List<E> {

    @Override
    public void addFirst(E element) {
        add(0, element);
    }

    @Override
    public void addLast(E element) {
        add(size(), element);
    }

    /**
     * Checks whether the provided index is a legal index based on the current state
     * of the list. This check should be performed when accessing any specific
     * indexes within the list.
     * 
     * @param index the index for which to check whether it is valid/legal in the
     *              current list or not
     */
    protected void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
        }
    }

    /**
     * Checks whether the provided index is a legal index based on the current state
     * of the list. This check should be performed when adding elements at specific
     * indexes within the list.
     * 
     * @param index the index for which to check whether it is valid/legal in the
     *              current list or not
     */
    protected void checkIndexForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
        }
    }

    @Override
    public E first() {
        return get(0);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E last() {
        return get(size() - 1);
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size() - 1);
    }    
}
