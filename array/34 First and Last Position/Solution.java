import java.util.*;

public class Solution {

    public int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
        int first = findLowestIndex(nums, target);
        int last = findHighestIndex(nums, target);

        return new int[] { first, last };
    }

    private int findHighestIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int index = Integer.MIN_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid > index) {
                    index = mid;
                }
                low = mid + 1;

            } else if (nums[mid] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return index == Integer.MIN_VALUE ? -1 : index;
    }

    private int findLowestIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // System.out.println("Target " + target + " MId " + mid);
            if (nums[mid] == target) {
                if (mid < index) {
                    index = mid;
                }
                high = mid - 1;

            } else if (nums[mid] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
