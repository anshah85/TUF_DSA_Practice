package org.example.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursiveBubbleSortTest {

    @Test
    public void testRecursiveBubbleSort() {
        int[] nums = {8, 3, 6, 3, 5, 1, 8, 7, 2, 6};
        int[] expected = {1, 2, 3, 3, 5, 6, 6, 7, 8, 8};

        RecursiveBubbleSort.recursiveBubbleSort(nums, nums.length);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testRecursiveBubbleSortEmptyArray() {
        int[] nums = {};
        int[] expected = {};

        RecursiveBubbleSort.recursiveBubbleSort(nums, nums.length);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testRecursiveBubbleSortSingleElement() {
        int[] nums = {1};
        int[] expected = {1};

        RecursiveBubbleSort.recursiveBubbleSort(nums, nums.length);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testRecursiveBubbleSortAlreadySorted() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        RecursiveBubbleSort.recursiveBubbleSort(nums, nums.length);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testRecursiveBubbleSortReverseOrder() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        RecursiveBubbleSort.recursiveBubbleSort(nums, nums.length);

        assertArrayEquals(expected, nums);
    }
}

