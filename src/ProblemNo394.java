import java.util.Stack;

public class ProblemNo394 {
    public static void main(String[] args) {

        Solution a = new ProblemNo394().new Solution();
        System.out.println(a.decodeString("3[a]2[bc]"));
        System.out.println(a.decodeString("3[a2[c]]"));
        System.out.println(a.decodeString("2[abc]3[cd]ef"));
        System.out.println(a.decodeString("abc3[cd]xyz"));

    }

    class Solution {
        public String decodeString(String s) {
            Stack<String> stack = new Stack<>();
            Stack<Integer> times = new Stack<>();
            times.push(0);

            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (c == '[') {
                    stack.push(c + "");
                    flag = false;
                }
                else if (c == ']') {
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty() && !stack.peek().equals("[")) {
                        sb.insert(0,stack.pop());
                    }
                    sb.repeat(sb, times.pop()-1);
                    stack.pop();
                    stack.push(sb.toString());

                    flag = false;
                }
                else if (Character.isDigit(c)) {
                    if  (!flag) {
                        times.push(c - '0');
                        flag = true;
                    }
                    else times.push(times.pop() * 10 + (c - '0'));
                }
                else {
                    stack.push(c + "");
                    flag = false;
                }

            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) sb.insert(0, stack.pop());
            return sb.toString();
        }
    }

}
