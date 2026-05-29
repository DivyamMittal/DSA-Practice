package BasicRecursion;

public class PrimeCheck {
    /*
     * Given an integer num, return true if it is prime otherwise false.
     * A prime number is a number that is divisible only by 1 and itself.
     * Input : num = 5
     * 
     * Output : true
     */

    public static void main(String[] args) {
        int num = 5;

        System.out.println(checkPrime(num));
    }

    static public boolean checkPrime(int num) {
        if (num <= 1) {
            return false;
        }
        return check(num, 2);
    }

    private static boolean check(int num, int x){
        if(x*x > num){
            return true;
        }

        if(num % x == 0){
            return false;
        }

        return check(num, x+1);
    }
}
