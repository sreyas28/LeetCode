import java.util.Stack;

public class ProblemNo969 {

    public static void main(String[] args) {
        ProblemNo969.Solution p = new ProblemNo969().new Solution();
        System.out.println(p.countBinarySubstrings("101010"));
    }

    class Solution {
        public int countBinarySubstrings(String s) {
            Stack<Integer> stack = new Stack<>();

            boolean prev = s.charAt(0) != '1'; // true == 1 and false == 0

            for (char c : s.toCharArray()) {

                if(c == '1' && prev) stack.push(stack.pop() + 1);
                else if(c == '0' && !prev) stack.push(stack.pop() + 1);
                else if(c == '1'){
                    stack.push(1);
                    prev = true;
                }
                else if(c == '0'){
                    stack.push(1);
                    prev = false;
                }

            }

            int prevVal = stack.pop();
            int res = 0;
            while(!stack.isEmpty()){
                int currVal = stack.pop();
                res += Math.min(prevVal, currVal);
                prevVal = currVal;
            }

            return res;
        }
    }

}
