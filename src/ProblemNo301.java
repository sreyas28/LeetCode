import java.util.*;

public class ProblemNo301 {
    public static void main(String[] args) {

        Solution a = new ProblemNo301().new Solution();
        System.out.println(a.removeInvalidParentheses("()())()"));
        System.out.println(a.removeInvalidParentheses("(a)())()"));
        System.out.println(a.removeInvalidParentheses(")("));
    }

    class Solution {
        private Set<String> res;
        private int minSize;

        public List<String> removeInvalidParentheses(String s) {
            this.res = new HashSet<>();
            this.minSize = 0;
            ways(0, s, 0, "");

            return new ArrayList<>(res);
        }

        private void ways(int i, String s, int balance, String madeSoFar) {
            if (i == s.length()) {
                if (balance == 0 && madeSoFar.length() >= this.minSize) {
                    this.res.add(madeSoFar);
                    this.minSize = madeSoFar.length();
                }
                return;
            } else if (balance < 0) return;


            char curr = s.charAt(i);
            if (!Character.isAlphabetic(curr)) {
                if (curr == '(') ways(i + 1, s, balance + 1, madeSoFar + curr);
                else if (curr == ')') ways(i + 1, s, balance - 1, madeSoFar + curr);
                ways(i + 1, s, balance, madeSoFar); // skip
            } else ways(i + 1, s, balance, madeSoFar + curr);
        }

    }

}
