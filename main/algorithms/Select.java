package main.algorithms;

import main.util.Util;

public class Select {

    public static int select(int[] arr, int k) {
        Util.guardNotNull(arr);
        if (k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int left, int right, int k) {
        while (true) {
            if (left == right) {
                return arr[left];
            }

            int pivotIndex = medianOfMedians(arr, left, right);
            int pivotNewIndex = Util.partition(arr, left, right, pivotIndex);

            if (k == pivotNewIndex) {
                return arr[k];
            } else if (k < pivotNewIndex) {
                right = pivotNewIndex - 1;
            } else {
                left = pivotNewIndex + 1;
            }
        }
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            insertionSort(arr, left, right);
            return left + n / 2;
        }

        int numMedians = (int) Math.ceil((double) n / 5);
        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);

            insertionSort(arr, subLeft, subRight);

            int medianIndex = subLeft + (subRight - subLeft) / 2;
            Util.swap(arr, left + i, medianIndex);
        }

        return medianOfMedians(arr, left, left + numMedians - 1);
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
}
