import java.util.Arrays;
import java.util.Random;

public class SortingPractice20Jul24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        int[] mergeSortArray = Arrays.copyOf(nums, nums.length);
        int[] insertionSortArray = Arrays.copyOf(nums, nums.length);

        System.out.println("Before Bubble Sort: ");
        printArray(nums);

        bubbleSort(nums);

        System.out.println("After Bubble Sort: ");
        printArray(nums);

        System.out.println("Before Merge Sort: ");
        printArray(mergeSortArray);

        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);

        System.out.println("After Merge Sort: ");
        printArray(mergeSortArray);

        System.out.println("Before Insertion Sort: ");
        printArray(insertionSortArray);

        insertionSort(insertionSortArray);

        System.out.println("After Insertion Sort: ");
        printArray(insertionSortArray);
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (nums.length < 2) {
            return;
        }
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    public static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
