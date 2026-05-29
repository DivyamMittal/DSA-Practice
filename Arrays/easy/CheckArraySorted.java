package Arrays.easy;

public class CheckArraySorted {
    public static void main(String[] args) {
        /*
         * Example 1
         * Input: n = 5, arr = [1,2,3,4,5]
         * 
         * Output: True
         * 
         */

        int[] arr = { 1, 2, 3, 4, 5, 6 };

        System.out.println(checkSorted(arr));
    }

    static boolean checkSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }
}
