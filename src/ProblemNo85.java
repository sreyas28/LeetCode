import java.util.Stack;

public class ProblemNo85 {
    public static void main(String[] args) {
        ProblemNo85.Solution p = new ProblemNo85().new Solution();
        System.out.println(p.maximalRectangle(new char[][]{{'1','0'},{'1','0'}}));
    }

    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int[][] heights = new int[matrix.length][matrix[0].length];

            for(int col = 0; col < matrix[0].length; col++){
                for(int row = 0; row < matrix.length; row++){
                    if(row == 0) heights[row][col] = matrix[row][col] - '0';
                    else if (matrix[row][col] == '0') heights[row][col] = 0;
                    else heights[row][col] = heights[row-1][col] + (matrix[row][col] - '0');
                }
            }


            int maxArea = 0;

            for (int row = 0; row < matrix.length; row++) {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i <= heights[row].length; i++) {
                    int h = i == heights[row].length ? 0 : heights[row][i];

                    while (!stack.isEmpty() && h < heights[row][stack.peek()]) {
                        int height = heights[row][stack.pop()];
                        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                        maxArea = Math.max(maxArea, width * height);
                    }

                    stack.push(i);
                }
            }


            return maxArea;
        }
    }

}
