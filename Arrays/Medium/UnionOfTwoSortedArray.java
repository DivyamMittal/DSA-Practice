package Arrays.Medium;

import java.util.ArrayList;

public class UnionOfTwoSortedArray {
    /*
     * Union of two sorted arrays
     * Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
     * 
     * Output: [1, 2, 3, 4, 5, 7]
     */
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 1, 2, 7 };

        int[] res = unionArray(nums1, nums2);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] unionArray(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);

                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                    list.add(nums2[j]);

                }
                j++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);

                }
                i++;
                j++;
            }

        }

        while (i < nums1.length) {

            if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                list.add(nums1[i]);

            }
            i++;

        }

        while (j < nums2.length) {

            if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                list.add(nums2[j]);

            }
            j++;
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}