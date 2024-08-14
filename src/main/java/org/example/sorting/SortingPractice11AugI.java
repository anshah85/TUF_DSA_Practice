package org.example.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SortingPractice11AugI {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 50);
        }

        int[] bubbleSortArray = Arrays.copyOf(arr, arr.length);
        bubbleSort(bubbleSortArray);

        int[] quickSortLowPivotArray = Arrays.copyOf(arr, arr.length);
        quickSortLowPivot(quickSortLowPivotArray, 0, quickSortLowPivotArray.length - 1);
        System.out.println("Sorted array after quick sort low pivot: " + Arrays.toString(quickSortLowPivotArray));

        int[] quickSortHighPivotArray = Arrays.copyOf(arr, arr.length);
        quickSortHighPivot(quickSortHighPivotArray, 0, quickSortHighPivotArray.length - 1);
        System.out.println("Sorted array after quick sort high pivot: " + Arrays.toString(quickSortHighPivotArray));
    }

    public static void quickSortHighPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partitionHighPivot(arr, low, high);
            quickSortHighPivot(arr, low, pIndex - 1);
            quickSortHighPivot(arr, pIndex + 1, high);
        }
    }

    public static int partitionHighPivot(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[high];
        arr[high] = arr[i + 1];
        arr[i + 1] = temp;

        return (i + 1);
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

        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }

    public static void bubbleSort(int[] arr) {
        System.out.println("Original array: " + Arrays.toString(arr));
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
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

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
