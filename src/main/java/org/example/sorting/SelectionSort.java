package org.example.sorting;

import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[100000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000000);
        }

        System.out.println("Before: ");
        printArray(numbers);

        long beforeTimeInMillis = System.currentTimeMillis();
        selectionSort(numbers);
        long afterTimeInMillis = System.currentTimeMillis();

        System.out.println("Time taken by selection sort algorithm: " + (afterTimeInMillis - beforeTimeInMillis));

        System.out.println("After: ");
        printArray(numbers);

    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i; j <= arr.length - 1; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
