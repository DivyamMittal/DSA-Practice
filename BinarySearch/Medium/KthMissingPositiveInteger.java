package BinarySearch.Medium;

public class KthMissingPositiveInteger {
    /*
     * Given an array arr of positive integers sorted in a strictly increasing
     * order, and an integer k.
     * 
     * Return the kth positive integer that is missing from this array.
     * Input: arr = [2,3,4,7,11], k = 5
     * Output: 9
     */

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(nums, k));
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((arr[mid] - (mid + 1)) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return k + high + 1;
    }

    /// high will be at 7 and low at 11
    /// at 7 there are arr[high] - (mid + 1) missing number lets say its 3 < 5
    /// result is arr[high] + k - missing => 7 + 5 - 3
    /// [4,7,9] k = 3 then it fails
    
}
