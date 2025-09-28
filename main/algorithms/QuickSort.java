package main.algorithms;

import java.util.Random;

public class QuickSort {

    private static final Random rand = new Random();

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        while (left < right) {

            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivot = arr[pivotIndex];
            swap(arr, pivotIndex, right);

            // Partition
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (arr[j] <= pivot) {
                    swap(arr, ++i, j);
                }
            }
            swap(arr, i + 1, right);
            int mid = i + 1;

            if (mid - left < right - mid) {
                quickSort(arr, left, mid - 1);
                left = mid + 1;
            } else {
                quickSort(arr, mid + 1, right);
                right = mid - 1;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 8, 2, 5, 4, 6};
        System.out.print("Before: ");
        printArray(arr);

        quickSort(arr);

        System.out.print("After:  ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

