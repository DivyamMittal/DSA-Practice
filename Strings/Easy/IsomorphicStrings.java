package Strings.Easy;

import java.util.*;

public class IsomorphicStrings {
    /*
     * Given two strings s and t, determine if they are isomorphic. Two strings s
     * and t are isomorphic if the characters in s can be replaced to get t.
     * 
     * All occurrences of a character must be replaced with another character while
     * preserving the order of characters. No two characters may map to the same
     * character, but a character may map to itself.
     * 
     * Example 1
     * Input : s = "egg" , t = "add"
     * Output : true
     * Explanation :
     * The 'e' in string s can be replaced with 'a' of string t.
     * The 'g' in string s can be replaced with 'd' of t.
     * Hence all characters in s can be replaced to get t.
     */

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));

    }

    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ori = s.charAt(i);
            char rep = t.charAt(i);

            if (map.containsKey(ori)) {
                char mappedChar = map.get(ori);
                if (mappedChar != rep) {
                    return false;
                }
            } else {
                if (!map.containsValue(rep)) {
                    map.put(ori, rep);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}
