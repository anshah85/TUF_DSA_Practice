package org.example.sorting;

import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100000);
        }

        System.out.println("Before: ");
        printArray(numbers);

        long beforeTimeInMillis = System.currentTimeMillis();
        insertionSort(numbers);

        long afterTimeInMillis = System.currentTimeMillis();

        System.out.println("After: ");
        printArray(numbers);


        System.out.println("Time taken by Insertion sort algorithm: " + (afterTimeInMillis - beforeTimeInMillis));
    }

    public static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                arr[j - 1] ^= arr[j];
                arr[j] ^= arr[j - 1];
                arr[j - 1] ^= arr[j];
                j--;
            }
        }
    }
}
