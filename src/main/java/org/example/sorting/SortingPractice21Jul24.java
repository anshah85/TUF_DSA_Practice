package org.example.sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingPractice21Jul24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[random.nextInt(6, 10)];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Original input array: " + Arrays.toString(numbers) + " and length of the array is : " + numbers.length);


        int[] mergeSortArray = Arrays.copyOf(numbers, numbers.length);
        int[] selectionSortArray = Arrays.copyOf(numbers, numbers.length);
        int[] insertionSortArray = Arrays.copyOf(numbers, numbers.length);
        int[] bubbleSortArray = Arrays.copyOf(numbers, numbers.length);
        int[] quickSortLowPivotArray = Arrays.copyOf(numbers, numbers.length);
        int[] quickSortHighPivotArray = Arrays.copyOf(numbers, numbers.length);

        Arrays.sort(numbers);
        System.out.println("Sorted input array: " + Arrays.toString(numbers) + " and length of the array is : " + numbers.length);

        quickSortLowPivot(quickSortLowPivotArray, 0, quickSortLowPivotArray.length - 1);
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        selectionSort(selectionSortArray);
        insertionSort(insertionSortArray);
        bubbleSort(bubbleSortArray);
        quickSortHighPivot(quickSortHighPivotArray, 0, quickSortHighPivotArray.length - 1);

        System.out.println("Merge sort output: " + Arrays.toString(mergeSortArray));
        System.out.println("Selection sort output: " + Arrays.toString(selectionSortArray));
        System.out.println("Insertion sort output: " + Arrays.toString(insertionSortArray));
        System.out.println("Bubble sort output: " + Arrays.toString(bubbleSortArray));
        System.out.println("Quick sort low pivot output: " + Arrays.toString(quickSortLowPivotArray));
        System.out.println("Quick sort high pivot output: " + Arrays.toString(quickSortHighPivotArray));
    }

    public static void quickSortHighPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partitionHighPivot(arr, low, high);
            quickSortHighPivot(arr, low, pIndex - 1);
            quickSortHighPivot(arr, pIndex + 1, high);
        }
    }

    public static int partitionHighPivot(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                quickSortSwap(nums, i, j);
            }
        }
        quickSortSwap(nums, i + 1, high);
        return (i + 1);
    }

    public static  void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n =arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
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
                quickSortSwap(arr, i, j);
            }
        }
        quickSortSwap(arr, low, j);
        return j;
    }

    public static void quickSortSwap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
