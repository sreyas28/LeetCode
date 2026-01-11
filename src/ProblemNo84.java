import java.util.Stack;

public class ProblemNo84 {
    public static void main(String[] args) {
        ProblemNo84.Solution p = new ProblemNo84().new Solution();
        System.out.println(p.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    // O(n)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i <= heights.length; i++) {
                int h = i == heights.length ? 0 : heights[i];

                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, width * height);
                }

                stack.push(i);
            }


            return maxArea;
        }
    }


    // O(n^2)
    class Solution_ {
        public int largestRectangleArea(int[] heights) {
            int maxArea = heights[0];

            for (int i = 0; i < heights.length; i++) {
                int min = heights[i];
                maxArea = Math.max(maxArea, min);
                if (min == 0) continue;

                for (int j = i + 1; j < heights.length; j++) {
                    min = Math.min(min, heights[j]);
                    maxArea = Math.max(maxArea, (j - i + 1) * min);
                }
            }

            return maxArea;
        }
    }

}
