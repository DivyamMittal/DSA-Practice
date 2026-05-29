package Arrays.easy;

public class CountOfOddNumber {
    public static void main(String[] args) {
        /*
         * Example 1
         * Input: n=5, array = [1,2,3,4,5]
         * 
         * Output: 3
         * 
         * Explanation: The three odd elements are (1,3,5).
         */

        int[] arr = { 1, 2, 3, 4, 5 };

        int cnt = 0;

        for (int i : arr) {
            if (i % 2 != 0) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}
