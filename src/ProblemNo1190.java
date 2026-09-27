import java.util.Stack;

public class ProblemNo1190 {

    public static void main(String[] args) {

        Solution a = new ProblemNo1190().new Solution();
        System.out.println(a.reverseParentheses("(abcd)"));
        System.out.println(a.reverseParentheses("(u(love)i)"));
        System.out.println(a.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(a.reverseParentheses("(abc)(def)"));
        System.out.println(a.reverseParentheses("g(abc)h(def)i"));
        System.out.println(a.reverseParentheses("()"));
        System.out.println(a.reverseParentheses("abncd"));

    }

    class Solution {
        public String reverseParentheses(String s) {
            StringBuilder curr = new StringBuilder();
            Stack<String> stack = new Stack<>();

            for (char c:  s.toCharArray()) {

                if (Character.isAlphabetic(c)) curr.append(c);
                else if (c == '(') {
                    stack.push(curr.toString());
                    curr = new StringBuilder();
                }
                else if (c == ')'){
                    curr.reverse();
                    String prev = stack.pop();
                    curr.insert(0, prev);
                }
            }


            return curr.toString();
        }
    }

}
