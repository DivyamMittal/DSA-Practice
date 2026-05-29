package Math;

import java.util.*;

public class Palindrome {

    /*
     * if we do reverse of a number and got the same number then its a palindrone
     * number.
     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number");

        int n = s.nextInt();

        System.out.println(isPalindrome(n));

    }

    public static boolean isPalindrome(int n) {
        int rev = reverseNum(n);
        if (rev == n) {
            return true;
        } else
            return false;
    }

    public static int reverseNum(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans = ans * 10 + rem;
            n = n / 10;
        }
        return ans;
    }
}
