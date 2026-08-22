import java.util.Arrays;
import java.util.Stack;

public class ProblemNo739 {
    public static void main(String[] args) {

        Solution a = new ProblemNo739().new Solution();
        System.out.println(Arrays.toString(a.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

    }

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            final int N = temperatures.length;

            Stack<int[]> stack = new Stack<>();
            int[] result = new int[N];

            for (int i = 0; i < N; i++) {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                        int[] pop = stack.pop();
                        result[pop[0]] = i - pop[0];
                    }
                }
                stack.push(new int[]{i, temperatures[i]});
            }

            return result;
        }
    }


}

