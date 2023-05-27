package hw1;

/**
 * Native QuickSort Implementation Class
 * @version 1.0
 * @autor Tanisha
 */
public class MyQuickSort {
    /**
     * Method for Quick Sort
     */
    public static void quickSort(Object[] array, int low, int high) {

        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Object opora = array[middle];


        int i = low, j = high;
        while (i <= j) {
            while (((Comparable) array[i]).compareTo(opora) < 0) {
                i++;
            }

            while (((Comparable) array[j]).compareTo(opora) > 0) {
                j--;
            }

            if (i <= j) {
                Object temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
