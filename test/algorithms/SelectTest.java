package test.algorithms;

import main.algorithms.Select;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class SelectTest {

    @Test
    void testFindMinimum() {
        int[] arr = {7, 2, 5, 3, 1};
        assertEquals(1, Select.select(arr, 0));
    }

    @Test
    void testFindMaximum() {
        int[] arr = {7, 2, 5, 3, 1};
        assertEquals(7, Select.select(arr, arr.length - 1));
    }

    @Test
    void testFindMedianOdd() {
        int[] arr = {9, 3, 7, 1, 5};
        assertEquals(5, Select.select(arr, arr.length / 2));
    }

    @Test
    void testFindMedianEven() {
        int[] arr = {8, 4, 2, 6};
        Arrays.sort(arr);
        int median = arr[arr.length / 2];
        int[] arr2 = {8, 4, 2, 6};
        assertEquals(median, Select.select(arr2, arr2.length / 2));
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 2, 3, 3, 1};
        assertEquals(2, Select.select(arr, 2)); // 0,1,2 -> 1,1,2
    }
}
