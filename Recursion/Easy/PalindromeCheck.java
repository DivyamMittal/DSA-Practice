package Recursion.Easy;

public class PalindromeCheck {
    /*
     * Given a string s, return true if the string is palindrome, otherwise false.
     * A string is called palindrome if it reads the same forward and backward.
     * 
     * Input : s = "hannah"
     * 
     * Output : true
     */
    public static void main(String[] args) {
        String s = "hannah";

        System.out.println(palindromeCheck(s));
    }

    static public boolean palindromeCheck(String s) {
        return check(s, 0, s.length() - 1);
    }

    static public boolean check(String s, int start, int end) {
        if (start <= end) {
            return true;
        }

        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return check(s, start + 1, end - 1);
    }
}
