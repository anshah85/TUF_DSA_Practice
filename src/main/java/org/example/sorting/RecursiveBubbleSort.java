package org.example.sorting;

import java.util.Arrays;
import java.util.Random;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[random.nextInt(1, 10)];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Original input array: " + Arrays.toString(numbers));
        recursiveBubbleSort(numbers);
        System.out.println("Sorted input array: " + Arrays.toString(numbers));
    }

    public static void recursiveBubbleSort(int[] nums) {
        int n = nums.length;
        recursiveBubbleSort(nums, n, 0);
    }

    public static void recursiveBubbleSort(int[] nums, int n, int depth) {
        if (n == 1) return;

        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                swapped = true;
            }
        }

        String indent = " ".repeat(depth * 2);
        System.out.println(indent + "Depth " + depth + " - Array after pass: " + Arrays.toString(nums));
        System.out.println(indent + "Depth " + depth + " - Swapped: " + swapped);

        if (!swapped) {
            return;
        }
        recursiveBubbleSort(nums, n - 1, depth + 1);
    }
}
