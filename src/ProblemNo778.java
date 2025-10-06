import java.util.PriorityQueue;

public class ProblemNo778 {
    public static void main(String[] args) {

        ProblemNo778.Solution a = new ProblemNo778().new Solution();
        System.out.println(a.swimInWater(new int[][]{
                {0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}
        }));

    }


    class Solution {
        public int swimInWater(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;

            boolean[][] visited = new boolean[rows][cols];
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
            int[][] Directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

            minHeap.offer(new int[]{grid[0][0], 0, 0});

            while(!minHeap.isEmpty()){

                int[] current = minHeap.poll();
                int currentTime = current[0], i = current[1], j = current[2];

                if(visited[i][j]) continue;
                visited[i][j] = true;

                if(i == rows - 1 && j == cols - 1) return currentTime;

                for(int[] dir: Directions){
                    int newI = i + dir[0], newJ = j + dir[1];
                    if(newI >= 0 && newJ >= 0 && newI < rows && newJ < cols && !visited[newI][newJ]){
                        minHeap.offer(new int[]{Math.max(grid[newI][newJ], currentTime), newI, newJ});
                    }
                }

            }

            return -1;
        }
    }


    // DFS
    class Solution_ {

        private boolean[][] visited;

        public int swimInWater(int[][] grid) {
            visited = new boolean[grid.length][grid[0].length];
            return DFS(0, 0, grid, 0);
        }

        private int DFS(int i, int j, int[][] grid, int currentTime){
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return Math.max(grid[i][j], currentTime);
            }

            visited[i][j] = true;
            int time = Integer.MAX_VALUE;

            int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && !visited[ni][nj]) {
                    time = Math.min(time, DFS(ni, nj, grid, Math.max(grid[i][j], currentTime)));
                }
            }

            visited[i][j] = false;
            return time;
        }

    }

}
