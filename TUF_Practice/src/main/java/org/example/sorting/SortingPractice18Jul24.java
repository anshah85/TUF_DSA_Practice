package org.example.sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingPractice18Jul24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[100000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000000);
        }

        int[] nums1 = Arrays.copyOf(nums, nums.length);
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        int[] nums3 = Arrays.copyOf(nums, nums.length);

        System.out.println("Before Merge Sort: ");
        printArray(nums);

        System.out.println("Sorting using merge sort: ");
        long beforeMergeSort = System.currentTimeMillis();
        mergeSort(nums, 0, nums.length - 1);
        long afterMergeSort = System.currentTimeMillis();

        System.out.println("After Merge Sort: ");
        printArray(nums);

        System.out.println("Time taken by merge sort algorithm is: " + (afterMergeSort - beforeMergeSort));

        System.out.println();
        System.out.println();

        System.out.println("Before Selection Sort: ");
        printArray(nums1);

        System.out.println("Sorting using selection sort: ");
        long beforeSelectionSort = System.currentTimeMillis();
        selectionSort(nums1);
        long afterSelectionSort = System.currentTimeMillis();

        System.out.println("After Selection Sort: ");
        printArray(nums1);

        System.out.println("Time taken by selection sort algorithm is: " + (afterSelectionSort - beforeSelectionSort));

        System.out.println();
        System.out.println();

        System.out.println("Before Bubble Sort: ");
        printArray(nums2);

        System.out.println("Sorting using bubble sort: ");
        long beforeBubbleSort = System.currentTimeMillis();
        bubbleSort(nums2);
        long afterBubbleSort = System.currentTimeMillis();

        System.out.println("After Bubble Sort: ");
        printArray(nums2);

        System.out.println("Time taken by bubble sort algorithm is: " + (afterBubbleSort - beforeBubbleSort));

        System.out.println();
        System.out.println();

        System.out.println("Before Insertion Sort: ");
        printArray(nums3);

        System.out.println("Sorting using selection sort: ");
        long beforeInsertionSort = System.currentTimeMillis();
        insertionSort(nums3);
        long afterInsertionSort = System.currentTimeMillis();

        System.out.println("After Insertion Sort: ");
        printArray(nums3);

        System.out.println("Time taken by merge sort algorithm is: " + (afterMergeSort - beforeMergeSort));

        System.out.println("Time taken by selection sort algorithm is: " + (afterSelectionSort - beforeSelectionSort));

        System.out.println("Time taken by bubble sort algorithm is: " + (afterBubbleSort - beforeBubbleSort));

        System.out.println("Time taken by insertion sort algorithm is: " + (afterInsertionSort - beforeInsertionSort));
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
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

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
