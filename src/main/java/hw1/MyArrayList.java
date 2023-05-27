package hw1;
/**
 * Native ArrayList Interface
 * @version 1.0
 * @autor Tanisha
 */
public interface MyArrayList<T> {
    int size();
    void add(T element);
    void add(int index, T element);
    T get(int index);
    void remove(int index);
    void clear();
    void sort();
}
