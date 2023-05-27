package hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


class MyQuickSortTest {

    @Test
    void quickSort() {
        Integer[] arr = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        MyQuickSort.quickSort(arr, 0, arr.length - 1);
        Assertions.assertEquals("[-3, 0, 3, 4, 7, 7, 8, 10, 12]", Arrays.toString(arr));
    }
}