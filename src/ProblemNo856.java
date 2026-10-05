public class ProblemNo856 {
    public static void main(String[] args) {

        Solution a = new ProblemNo856().new Solution();
//        System.out.println(a.scoreOfParentheses("(()()()(()))"));
//        System.out.println(a.scoreOfParentheses("()()()()()"));
        System.out.println(a.scoreOfParentheses("(())()"));

    }

    class Solution {
        public int scoreOfParentheses(String s) {
            return recursion(0, s)[1] / 2;
        }

        private int[] recursion(int i, String s) {
            if (s.charAt(i) == ')') return new int[]{i + 1, 1}; // index, sum

            int sum = 0;

            while (i < s.length()) {
                if (s.charAt(i) == '(') {
                    int[] res = recursion(i + 1, s);
                    sum += res[1];
                    i = res[0];
                } else if (s.charAt(i) == ')') {
                    i++;
                    break;
                }
            }

            return new int[]{i, sum * 2};
        }
    }

}
