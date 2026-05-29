package Strings.Easy;

import java.util.*;

public class ValidAnagram {
    /*
     * Given two strings s and t, return true if t is an anagram of s, and false
     * otherwise.
     * 
     * An Anagram is a word or phrase formed by rearranging the letters of a
     * different word or phrase, typically using all the original letters exactly
     * once.
     * 
     * Input : s = "anagram" , t = "nagaram"
     * Output : true
     */

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(anagramStrings(s, t));
    }

    static public boolean anagramStrings(String s, String t) {
        // base check
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        // iterate first string
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map1.get(entry.getKey()).equals(map2.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }
    // TC - O(N), SC - O(2*N)

    static public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
