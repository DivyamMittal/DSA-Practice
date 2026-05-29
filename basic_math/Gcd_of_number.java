import java.util.*;

public class Gcd_of_number {
    public static void main(String[] args) {
        System.out.println("GCD of a number");
        int n1 = 10, n2 = 50;

        int ans = findGCD(n1, n2);

        System.out.println(ans);
        System.out.println(findGcdOptimal(n1, n2));
    }

    // Brute Force
    // T - O(min(a,b))
    // S - O(1)
    public static int findGCD(int a, int b) {
        int ans = 1;

        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                ans = i;
            }
        }
        return ans;
    }

    // Optimal Approach -> GCD(a,b) = GCD(Math.min(a,b),Math.max(a,b)%Math.min(a,b)
    public static int findGcdOptimal(int a, int b) {

        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0)
            return b;
        else
            return a;
    }
    /// T - O(log(min(a,b)))
    // S - O(1))

}
