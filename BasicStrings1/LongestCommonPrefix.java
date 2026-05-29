package BasicStrings1;

public class LongestCommonPrefix {
    /*
     * Write a function to find the longest common prefix string amongst an array of
     * strings.
     * 
     * If there is no common prefix, return an empty string "".
     * 
     * Example 1
     * Input : str = ["flowers" , "flow" , "fly", "flight" ]
     * Output : "fl"
     */

    public static void main(String[] args) {
        String[] str = { "flowers", "flow", "fly", "flight" };

        System.out.println(commonPrefix(str));
    }

    static String commonPrefix(String[] str) {

        if (str.length <= 1) {
            return "";
        }

        // find the smallest string length
        int smallLength = str[0].length();

        for (int i = 0; i < str.length; i++) {
            int len = str[i].length();
            smallLength = Math.min(smallLength, len);
        }

        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < smallLength; i++) {
            char ch = str[0].charAt(i);

            for (int j = 0; j < str.length; j++) {
                if (ch != str[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(ch);
        }

        return res.toString();
    }
}
