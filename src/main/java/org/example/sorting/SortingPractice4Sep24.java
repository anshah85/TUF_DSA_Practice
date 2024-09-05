package org.example.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SortingPractice4Sep24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 20);
        }

        System.out.println(Arrays.toString(arr));

        int[] mergeSortArray = Arrays.copyOf(arr, arr.length);
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        System.out.println(Arrays.toString(mergeSortArray));

        int[] selectionSortArray = Arrays.copyOf(arr, arr.length);
        selectionSort(selectionSortArray);

        int[] insertionSortArray = Arrays.copyOf(arr, arr.length);
        insertionSort(insertionSortArray);

        int[] qsHpArray = Arrays.copyOf(arr, arr.length);
        quickSortHighPivot(qsHpArray, 0, qsHpArray.length - 1);
        System.out.println(Arrays.toString(qsHpArray));

        int[] bubbleSortArray = Arrays.copyOf(arr, arr.length);
        bubbleSort(bubbleSortArray);

        int[] qsLpArray = Arrays.copyOf(arr, arr.length);
        quickSortLowPivot(qsLpArray, 0, qsLpArray.length - 1);
        System.out.println(Arrays.toString(qsLpArray));
    }

    public static void quickSortLowPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partitionQSLP(arr, low, high);
            quickSortLowPivot(arr, low, pIndex - 1);
            quickSortLowPivot(arr, pIndex + 1, high);
        }
    }

    public static int partitionQSLP(int[] arr, int low, int high) {
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
                swap(arr, i, j);
            }
        }
        swap(arr, j, low);

        return j;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSortHighPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partitionQSHP(arr, low, high);
            quickSortHighPivot(arr, low, pIndex - 1);
            quickSortHighPivot(arr, pIndex + 1, high);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partitionQSHP(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, (i + 1), high);
        return (i + 1);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
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
}
