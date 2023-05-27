package hw1;

/**
 * Native ArrayList Implementation Class
 * @version 1.0
 * @autor Tanisha
 */
public class MyArrayListImp<T> implements MyArrayList<T> {
    /**
     * Internal array
     */
    private Object[] data;
    /**
     * Default capacity of internal array
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Internal array capacity
     */
    private int capacity;
    /**
     * Internal array size
     */
    private int size;

    /**
     * Object constructor with initial capacity
     *
     * @throw IllegalArgumentException
     */
    public MyArrayListImp(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = new Object[initialCapacity];
            this.capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.data = new Object[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * An object constructor without giving it an initial capacity,
     * capacity is set by default DEFAULT_CAPACITY
     */
    public MyArrayListImp() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Method that returns the size of the internal array
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Method for adding a new element to the end
     */
    @Override
    public void add(T element) {
        if (size == data.length)
            data = grow();
        data[size] = element;
        size = size + 1;
    }

    /**
     * Method for increasing the capacity of the internal array
     */
    private Object[] grow() {
        this.capacity = (int) (capacity * 1.5);
        Object[] grown = new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            grown[i] = data[i];
        }
        return data = grown;
    }

    /**
     * Method for adding a new element by index
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);
        if (size == data.length)
            data = grow();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size = size + 1;

    }

    /**
     * Method for checking the index passed as an argument
     * @throw IndexOutOfBoundsException
     */
    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(index);
    }

    /**
     * Method for getting an element by index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    /**
     * Method for removing an element by index
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size = size - 1;
    }

    /**
     * Internal array clearing method
     */
    @Override
    public void clear() {
        for (int i = 0; i > size - 1; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Object to String conversion method
     */
    @Override
    public String toString() {
        StringBuilder sbd = new StringBuilder();
        if (size == 0) {
            return "[ ]";
        }
        sbd.append("[ ");
        for (int i = 0; i < size; i++) {
            sbd.append(data[i] + ", ");
        }
        sbd.replace(sbd.length() - 2, sbd.length(), " ]");
        return sbd.toString();
    }

    /**
     * Sorting an array using quicksort
     */
    @Override
    public void sort() {
        MyQuickSort.quickSort(data, 0, size - 1);
    }
}
