package org.example.patterns;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        printPattern8(n);
    }

    public static void printPattern8(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (2 * n - (2 * i + 1)); k++) {
                System.out.print("*");
            }
            for (int l = 0; l < i; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
