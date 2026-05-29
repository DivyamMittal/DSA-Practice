public class Print_all_divisors {

    public static void main(String[] args) {
        int n = 36;

        printAllDivisors(n);
        System.out.println();
        printAllDivisorsOptimised(n);

    }

    // Brute Force
    public static void printAllDivisors(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // Optimised
    public static void printAllDivisorsOptimised(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != n / i) {
                    System.out.print(n / i + " ");
                }
            }

        }

        // or can use list to store the elements and later sort them
    }
    // T - O(sqrt(n))
    // S - O(1)

}