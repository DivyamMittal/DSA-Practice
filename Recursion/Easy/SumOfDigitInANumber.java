package Recursion.Easy;

public class SumOfDigitInANumber {
    /*
     * Given an integer num, repeatedly add all its digits until the result has only
     * one digit, and return it.
     * 
     * 
     * Example 1
     * 
     * Input : num = 529
     * 
     * Output : 7
     * 
     * Explanation : In first iteration the digits sum will be = 5 + 2 + 9 => 16
     */
    public static void main(String[] args) {
        int num = 529;

        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        return addDigits(helper(num));
    }

    private static int helper(int num) {
        if (num == 0) {
            return 0;

        }

        return (num % 10) + helper(num / 10);

    }
}
