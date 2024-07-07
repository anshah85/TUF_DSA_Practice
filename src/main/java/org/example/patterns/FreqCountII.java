package org.example.patterns;

public class FreqCountII {

//    Given an array arr[] of n positive integers which can contain integers from 1 to p where elements can be repeated or can be absent from the array.
//Your task is to count the frequency of all numbers from 1 to n. Do modify the array in-place changes in arr[], such that arr[i] = frequency(i) and assume 1-based indexing.
//
//Note: The elements greater than n in the array can be ignored for counting.

    public static void main(String[] args) {
        int[] arr = {8, 9};
        int n = arr.length;
        int p = 9;
        frequencyCount(arr, n, p);
    }

    public static void frequencyCount(int arr[], int n, int p) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - 1;
        }

        for (int i = 0; i < n; i++) {
            arr[arr[i] % p] = arr[arr[i] % p] + p;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / p;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
