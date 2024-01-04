package list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An array -based list, a contiguous-memory representaion of a List
 * abstract data type. This array-based list dynamically resizes to ensure
 * O(1) amortized cost for adding to the end of the list. Size is maintained
 * as a global field to allow O(1) size() and isEmpty method calls.
 * 
 * @author Daniel Cao reference to CSC316 Course - Dr. King
 * 
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> extends AbstractList<E> {
    
    /**
     * The initial capacity of the list if the client does not provide a capacity
     * when constructing an instance of the array-based list
     **/
    private final static int DEFAULT_CAPACITY = 0;

    /** The array in which elements will be stored **/
    private E[] data;

    /** The number of elements stored in the array-based list data structure **/
    private int size;    

    /**
     * Constructs a new instance of an array-based list data structure with the
     * default initial capacity of the internal array
     */
    public ArrayBasedList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * To ensure amortized O(1) cost for adding to the end of the array-based list,
     * use the doubling strategy on each resize. Here, we add +1 after doubling to
     * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
     * still produce a capacity of 0).
     * 
     * @param minCapacity the minimum capacity that must be supported by the
     *                    internal array
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = data.length; 
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 2) + 1; // Add +1 for special case where inital capacity = 0
            if ( newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }
    
    /**
     * Constructs a new instance of an array-based list data structure with the
     * provided initial capacity
     * 
     * @param capacity the initial capacity of the internal array used to store the
     *                 list elements
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedList(int capacity) {
        data = (E[]) (new Object[capacity]);
        size = 0;
    }
    


    /**
     * Add method for an Array Based List, will add an element into the desired index by shifting the Array
     * @param index The Index at which the element is to be added
     * @param element The element that is to be added
     */
    public void add(int index, E element) {
        checkIndexForAdd(index); // Check if index valid for adding
        ensureCapacity(size + 1); // Double capacity if needed
        for (int i = size - 1; i >= index; i--) { // Shift data up by one after index
            data[i + 1] = data[i];
        }
        data[index] = element; // Replace data at index with new element
        size++; // Increment size
    }

	@Override
	public E get(int index) {
		checkIndex(index); //Check if index is in bounds
		return data[index];
	}

	@Override
	public E remove(int index) {
		checkIndex(index); // Check if index is in bounds
		E holder = data[index]; // Grab data at index
		for(int i = index; i < size - 1; i++) { // Shift list down by 1 after index
			data[i] = data[i + 1];	
		}
		data[size - 1] = null; // Remove last index since we shifted
		size--; // Decrement size
		return holder; 
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index); // Check if index is in bounds
		E holder = data[index]; // Grab data being replaced
		data[index] = element; // Set data to new element
		return holder; 
	}

	/**
	 * Return the size of the array
	 * @return the size of the array
	 */
	public int size() {
		return size; 
	}
	

	private class ElementIterator implements Iterator<E> {
		/** The position of the element */
	    private int position;
	    
	    /** Boolean if able to Remove */
	    private boolean removeOK;

	    /**
	     * Construct a new element iterator where the cursor is initialized 
	     * to the beginning of the list.
	     */
	    public ElementIterator() {
	    	removeOK = false;
	        position = 0;
	    }

	    @Override
	    public boolean hasNext() {
	    	
	        return (position < size);
	    }

	    @Override
	    public E next() throws NoSuchElementException {
	        if (position < 0 || position >= size()) {
	            throw new NoSuchElementException();
	        }
	        removeOK = true;
	        return data[position++];
	    }
	        
	    @Override
	    public void remove() throws IllegalStateException {
	        if (!removeOK) {
	            throw new IllegalStateException();
	        }
	        ArrayBasedList.this.remove(position - 1);
	    	position--;
	    	removeOK = false;
	    }
	}
	
	/**
	 * Iterator Constructor
	 */
	@Override
	public Iterator<E> iterator() {
	    return new ElementIterator();
	}
    
}
