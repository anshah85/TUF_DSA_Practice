package org.example.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SortingPractice9Sep24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[15];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 20);
        }

        System.out.println(Arrays.toString(arr));

        int[] bubbleSortArray = Arrays.copyOf(arr, arr.length);
        bubbleSort(bubbleSortArray);

        int[] quickSortLowPivotArray = Arrays.copyOf(arr, arr.length);
        quickSortLowPivot(quickSortLowPivotArray, 0, quickSortLowPivotArray.length - 1);
        System.out.println(Arrays.toString(quickSortLowPivotArray));
    }

    public static void quickSortLowPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partitionLowPivot(arr, low, high);
            quickSortLowPivot(arr, low, pIndex - 1);
            quickSortLowPivot(arr, pIndex + 1, high);
        }
    }

    public static int partitionLowPivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
