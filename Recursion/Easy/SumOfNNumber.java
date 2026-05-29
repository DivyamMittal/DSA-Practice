package Recursion.Easy;

public class SumOfNNumber {
    /*
     * Given an integer N, return the sum of first N natural numbers. Try to solve
     * this using recursion.
     * Input : N = 4
     * Output : 10
     * 
     * Constraints
     * 1 <= N <= 10^3
     */

    public static void main(String[] args) {

        int N = 4;
        System.out.println(NnumbersSum(N));
    }

    static public int NnumbersSum(int N) {
        if (N == 0)
            return 0;

        return N + NnumbersSum(N - 1);

    }

}
