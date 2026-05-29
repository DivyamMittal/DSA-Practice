public class Power_exponential {
    double x = 2.0;
    int n = -2;

    public static void main(String[] args) {

        double x = 2.0;
        int n = -2;

        double ans = myPow(x, n < 0 ? -n : n);

        if (n < 0) {
            System.out.println(1 / ans);
        } else {
            System.out.println(ans);
        }

    }

    // Brute Force
    // T - O(n)
    // S - O(1)
    public static double myPowBruteForce(double x, int n) {
        double ans = 1;

        for (int i = 0; i < n; i++) {
            ans = ans * x;
        }

        return ans;
    }

    /// Optimal approach
    /// T - O(log2(n))
    /// S - O(1)
    public static double myPow(double x, int n) {
        double ans = 1;

        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            } else {
                x = x * x;
                n = n / 2;
            }
        }

        return ans;
    }
}
