public class ProblemNo1614 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxDepth(String s) {
            int max = 0;
            int cur = 0;

            for (char c : s.toCharArray()) {
                if (c == '(')
                    cur++;
                else if (c == ')')
                    cur--;

                max = Math.max(cur, max);
            }

            return max;
        }
    }

}
