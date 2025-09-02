public class ProblemNo3025 {
    public static void main(String[] args) {

    }

    class Solution {
        public int numberOfPairs(int[][] points) {
            int ans = 0;
            int n = points.length;

            for(int i=0; i<n; i++){
                int[] A = points[i];

                for(int j=0; j<n; j++){
                    int[] B =  points[j];

                    if(i == j || !(B[0] >= A[0] && B[1] <= A[1])) continue;
                    if(n == 2){
                        ans++;
                        continue;
                    }

                    boolean illegal = false;
                    for(int k=0; k<n; k++){
                        if(k==i ||  k==j) continue;

                        int[] pointTemp = points[k];
                        boolean isXContained = pointTemp[0] >= A[0] && pointTemp[0] <= B[0];
                        boolean isYContained = pointTemp[1] <= A[1] && pointTemp[1] >= B[1];

                        if(isXContained && isYContained) {
                            illegal = true;
                            break;
                        }
                    }

                    if(!illegal) ans++;

                }

            }

            return ans;
        }
    }

}
