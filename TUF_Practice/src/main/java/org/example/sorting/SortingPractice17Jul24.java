package org.example.sorting;

import java.util.Random;
public class SortingPractice17Jul24 {
        public static void main (String[]args)
        {
            Random random = new Random ();
            int[] nums = new int[10];

            for (int i = 0; i < nums.length; i++)
            {
                nums[i] = random.nextInt (100);
            }

            System.out.println ("Before: ");
            printArray (nums);
            System.out.println ();

            System.out.println ("Sorting: ");
//      selectionSort(nums);
//  bubbleSort (nums);
            insertionSort(nums);
            System.out.println ();

            System.out.println ("After: ");
            printArray (nums);
        }

        public static void insertionSort(int[] nums) {
            int n = nums.length;

            long beforeSort = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                int j = i;
                while (j > 0 && nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    j--;
                }
            }
            long afterSort = System.currentTimeMillis();
            System.out.println("Time taken: " + (afterSort - beforeSort));
        }

        public static void bubbleSort (int[]nums)
        {
            int n = nums.length;

            long beforeSort = System.currentTimeMillis ();

            for (int i = n - 1; i >= 0; i--)
            {
                for (int j = 0; j < i; j++)
                {
                    if (nums[j] > nums[j + 1])
                    {
                        nums[j] ^= nums[j + 1];
                        nums[j + 1] ^= nums[j];
                        nums[j] ^= nums[j + 1];
                    }
                }
            }

            long afterSort = System.currentTimeMillis ();
            System.out.println ("Time taken: " + (afterSort - beforeSort));
        }

        public static void selectionSort (int[]nums)
        {
            int n = nums.length;
            long beforeSort = System.currentTimeMillis ();
            for (int i = 0; i < n - 1; i++)
            {
                int minIndex = i;
                for (int j = i; j < n; j++)
                {
                    if (nums[j] < nums[minIndex])
                    {
                        minIndex = j;
                    }
                }

                // swap
                //nums[minIndex] ^= nums[i];
                //nums[i] ^= nums[minIndex];
                //nums[minIndex] ^= nums[i];
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }

            long afterSort = System.currentTimeMillis ();

            System.out.println ("Time taken: " + (afterSort - beforeSort));
        }

        public static void printArray (int[]nums)
        {
            for (int num:nums)
            {
                System.out.print (num + " ");
            }
        }
}