package Math;

public class Sieve_of_eratosthenes {

    // Print all prime number till N

    public static void main(String[] args) {
        int n = 37;
        sieveOfEratosthenes(n);
    }

    /// T - O(n) + O(nlog(log(n)))
    /// S - O(n+1)
    public static void sieveOfEratosthenes(int n) {
        int[] primeArr = new int[n + 1];

        // storing all values 1 in the array
        for (int i = 0; i < primeArr.length; i++) {
            primeArr[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (primeArr[i] == 1) {
                System.out.print(i + " ");
                for (int j = i * i; j <= n; j += i) {
                    primeArr[j] = 0;
                }
            }
        }
    }

}