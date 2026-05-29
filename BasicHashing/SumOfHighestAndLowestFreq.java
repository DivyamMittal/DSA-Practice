package BasicHashing;

import java.util.*;

public class SumOfHighestAndLowestFreq {
    /*
     * Given an array of n integers, find the sum of the frequencies of the highest
     * occurring number and lowest occurring number.
     * 
     * Example 1
     * Input: arr = [1, 2, 2, 3, 3, 3]
     * Output: 4
     */

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3, 3, 4, 4, 4 };

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int minValue = Integer.MAX_VALUE;
        int minKey = -1;
        int maxValue = Integer.MIN_VALUE;
        int maxKey = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }

            if (entry.getValue() < minValue) {
                minValue = entry.getValue();
                minKey = entry.getKey();
            }
        }

        System.out.println(minValue + maxValue);
    }
}
