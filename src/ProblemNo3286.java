import java.util.*;

public class ProblemNo3286 {
    public static void main(String[] args) {
        int[][] ae = {{1,0,1,1},{0,0,0,1},{1,0,1,1},{0,1,1,0},{1,0,0,1}};

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<ae.length;i++){
            list.add(new ArrayList<>());
            for (int j: ae[i]){
                list.get(i).add(j);
            }
        }


        Solution a = new ProblemNo3286().new Solution();
        System.out.println(a.findSafeWalk(list, 4));

    }

    class Solution {
        public boolean findSafeWalk(List<List<Integer>> grid, int health) {
            final int rows = grid.size(), cols = grid.getFirst().size();
            final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            Queue<int[]> queue = new LinkedList<>(); // it will have {row, col, health}
            int[][] cost = new int[rows][cols];

            queue.offer(new int[]{0, 0});
            cost[0][0] = health - grid.getFirst().getFirst();

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curHealth = cost[cur[0]][cur[1]];

                for (int[] dir : DIR) {
                    int nextRow = cur[0] + dir[0];
                    int nextCol = cur[1] + dir[1];

                    if (sanityChecker(nextRow, nextCol, rows, cols) &&
                            curHealth - grid.get(nextRow).get(nextCol) >= 1
                    ) {
                        if (curHealth - grid.get(nextRow).get(nextCol) > cost[nextRow][nextCol]) queue.offer(new int[]{nextRow, nextCol});
                        cost[nextRow][nextCol] = Math.max(cost[nextRow][nextCol], curHealth - grid.get(nextRow).get(nextCol));
                    }
                }
            }

            return cost[rows-1][cols-1] >= 1;
        }

        private boolean sanityChecker(int newX, int newY, int rows, int cols) {
            return newX >= 0 && newY >= 0 && newX < rows && newY < cols;
        }

    }

}
