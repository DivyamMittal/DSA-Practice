import java.util.*;

class ArmstrongNumber {

    /*
     * Armstrong number = 371 -> (3*3*3)+(7*7*7)+(1*1*1) = 371
     */

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter a number");

            int n = s.nextInt();

            System.out.println(isArmstrong(n));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static boolean isArmstrong(int n) {
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            int rem = temp % 10;
            sum = sum + (rem * rem * rem);
            temp = temp / 10;
        }

        if (sum == n)
            return true;
        else
            return false;
    }
}