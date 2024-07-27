package org.example.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SortingPractice27JulI {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Random random = new Random();
        int[] arr = new int[random.nextInt(4, 10)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        int[] insertionSortArray = Arrays.copyOf(arr, arr.length);
        insertionSort(insertionSortArray);

        int[] bubbleSortArray = Arrays.copyOf(arr, arr.length);
        bubbleSort(bubbleSortArray);

        int[] selectionSortArray = Arrays.copyOf(arr, arr.length);
        selectionSort(selectionSortArray);

        int[] quickSortLowPivotArray = Arrays.copyOf(arr, arr.length);
        System.out.println("Array before sorting: "+ Arrays.toString(quickSortLowPivotArray));
        quickSortLowPivot(quickSortLowPivotArray, 0, quickSortLowPivotArray.length - 1);
        System.out.println("Array after sorting: "+ Arrays.toString(quickSortLowPivotArray));

        int[] quickSortHighPivotArray = Arrays.copyOf(arr, arr.length);
        System.out.println("Array before sorting: "+ Arrays.toString(quickSortHighPivotArray));
        quickSortHighPivot(quickSortHighPivotArray, 0, quickSortHighPivotArray.length - 1);
        System.out.println("Array after sorting: "+ Arrays.toString(quickSortHighPivotArray));

        int[] mergeSortArray = Arrays.copyOf(arr, arr.length);
        System.out.println("Array before sorting: "+ Arrays.toString(mergeSortArray));
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        System.out.println("Array after sorting: "+ Arrays.toString(mergeSortArray));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
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
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Array before sorting: " + Arrays.toString(arr));

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Array after sorting: " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        System.out.println("Array before sorting: " + Arrays.toString(arr));

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

        System.out.println("Array after sorting: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        System.out.println("Array before sorting: " + Arrays.toString(arr));

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        System.out.println("Array after sorting: " + Arrays.toString(arr));
    }
}
