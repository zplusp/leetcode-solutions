import java.io.*;
import java.util.*;

public class Solution {

    // Complete the function implementation below
    public int maxArea(int[] height) {
        int answer = 0;
        int i = 0;
        int j = height.length - 1;

        while(i < j) {
            int min = height[i] < height[j] ? height[i] : height[j];
            answer = (min * (j-i)) > answer ? (min * (j-i)) : answer;
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int height[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();
        int result = new Solution().maxArea(height);
        System.out.println(result);
    }
}