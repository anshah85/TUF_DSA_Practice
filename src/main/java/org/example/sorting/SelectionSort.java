package org.example.sorting;

import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[100];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
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
            int minIndex = i;
            for (int j = i; j <= arr.length - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
