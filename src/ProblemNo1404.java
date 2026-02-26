import java.util.Stack;

public class ProblemNo1404 {
    public static void main(String[] args) {
        ProblemNo1404.Solution p = new ProblemNo1404().new Solution();
        System.out.println(p.numSteps("1101"));
        System.out.println(p.numSteps("1"));
        System.out.println(p.numSteps("10"));
    }

    class Solution {
        public int numSteps(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) stack.push(c);

            int carry = 0;
            int count = 0;
            while (stack.size() > 1) {
                count++;
                int val = stack.pop() - '0';

                if (carry == 0) {
                    if (val == 1){
                        carry = 1;
                        count++;
                    }
                }
                else { // for 1 == carry
                    if (val == 0) {
                        stack.push('1');
                    }
                }
            }

            if (carry == 1) count++;

            return count;
        }
    }

}
