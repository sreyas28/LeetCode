import java.util.Stack;

public class ProblemNo921 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minAddToMakeValid(String s) {
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(')');
                else {
                    if (stack.isEmpty()) count++;
                    else stack.pop();
                }
            }

            count += stack.size();
            return count;
        }
    }

}
