package test.algorithms;

import main.algorithms.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseOrder() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 2, 3, 3, 1};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 3}, arr);
    }

    @Test
    void testRandomArray() {
        int[] arr = {9, 3, 7, 1, 8, 2, 5, 4, 6};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }
}
