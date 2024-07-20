package org.example.patterns;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        printPattern7(n);
    }

    public static void printPattern7(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*");
            }

            for (int l = 0; l < n - i - 1; l++) {
                System.out.print(" ");
            }


            System.out.println();
        }
    }
}
