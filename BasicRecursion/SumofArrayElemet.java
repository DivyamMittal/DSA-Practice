package BasicRecursion;

public class SumofArrayElemet {
    /*
     * Given an array nums, find the sum of elements of array using recursion.
     * Input : nums = [1, 2, 3]
     * 
     * Output : 6
     */

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(arraySum(nums));
    }

    public static int arraySum(int[] nums) {
        return sum(nums, nums.length-1);
    }

    public static int sum(int[] nums, int i){
        if(i < 0){
            return 0;
        }

        return nums[i] + sum(nums, i-1);
    }
}
