package BasicStrings1;

public class PalindromeCheck {
    /*
     * You are given a string s. Return true if the string is palindrome,
     * otherwise false.
     * 
     * A string is called palindrome if it reads the same forward and backward.
     * 
     * Example 1
     * Input : s = "hannah"
     * Output : true
     */
    public static void main(String[] args) {
        String arr = "hannah";

        System.out.println(palindromeCheck(arr));

    }

    static boolean palindromeCheck(String arr) {
        int x = 0;
        int y = arr.length() - 1;

        while (x < y) {
            if (arr.charAt(x) != arr.charAt(y)) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
}
