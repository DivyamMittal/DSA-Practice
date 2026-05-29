package BasicStrings1;

public class ReverseWordInString {
    /*
     * Given an input string s, reverse the order of the words.
     * 
     * A word is defined as a sequence of non-space characters. The words in s will
     * be separated by at least one space.
     * 
     * Return a string of the words in reverse order concatenated by a single space.
     * 
     * Note that s may contain leading or trailing spaces or multiple spaces between
     * two words. The returned string should only have a single space separating the
     * words. Do not include any extra spaces.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     * Example 2:
     * 
     * Input: s = "  hello world  "
     * Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing
     * spaces.
     */

    public static void main(String[] args) {
        String str = "  hello    world  ";
        String[] arr = str.split(" +");

        StringBuilder ans = new StringBuilder();

        for(int i = arr.length - 1; i>=0; i--){
            ans.append(arr[i]);
            ans.append(" ");
        }

        System.out.println(ans.toString().trim());

    }

}
