import java.util.*;

public class Reverse_of_a_number {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = scanner.nextInt();

        int ans = reverseNum(n);
        System.out.println("Ans is: " + ans);
    }

    public static int reverseNum(int n) {
        int ans = 0;

        while (n > 0) {
            int rem = n % 10;
            ans = ans * 10 + rem;
            n = n / 10;
        }
        return ans;
    }
}

// TC:O(n)
// SC:O(1)