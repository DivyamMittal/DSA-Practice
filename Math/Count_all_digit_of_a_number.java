package Math;


import java.util.*;

class CountAllDigitOfANumber {

    public static void main(String[] args) {
        try (Scanner Scanner = new Scanner(System.in)) {
            System.out.println("Enter a number");

            int n = Scanner.nextInt();

            System.out.println(countNumber(n));
            System.out.println(countNumberUsingLog(n));
        }

    }

    static int countNumber(int n) {
        int cnt = 0;

        while (n > 0) {
            cnt++;
            n = n / 10;
        }
        return cnt;
    }

    static int countNumberUsingLog(int n) {
        int ans = (int) (Math.log10(n) + 1);
        return ans;
    }
}