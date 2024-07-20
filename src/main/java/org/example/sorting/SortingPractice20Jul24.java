package org.example.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortingPractice20Jul24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] bubbleSortArray = new int[10];


        for (int i = 0; i < bubbleSortArray.length; i++) {
            bubbleSortArray[i] = random.nextInt(100);
        }

        int[] selectionSortArray = Arrays.copyOf(bubbleSortArray, bubbleSortArray.length);
        int[] mergeSortArray = Arrays.copyOf(selectionSortArray, selectionSortArray.length);
        int[] insertionSortArray = Arrays.copyOf(mergeSortArray, mergeSortArray.length);

        bubbleSort(bubbleSortArray);
        selectionSort(selectionSortArray);
        System.out.println(Arrays.toString(mergeSortArray));
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        System.out.println(Arrays.toString(mergeSortArray));
        insertionSort(insertionSortArray);
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length;
        System.out.println(Arrays.toString(nums));

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }

        System.out.println(Arrays.toString(nums));
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
        System.out.println(Arrays.toString(nums));
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
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    nums[j] ^= nums[j + 1];
                    nums[j + 1] ^= nums[j];
                    nums[j] ^= nums[j + 1];
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
