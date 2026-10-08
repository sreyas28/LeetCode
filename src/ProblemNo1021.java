public class ProblemNo1021 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1021().new Solution();
        System.out.println(a.removeOuterParentheses("(()())(())"));
        System.out.println(a.removeOuterParentheses("(()())(())(()(()))"));

    }

    class Solution {
        public String removeOuterParentheses(String s) {
            int i = 0;
            StringBuilder res = new StringBuilder();

            while (i < s.length()) {
                int balance = 0;
                StringBuilder inner = new StringBuilder();

                i++; // for (
                while (balance >= 0) {
                    if (s.charAt(i) == '(') balance++;
                    else balance--;

                    if (balance >= 0) inner.append(s.charAt(i++));
                }

                if (!inner.isEmpty()) res.append(inner.toString());
                i++; // for )
            }

            return res.toString();
        }
    }

    // Wrong Interpretation
    class Solution_ {
        public String removeOuterParentheses(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    if (sb.charAt(sb.length() - 1) == '(') continue;
                    sb.append('(');
                } else if (s.charAt(i) == ')') {
                    if (sb.charAt(sb.length() - 1) == ')') continue;
                    sb.append(')');
                }
            }


            return sb.toString();
        }
    }

}
