package BinarySearch.Easy;

public class LowerBound {
    /*
     * Given a sorted array of nums and an integer x, write a program to find the
     * lower bound of x.
     * The lower bound algorithm finds the first and smallest index in a sorted
     * array where the value at that index is greater than or equal to a given key
     * i.e. x.
     * 
     * Input : nums= [1,2,2,3], x = 2
     * Output:1
     */

    public static void main(String[] args) {
        int[] nusm = { 3,5,8,15,19 };
        int x = 9;

        System.out.println(lowerBound(nusm, x));
    }

    public static int lowerBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        int ans = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= x) {
                ans = mid;
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}
