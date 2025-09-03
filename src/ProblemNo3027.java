import java.util.Arrays;

public class ProblemNo3027 {
    public static void main(String[] args) {

        ProblemNo3027.Solution a = new ProblemNo3027().new Solution();
        System.out.println(a.numberOfPairs(new int[][]{
                {0,0},{0,3}
        }));

    }

    class Solution {
        public int numberOfPairs(int[][] points) {

            Arrays.sort(points, (a,b) ->{
                if(a[0] != b[0]) return a[0] - b[0];
                else return b[1] - a[1];
            });

            int ans = 0;
            int n = points.length;

            for(int i=0; i<n; i++){
                int[] A = points[i];

                int maxY = Integer.MIN_VALUE;
                for(int j=i+1; j<n; j++){
                    int[] B =  points[j];

                    if(B[1] > A[1]) continue;

                    if(B[1] > maxY){
                        ans++;
                        maxY = B[1];
                    }
                }

            }

            return ans;
        }
    }

}
