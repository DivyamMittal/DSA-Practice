package Math;

public class Prime_number {
    public static void main(String[] args) {
        int n = 23;

        System.out.println("Checking for prinme number");

        System.out.println(isPrime(n));
        System.out.println(isPrimeOptimised(n));
    }

    // BruteForce Approach
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i * j == n) {
                    return false;
                }
            }
        }
        return true;
    }
    // T - O(n^2)
    // S - O(1)

    // Optimised Approach
    public static boolean isPrimeOptimised(int n) {
        int cnt = 0;

        for (int i = 1; i * i < n; i++) {
            if (n % i == 0) {
                cnt++;
                if (i != n / i) {
                    cnt++;
                }
            }
        }
        if (cnt == 2)
            return true;
        else
            return false;

    }
    // T - O(sqrt(n))
    // S - O(1)

}
