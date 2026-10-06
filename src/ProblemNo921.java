import java.util.Stack;

public class ProblemNo921 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minAddToMakeValid(String s) {
            int balance = 0;
            int count = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') balance++;
                else {
                    if (balance == 0) count++;
                    else balance--;
                }
            }

            count += balance;
            return count;
        }
    }

    // a bit slower
    class Solution_ {
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
