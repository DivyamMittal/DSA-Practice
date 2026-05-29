package Strings.Easy;

public class LargestOddNumberInString {

    /*
     * Example 1
     * Input : s = "5347"
     * Output : "5347"
     * Explanation :
     * The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.
     * So the largest among all the possible odd numbers for given string is 5347.
     * Example 2
     * Input : s = "0214638"
     * Output : "21463"
     */

    public static void main(String[] args) {
        String s = "5347";

        System.out.println(findLargest(s));
    }

    static String findLargest(String s) {
        int start = 0;
        int idx = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            int num = ch - '0';
            if (num % 2 != 0) {
                idx = i;
                break;
            }
        }

        if(idx == -1){
            return "";
        }

        while(start <= idx && s.charAt(start) == '0'){
            start++;
        }

        return s.substring(start, idx+1);

    }
}
