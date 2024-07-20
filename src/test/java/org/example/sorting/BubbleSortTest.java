package org.example.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        int[] nums = {8, 3, 6, 3, 5, 1, 8, 7, 2, 6};
        int[] expected = {1, 2, 3, 3, 5, 6, 6, 7, 8, 8};

        BubbleSort.bubbleSort(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testBubbleSortEmptyArray() {
        int[] nums = {};
        int[] expected = {};

        BubbleSort.bubbleSort(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testBubbleSortSingleElement() {
        int[] nums = {1};
        int[] expected = {1};

        BubbleSort.bubbleSort(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testBubbleSortAlreadySorted() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        BubbleSort.bubbleSort(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void testBubbleSortReverseOrder() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        BubbleSort.bubbleSort(nums);

        assertArrayEquals(expected, nums);
    }
}
