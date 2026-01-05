import java.util.Arrays;
import java.util.PriorityQueue;

public class ProblemNo1975 {
    public static void main(String[] args) {
        ProblemNo1975.Solution sol = new ProblemNo1975().new Solution();
//        System.out.println(sol.maxMatrixSum(new int[][]{{1,2,3},{-1,-2,-3},{1,2,3}}));
//        System.out.println(sol.maxMatrixSum(new int[][]{{-1,0,-1},{-2,1,3},{3,2,2}}));
        System.out.println(sol.maxMatrixSum(new int[][]{{2,9,3},{5,4,-4},{1,7,1}}));
    }

    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            long sum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int minVal = Integer.MAX_VALUE;
            // getting all negative numbers
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j] >= 0) {
                        sum += matrix[i][j];
                        minVal = Math.min(minVal,matrix[i][j]);
                    }
                    else if(matrix[i][j] < 0) pq.offer(matrix[i][j]);
                }
            }

            while(pq.size() > 1){
                int valA =  Math.abs(pq.poll());
                int valB =  Math.abs(pq.poll());

                sum += valA + valB;
            }

            if(!pq.isEmpty() && Math.abs(pq.peek()) > minVal) sum = sum - (2L *minVal) + Math.abs(pq.poll());
            else if(!pq.isEmpty()) sum += pq.poll();

            return sum;
        }
    }


}
