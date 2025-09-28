package main.algorithms;
import java.util.Arrays;

public class MergeSort {

    private static final int INSERTION_SORT_THRESHOLD = 16; // small-n cut-off

    public static void mergeSort(int[] arr) {
        int[] buffer = new int[arr.length]; // reusable buffer
        mergeSort(arr, buffer, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] buffer, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, left, right);
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, buffer, left, mid);
        mergeSort(arr, buffer, mid + 1, right);

        // if already sorted, skip merge
        if (arr[mid] <= arr[mid + 1]) return;

        merge(arr, buffer, left, mid, right);
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        // Copy to buffer
        for (int i = left; i <= right; i++) {
            buffer[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        // Linear merge
        while (i <= mid && j <= right) {
            if (buffer[i] <= buffer[j]) {
                arr[k++] = buffer[i++];
            } else {
                arr[k++] = buffer[j++];
            }
        }

        // Copy remaining (only one side may have leftovers)
        while (i <= mid) {
            arr[k++] = buffer[i++];
        }
        while (j <= right) {
            arr[k++] = buffer[j++];
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Test
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }
}