package Recursion.Easy;

public class FactorialOfGivenNumber {
    /*
     * Given an integer n, return the factorial of n.
     * Factorial of a non-negative integer, is the multiplication of all integers
     * smaller than or equal to n (use 64-bits to return answer).
     * Input : n = 3
     * 
     * Output : 6
     */

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));

    }

    static public long factorial(int n) {
        if(n == 0)
            return 1;

        return n * factorial(n-1);
    }
}
