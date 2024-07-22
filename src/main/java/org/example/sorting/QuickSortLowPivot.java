package org.example.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSortLowPivot {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[5];

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
        int pivot = nums[low];
        int i = low, j = high;

        while (i < j) {
            while (nums[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (nums[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }
}
