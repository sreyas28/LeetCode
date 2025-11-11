import java.util.*;

public class ProblemNo3542 {
    public static void main(String[] args) {
        ProblemNo3542.Solution a = new ProblemNo3542().new Solution();
        System.out.println(a.minOperations(new int[]{1,2,1,2,1,0}));
    }
    class Solution {
        public int minOperations(int[] nums) {
            int operations = 0;
            List<Integer> list = new ArrayList<>();

            for (int i : nums) {
                while (!list.isEmpty() && list.getLast() > i) {
                    list.removeLast();
                }
                if (i == 0) continue;
                if (list.isEmpty() || list.getLast() < i) {
                    list.add(i);
                    operations++;
                }
            }

            return operations;

        }
    }
    class Solution_ {
        public int minOperations(int[] nums) {
            int operations = 0;
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i : nums) {
                if (i == 0) continue;
                while (!stack.isEmpty() && stack.peek() > i) stack.pop();

                if (stack.isEmpty() || stack.peek() < i) {
                    stack.push(i);
                    operations++;
                }
            }

            return operations;
        }
    }

}
