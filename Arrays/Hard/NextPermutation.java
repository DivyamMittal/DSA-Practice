package Arrays.Hard;

public class NextPermutation {
    /*
     * A permutation of an array of integers is an arrangement of its members into a
     * sequence or linear order.
     * For example, for arr = [1,2,3], the following are all the permutations of
     * arr:
     * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].
     * 
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        nextPermutation(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(nums, 0, n - 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        reverse(nums, idx + 1, n - 1);
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
