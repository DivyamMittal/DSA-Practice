package BinarySearch.Easy;

public class CountOccourencesInSortedArray {
    /*
     * You are given a sorted array containing N integers and a number X, you have
     * to find the occurrences of X in the given array.
     * 
     * N = 7, X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
     * Output: 4
     */

    public static void main(String[] args) {
        int nums[] = { 2, 2, 3, 3, 3, 3, 4 };
        int k =3;

        System.out.println(firstOccurrence(nums, k));
    }

    public static int firstOccurrence(int[] arr, int k) {
        int lc = lastOccur(arr, k);
        if(lc == -1){
            return 0;
        }
        int ans = lc - firstOccur(arr, k) + 1;
        return ans;
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
}
