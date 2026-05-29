package BasicRecursion;

import java.util.*;

public class ReverseAString {
    /*
     * Given an input string as an array of characters, write a function that
     * reverses the string.
     * Input : s = ["h", "e", "l", "l", "o"]
     * 
     * Output : ["o", "l", "l", "e", "h"]
     */

    public static void main(String[] args) {
        ArrayList<Character> s = new ArrayList<Character>(List.of('h', 'e', 'l', 'l', 'o'));

        s = reverseString(s);
        System.out.println(s);

    }

    static public ArrayList<Character> reverseString(ArrayList<Character> s) {
        reverse(s, 0, s.size() - 1);
        return s;
    }

    static public void reverse(ArrayList<Character> s, int start, int end) {
        if (start >= end) {
            return;
        }

        char temp = s.get(start);
        s.set(start, s.get(end));
        s.set(end, temp);

        reverse(s, start + 1, end - 1);
    }
}
