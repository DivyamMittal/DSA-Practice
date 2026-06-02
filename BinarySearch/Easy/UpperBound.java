package BinarySearch.Easy;

public class UpperBound {
    /*
     * Given a sorted array of nums and an integer x, write a program to find the
     * upper bound of x.
     * The upper bound of x is defined as the smallest index i such that nums[i] >
     * x.
     * If no such index is found, return the size of the array.
     * 
     * Input : n = 5, nums = [3,5,8,15,19], x = 9
     * Output: 3
     */

    public static void main(String[] args) {
        int[] nusm = { 3,5,8,15,19 };
        int x = 9;

        System.out.println(upperBound(nusm, x));
    }

    public static int upperBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        int ans = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > x) {
                ans = mid;
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

}
