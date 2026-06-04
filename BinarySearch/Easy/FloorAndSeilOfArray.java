package BinarySearch.Easy;

public class FloorAndSeilOfArray {
    /*
     * Given a sorted array nums and an integer x. Find the floor and ceil of x in
     * nums. The floor of x is the largest element in the array which is smaller
     * than or equal to x. The ceiling of x is the smallest element in the array
     * greater than or equal to x. If no floor or ceil exists, output -1.
     * 
     * Input : nums =[3, 4, 4, 7, 8, 10], x= 5
     * Output: 4 7
     */

    public static void main(String[] args) {
        int[] nums = { 3, 4, 4, 7, 8, 10 };
        int x = 5;

        System.out.println(getFloorAndCeil(nums, x)[0]);
        System.out.println(getFloorAndCeil(nums, x)[1]);
    }

    public static int[] getFloorAndCeil(int[] nums, int x) {
        return new int[] { nums[getFloor(nums, x)], nums[getCeil(nums, x)] };
    }

    // get floor
    public static int getFloor(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // get ceil
    public static int getCeil(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > x) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
