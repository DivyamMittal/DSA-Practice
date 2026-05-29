package Strings.Easy;

public class CheckRotateString {

    /*
     * Given two strings s and goal, return true if and only if s can become goal
     * after some number of shifts on s.
     * 
     * A shift on s consists of moving the leftmost character of s to the rightmost
     * position.
     * 
     * For example, if s = "abcde", then it will be "bcdea" after one shift.
     * 
     * Example 1
     * Input : s = "abcde" , goal = "cdeab"
     * Output : true
     */

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";

        System.out.println(bruteForceSol(s, goal));

    }

    // TC -> O(N^2) --- SC -> O(N)
    static boolean bruteForceSol(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    // TC -> O(N) ----- SC -> O(N)
    static boolean optimize(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

}
