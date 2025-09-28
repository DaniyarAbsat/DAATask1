package main.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class MergeSortTest {

    @Test
    void testSimpleArray() {
        int[] arr = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testReversedArray() {
        int[] arr = {9, 7, 5, 3, 1};
        int[] expected = {1, 3, 5, 7, 9};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testDuplicates() {
        int[] arr = {4, 2, 2, 4, 1};
        int[] expected = {1, 2, 2, 4, 4};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testLargeRandomArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}

