package org.example.sorting;

import java.util.*;

public class SortingPractice20Jul24II {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[random.nextInt(1, 10)];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Original input array: " + Arrays.toString(numbers) + " and length of the array is : " + numbers.length);


        int[] mergeSortArray = Arrays.copyOf(numbers, numbers.length);
        int[] selectionSortArray = Arrays.copyOf(numbers, numbers.length);
        int[] insertionSortArray = Arrays.copyOf(numbers, numbers.length);
        int[] bubbleSortArray = Arrays.copyOf(numbers, numbers.length);

        Arrays.sort(numbers);
        System.out.println("Sorted input array: " + Arrays.toString(numbers) + " and length of the array is : " + numbers.length);

        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        selectionSort(selectionSortArray);
        insertionSort(insertionSortArray);
        bubbleSort(bubbleSortArray);

        System.out.println("Merge sort output: " + Arrays.toString(mergeSortArray));
        System.out.println("Selection sort output: " + Arrays.toString(selectionSortArray));
        System.out.println("Insertion sort output: " + Arrays.toString(insertionSortArray));
        System.out.println("Bubble sort output: " + Arrays.toString(bubbleSortArray));


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

    public static void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }

    public static void bubbleSort(int[] nums) {
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
}
