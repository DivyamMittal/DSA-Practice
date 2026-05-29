package Hashing.Easy;

import java.util.*;

public class HighestOccuringElement {
    public static void main(String[] args) {
        /*
         * Example 1
         * Input: nums = [1, 2, 2, 3, 3, 3]
         * Output: 3
         */

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = { 1, 2, 2, 3, 3, 3 };
        int max = 0;

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        System.out.println(max);

    }
}
