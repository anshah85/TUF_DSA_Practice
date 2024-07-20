package org.example.sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingPractice19Jul24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        int[] insertionSortArray = Arrays.copyOf(nums, nums.length);
        int[] bubbleSortArray = Arrays.copyOf(nums, nums.length);
        int[] selectionSortArray = Arrays.copyOf(nums, nums.length);

        System.out.println("Before Merge Sort: ");
        printArray(nums);

        System.out.println("Sorting using Merge Sort: ");
        mergeSort(nums, 0, nums.length - 1);

        System.out.println("After Merge Sort: ");
        printArray(nums);

        System.out.println("Before Insertion Sort: ");
        printArray(insertionSortArray);

        System.out.println("Sorting using Insertion Sort: ");
        insertionSort(insertionSortArray);

        System.out.println("After Insertion Sort: ");
        printArray(insertionSortArray);

        System.out.println("Before Selection Sort: ");
        printArray(selectionSortArray);

        System.out.println("Sorting using Selection Sort: ");
        selectionSort(selectionSortArray);

        System.out.println("After Selection Sort: ");
        printArray(selectionSortArray);

        System.out.println("Before Bubble Sort: ");
        printArray(bubbleSortArray);

        System.out.println("Sorting using Bubble Sort: ");
        // bubbleSort(bubbleSortArray);

        System.out.println("After Bubble Sort: ");
        printArray(bubbleSortArray);
    }

    private static void bubbleSort(int[] bubbleSortArray) {
        int n = bubbleSortArray.length;

        for (int i = n - 1; i >=0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (bubbleSortArray[j + 1] < bubbleSortArray[j]) {
                    int temp = bubbleSortArray[j + 1];
                    bubbleSortArray[j + 1] = bubbleSortArray[j];
                    bubbleSortArray[j] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] selectionSortArray) {
        int n = selectionSortArray.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = 0; j < n; j++) {
                if (selectionSortArray[j] < selectionSortArray[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = selectionSortArray[minIndex];
            selectionSortArray[minIndex] = selectionSortArray[i];
            selectionSortArray[i] = temp;
        }
    }

    private static void insertionSort(int[] insertionSortArray) {
        int n = insertionSortArray.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && insertionSortArray[j - 1] > insertionSortArray[j]) {
                int temp = insertionSortArray[j - 1];
                insertionSortArray[j - 1] = insertionSortArray[j];
                insertionSortArray[j] = temp;
                j--;
            }
        }
    }

    public static void mergeSort(int[] nums, int l, int r) {
        int n = nums.length;
        if (n < 2) return;
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int left = l, right = m + 1, k = 0;

        while (left <= m && right <= r) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= m) {
            temp[k++] = nums[left++];
        }

        while (right <= r) {
            temp[k++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[l + i] = temp[i];
        }
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
