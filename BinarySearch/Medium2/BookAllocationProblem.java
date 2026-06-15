package BinarySearch.Medium2;

public class BookAllocationProblem {
    /*
     * Given an array nums of n integers, where nums[i] represents the number of
     * pages in the i-th book, and an integer m representing the number of students,
     * allocate all the books to the students so that each student gets at least one
     * book, each book is allocated to only one student, and the allocation is
     * contiguous.
     * 
     * Allocate the books to m students in such a way that the maximum number of
     * pages assigned to a student is minimized. If the allocation of books is not
     * possible, return -1.
     * 
     * Input: nums = [25, 46, 28, 49, 24], m=4
     * Output: 71
     */

    public static void main(String[] args) {
        int[] nums = { 25, 46, 28, 49, 24 };
        int m = 4;

        System.out.println(findPages(nums, m));
        System.out.println(findPagesOptimize(nums, m));
    }

    // using binary search
    public static int findPagesOptimize(int[] nums, int m) {
        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        int low = max;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (countStudents(nums, mid) > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // linear search
    public static int findPages(int[] nums, int m) {
        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        for (int i = max; i <= sum; i++) {
            if (countStudents(nums, i) <= m) {
                return i;
            }
        }

        return max;
    }

    private static int countStudents(int[] nums, int pages) {
        int student = 1;
        int pageCount = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] + pageCount <= pages) {
                pageCount += nums[i];
            } else {
                student++;
                pageCount = nums[i];
            }
        }
        return student;
    }
}
