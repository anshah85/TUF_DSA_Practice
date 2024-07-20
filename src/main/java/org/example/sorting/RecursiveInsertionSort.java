package org.example.sorting;

import java.util.Arrays;
import java.util.Random;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[random.nextInt(1, 10)];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Original input array: " + Arrays.toString(numbers));
        recursiveInsertionSort(numbers, 0, numbers.length);
        System.out.println("Sorted input array: " + Arrays.toString(numbers));
    }

    public static void recursiveInsertionSort(int[] nums, int i, int n) {
        if (i == n) {
            return;
        }

        int j = i;
        while (j > 0 && nums[j - 1] > nums[j]) {
            int temp = nums[j - 1];
            nums[j - 1] = nums[j];
            nums[j] = temp;
            j--;
        }

        recursiveInsertionSort(nums, i + 1, n);

    }
}
