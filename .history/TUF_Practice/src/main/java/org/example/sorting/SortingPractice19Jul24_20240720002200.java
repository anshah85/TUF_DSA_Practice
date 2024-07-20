package org.example.sorting;

import java.util.Random;

public class SortingPractice19Jul24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];

        for (int num : nums) {
            num = random.nextInt(100);
        }

        System.out.println("Before Merge Sort: ");
        printArray(nums);

        System.out.println("Sorting using Merge Sort: ");
        mergeSort(nums, 0, nums.length - 1);

        System.out.println("After Merge Sort: ");
        printArray(nums);
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
