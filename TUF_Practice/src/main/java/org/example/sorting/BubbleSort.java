package org.example.sorting;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[100000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100000);
        }

        System.out.println("Before: ");
        printArray(numbers);

        long beforeTimeInMillis = System.currentTimeMillis();
        bubbleSort(numbers);

        long afterTimeInMillis = System.currentTimeMillis();

        System.out.println("After: ");
        printArray(numbers);


        System.out.println("Time taken by Bubble sort algorithm: " + (afterTimeInMillis - beforeTimeInMillis));
    }

    public static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                }
            }
        }
    }
}
