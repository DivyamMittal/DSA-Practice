package BinarySearch.Medium;

public class FindNthRootOfInteger {
    /*
     * Given two numbers N and M, find the Nth root of M. The Nth root of a number M
     * is defined as a number X such that when X is raised to the power of N, it
     * equals M. If the Nth root is not an integer, return -1.
     * 
     * Input: N = 3, M = 27
     * Output: 3
     * 
     * Input: N = 4, M = 81
     * Output: 3
     */

    public static void main(String[] args) {
        int n = 4;
        int m = 81;

        System.out.println(NthRoot(n, m));
    }

    public static int NthRoot(int N, int M) {
        int left = 1;
        int right = M;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midN = func(mid, N, M);

            if(midN == 1){
                return mid;
            }else if(midN == 0){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return -1;
    }

    // -----------HELPER------------------
    private static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans * mid;
            if (ans > m) {
                return 2;
            }
        }
        if (ans == m)
            return 1;
        else
            return 0;
    }
}
