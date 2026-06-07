package BinarySearch.Medium;

public class FindSqrtOfANumber {
    /*
     * Given a positive integer n. Find and return its square root. If n is not a
     * perfect square, then return the floor value of sqrt(n).
     * 
     * Input: n = 28
     * Output: 5
     */

    public static void main(String[] args) {
        int n =28;
        System.out.println(floorSqrt(n));
    }

    public static int floorSqrt(int n) {
        int ans = 1;

        int left = 1;
        int right = n;

        while(left <= right){
            int mid= (left + right) / 2;
            if( (long)(mid * mid)<= (long)n){
                ans = mid;
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }

        return  ans;
    }
}
