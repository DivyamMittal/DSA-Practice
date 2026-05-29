package Arrays.easy;

public class LeftRotateByOne {
    /*
     * Left Rotate Array by One
     * Input: nums = [1, 2, 3, 4, 5]
     * 
     * Output: [2, 3, 4, 5, 1]
     */

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };

        rotateArrayByOne(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotateArrayByOne(int[] nums) {
        if(nums.length <=1){
            return;
        }

        int temp = nums[0];

        for(int i=0; i<nums.length - 1;i++){
            nums[i] = nums[i+1];
        }

        nums[nums.length - 1] = temp;
    }
}
