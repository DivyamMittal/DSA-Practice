package BasicStrings1;

import java.util.*;

public class RemoveOuterMostParantheseis {
    /*
     * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where
     * A and B are valid parentheses strings, and + represents string concatenation.
     * 
     * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses
     * strings.
     * Input: s = "(()())(())"
     * Output: "()()()"
     * Explanation:
     * The input string is "(()())(())", with primitive decomposition "(()())" +
     * "(())".
     * After removing outer parentheses of each part, this is "()()" + "()" =
     * "()()()".
     */

    public static void main(String[] args) {
        String s = "(()())(()())()";

        System.out.println(removeParentheses(s));
        System.out.println(removeParenthesesUsingCnt(s));
    }

    static String removeParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (st.size() > 0) {
                    ans.append(ch);
                }
                st.push(ch);

            } else {
                st.pop();
                if (st.size() > 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    static String removeParenthesesUsingCnt(String str) {
        StringBuilder res = new StringBuilder();
        int lvl = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                if (lvl > 0) {
                    res.append(ch);
                }
                lvl++;
            } else {
                lvl--;
                if (lvl > 0) {
                    res.append(ch);
                }
            }
        }

        return res.toString();

    }
}
