package org.example.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSortHighPivot {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10);
        }

        System.out.println("Before: " + Arrays.toString(nums));

        System.out.println("Sorting: ");
        long beforeTime = System.currentTimeMillis();
        quickSort(nums, 0, nums.length - 1);
        long afterTime = System.currentTimeMillis();


        System.out.println("After: " + Arrays.toString(nums));

        System.out.println("Time taken: " + (afterTime - beforeTime));
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pIndex = partition(nums, low, high);
            quickSort(nums, low, pIndex - 1);
            quickSort(nums, pIndex + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return (i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
