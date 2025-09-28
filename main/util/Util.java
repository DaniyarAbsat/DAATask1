package main.util;


import java.util.Random;

public class Util {

    private static final Random rnd = new Random();

    // swap
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // partition
    public static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    // shuffle
    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    // guards
    public static void guardNotNull(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
    }

    public static void guardIndices(int[] arr, int left, int right) {
        if (left < 0 || right >= arr.length || left > right) {
            throw new IllegalArgumentException("Invalid indices: [" + left + ", " + right + "]");
        }
    }
}