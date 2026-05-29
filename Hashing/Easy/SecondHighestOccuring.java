package Hashing.Easy;

import java.util.*;

public class SecondHighestOccuring {
    /*
     * Given an array of n integers, find the second most frequent element in it.
     * 
     * If there are multiple elements that appear second most frequent times, find
     * the smallest of them.
     * 
     * If second most frequent element does not exist return -1.
     * 
     * Example 1
     * Input: arr = [1, 2, 2, 3, 3, 3]
     * Output: 2
     */
    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 2 };

        if (arr.length <= 1) {
            System.out.println(-1);
            return;
        }

        int highestKey = -1;
        int highestValue = 0;
        int secondHighestKey = -1;
        int secondHighestValue = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();

            if (freq > highestValue) {
                secondHighestValue = highestValue;
                highestValue = freq;
                secondHighestKey = highestKey;
                highestKey = element;
            } else if (freq < highestValue && freq > secondHighestValue) {
                secondHighestValue = freq;
                secondHighestKey = element;
            } else if (freq < highestValue && freq == secondHighestValue) {
                secondHighestKey = Math.min(secondHighestKey, element);
            }
        }

        if (secondHighestValue == 0) {
            System.out.println(-1);
        } else {
            System.out.println(secondHighestKey);
        }

    }
}
