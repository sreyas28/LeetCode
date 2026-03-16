import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ProblemNo1878 {
    public static void main(String[] args) {
        ProblemNo1878.Solution p = new ProblemNo1878().new Solution();
        System.out.println(Arrays.toString(p.getBiggestThree(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    class Solution {
        private int rows, cols;
        private int[][] grid;

        private PriorityQueue<Integer> minHeap;

        public int[] getBiggestThree(int[][] grid) {
            this.grid = grid;

            rows = grid.length;
            cols = grid[0].length;

            minHeap = new PriorityQueue<>();


            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    addInHeap(grid[row][col]);
                    increasing(row, col, col, 0);
                }
            }


            ArrayList<Integer> list = new ArrayList<>();
            while(!minHeap.isEmpty()) {
                list.addFirst(minHeap.poll());
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private void increasing(int row, int left, int right, int sum) {
            int currentSum = sum + (left == right ? grid[row][left] : grid[row][left] + grid[row][right]);
            left--;
            right++;
            row++;

            if (!(left < 0 || right > cols - 1 || row > rows - 1))  // max size we can attain
                increasing(row, left, right, currentSum);


            decreasing(row, left + 2, right - 2, currentSum);
        }

        private void decreasing(int row, int left, int right, int sum) {
            if (left == right && row < rows) addInHeap(sum + grid[row][left]);

            if (row > rows - 1 || left > right) return;
            decreasing(row + 1, left + 1, right - 1, sum + grid[row][left] + grid[row][right]);
        }

        private void addInHeap(int val) {
            if (!minHeap.contains(val)) minHeap.add(val);

            if (minHeap.size() > 3)
                minHeap.poll();
        }

    }

}
