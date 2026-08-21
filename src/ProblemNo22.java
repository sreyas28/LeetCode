import java.util.*;

public class ProblemNo22 {
    public static void main(String[] args) {

        Solution a = new ProblemNo22().new Solution();
        System.out.println(a.generateParenthesis(3));

    }

    class Solution {
        private List<String> res;

        public List<String> generateParenthesis(int n) {
            this.res = new ArrayList<>();
            generateDFS("(", 1, 0, n);
            return res;
        }

        private void generateDFS(String s, int openParenthesis, int closeParenthesis, int n) {
            if (openParenthesis == closeParenthesis && openParenthesis == n) {
                res.add(s);
                return;
            }

            if (openParenthesis < n) generateDFS(s + "(", openParenthesis + 1, closeParenthesis, n);
            if (openParenthesis > closeParenthesis) generateDFS(s + ")", openParenthesis, closeParenthesis + 1, n);
        }

    }

}
