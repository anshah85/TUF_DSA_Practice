import java.util.Random;

public class SortingPractice20Jul24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(10)];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
    }
}
