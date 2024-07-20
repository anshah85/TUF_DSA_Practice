package org.example.patterns;
import java.util.Map;
import java.util.HashMap;

public class FreqCount {
    public static void main(String[] args) {

        int[] arr = new int[] {2, 3, 2, 3, 5};
        int N = 5, P = 5;
        frequencyCount(arr, N, P);

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void frequencyCount(int[] arr, int N, int P) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.getOrDefault(i + 1, 0);
        }
    }
}
