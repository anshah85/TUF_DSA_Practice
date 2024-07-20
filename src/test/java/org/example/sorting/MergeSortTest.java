package org.example.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] nums = {8, 3, 6, 3, 5, 1, 8, 7, 2, 6};
        int[] expected = {1, 2, 3, 3, 5, 6, 6, 7, 8, 8};

        MergeSort.mergeSort(nums, 0, nums.length - 1);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] nums = {};
        int[] expected = {};

        MergeSort.mergeSort(nums, 0, nums.length - 1);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMergeSortSingleElement() {
        int[] nums = {1};
        int[] expected = {1};

        MergeSort.mergeSort(nums, 0, nums.length - 1);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMergeSortAlreadySorted() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        MergeSort.mergeSort(nums, 0, nums.length - 1);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMergeSortReverseOrder() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        MergeSort.mergeSort(nums, 0, nums.length - 1);

        assertArrayEquals(expected, nums);
    }
}
