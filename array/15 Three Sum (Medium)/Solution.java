import java.util.Scanner;
import java.util.*;

class Solution {
    
    public List<List<Integer>> threeSum(Integer[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        int prev = Integer.MIN_VALUE;
        for(int i=0; i<nums.length - 1; i++) {
            if(nums[i] != prev) {
                List<List<Integer>> list = twoSum(nums, i+1, 0-nums[i]);
                for(List<Integer> l: list) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(l.get(0));
                    sub.add(l.get(1));
                    result.add(sub);
                }
            }
            prev = nums[i];
        }

        return result;
    }

    private List<List<Integer>> twoSum(Integer[] nums, int start, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=start; i<nums.length; i++) {
            if(set.contains(sum - nums[i])) {
                if(!isAlreadyPresent(list, sum - nums[i], nums[i])) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(sum - nums[i]);
                    sub.add(nums[i]);
                    list.add(sub);
                }
            }
            set.add(nums[i]);
        }

        return list;
    }

    private boolean isAlreadyPresent(List<List<Integer>> list, int a, int b) {
        for(List<Integer> sub:list) {
            if(sub.size() == 2 && sub.get(0) == a && sub.get(1) == b) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer nums[] = new Integer[n];
        for(Integer i = 0 ; i < n ;i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        List<List<Integer>> result = new Solution().threeSum(nums);
        for (Integer i = result.size() - 1; i >= 0; i--) {
            System.out.printf("%d %d %d\n", result.get(i).get(0), result.get(i).get(1), result.get(i).get(2));
        }
    }
};
