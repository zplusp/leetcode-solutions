import java.util.*;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int ans = 0;
        if (nums.length > 0) {
            int cur = nums[0];
            ans++;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != cur) {
                    ans++;
                }
                cur = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        scanner.close();

        int result = removeDuplicates(numbers);
        System.out.print(Integer.toString(result));
    }
}