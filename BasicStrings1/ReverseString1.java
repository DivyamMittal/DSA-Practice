package BasicStrings1;

public class ReverseString1 {
    /*
     * Given a string, the task is to reverse it. The string is represented by an
     * array of characters s.
     * 
     * Perform the reversal in place with O(1) extra memory.
     * 
     * Note: no need to return anything, modify the given list.
     * Example 1
     * Input : s = ["h", "e" ,"l" ,"l" ,"o"]
     * Output : ["o", "l", "l", "e", "h"]
     */

    public static void main(String[] args) {
        String[] arr = { "h", "e", "l", "l", "o" };

        reverseString(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    static void reverseString(String[] arr) {
        int x = 0;
        int y = arr.length - 1;

        while (x < y) {
            String temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
    }
}