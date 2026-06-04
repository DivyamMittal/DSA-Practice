package BinarySearch.Easy;

public class FirstAndLastOccurence {
    /*
     * Given an array of integers nums sorted in non-decreasing order, find the
     * starting and ending position of a given target value. If the target is not
     * found in the array, return [-1, -1].
     * 
     * Input: nums = [5, 7, 7, 8, 8, 10], target = 8
     * Output: [3, 4]
     */

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 8, 10 };
        int target = 8;
        System.out.println(searchRange(nums, target)[0]);
        System.out.println(searchRange(nums, target)[1]);

        System.out.println(searchRangeUsingBinary(nums, target)[0]);
        System.out.println(searchRangeUsingBinary(nums, target)[1]);
    }

    // ============== using binary search ===================
    public static int[] searchRangeUsingBinary(int[] nums, int target) {
        int first = firstOccur(nums, target);

        if (first == -1) {
            return new int[] { -1, -1 };
        } else
            return new int[] { firstOccur(nums, target), lastOccur(nums, target) };
    }

    // ------------------HELPER FUNCTION---------------------
    private static int firstOccur(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int lastOccur(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // ================== USING BOUNDS ======================

    // Using lower bound and upper bound
    public static int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);

        if (lb == nums.length || nums[lb] != target) {
            return new int[] { -1, -1 };
        }

        return new int[] { lowerBound(nums, target), upperBound(nums, target) - 1 };
    }

    // --------------- HELPER FUNCTION ----------------------
    private static int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private static int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {

                left = mid + 1;
            }
        }

        return ans;
    }
}
