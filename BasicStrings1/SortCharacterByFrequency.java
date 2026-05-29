package BasicStrings1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharacterByFrequency {
    /*
     * You are given a string s. Return the array of unique characters, sorted by
     * highest to lowest occurring characters.
     * 
     * If two or more characters have same frequency then arrange them in alphabetic
     * order.
     * 
     * Input : s = "tree"
     * 
     * Output : ['e', 'r', 't' ]
     */

    public static void main(String[] args) {
        String s = "tree";

        List<Character> ans = frequencySort(s);

        System.out.println(ans);

    }

    static public List<Character> frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> pq = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        List<Character> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : map.keySet()) {
            pq.offer(ch);
        }

        while (!pq.isEmpty()) {
            char ch = pq.poll();
            for (int i = 0; i < map.get(ch); i++) {
                res.add(ch);
            }
        }

        return res;

    }
}
