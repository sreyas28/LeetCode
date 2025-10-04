import java.util.Arrays;
import java.util.PriorityQueue;

public class ProblemNo407 {
    public static void main(String[] args) {

        int[][] map = {
                {1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}
        };

        ProblemNo407.Solution a = new ProblemNo407().new Solution();
        System.out.println(a.trapRainWater(map));

    }

    class Solution {
        public int trapRainWater(int[][] heightMap) {
            int rows = heightMap.length;
            int cols = heightMap[0].length;
            boolean[][] visited = new boolean[rows][cols];

            PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a,b) -> {
                if (a[0] != b[0])return a[0] - b[0];
                else if(a[1] != b[1]) return a[1] - b[1];
                return a[2] - b[2];
            } );

            // first and last Row.
            for(int col = 0; col < cols; col++){
                minHeap.offer(new int[]{heightMap[0][col], 0, col});
                minHeap.offer(new int[]{heightMap[rows - 1][col], rows - 1, col});

                visited[0][col] = true;
                visited[rows-1][col] = true;
            }

            // first and last Col.
            for(int row = 1; row < rows - 1; row++){
                minHeap.offer(new int[]{heightMap[row][0], row, 0});
                minHeap.offer(new int[]{heightMap[row][cols -1 ], row, cols - 1});

                visited[row][0] = true;
                visited[row][cols-1] = true;
            }

            int water = 0;
            int[][] vectorDirection = {{0,-1}, {-1,0}, {0,1}, {1,0}};

            while(!minHeap.isEmpty()) {
                int[] current = minHeap.poll();
                int height = current[0];
                int i = current[1];
                int j = current[2];

                for(int[] direction: vectorDirection){
                    int i_ = i + direction[0];
                    int j_ = j + direction[1];

                    if(i_ >= 0 && j_ >= 0 && i_ < rows && j_ < cols && !visited[i_][j_]){
                        water += Math.max(0, height - heightMap[i_][j_]);
                        visited[i_][j_] = true;
                        minHeap.offer(new int[]{Math.max(height, heightMap[i_][j_]), i_, j_});
                    }
                }
            }

            return water;
        }
    }

}
