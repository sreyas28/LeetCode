import java.util.Arrays;

public class ProblemNo3363 {

    public static void main(String[] args) {

        ProblemNo3363.Solution a = new ProblemNo3363().new Solution();
        System.out.println(a.maxCollectedFruits(new int[][]
                        {{1,2,3,4}, {5,6,8,7}, {9,10,11,12}, {13,14,15,16}}
                ));

    }

    class Solution {
        public int maxCollectedFruits(int[][] fruits) {
            int sum = 0, n = fruits.length;

            // top left corner man
            for(int i = 0; i < n; i++) sum += fruits[i][i];

            // top right corner man
            int[] position = {0, n-1};
            sum += fruits[position[0]][position[1]];

            for(int i = 1; i < n - 1; i++){
                int[] tempPosition = new int[2];
                int max = 0;

                for(int j = -1; j <= 1; j++){
                    int val = position[1] + j;
                    if(i < val && val < n && fruits[i][val] > max){
                        tempPosition[0] = i;
                        tempPosition[1] = val;
                        max = fruits[i][val];
                    }
                }
                position = tempPosition;
                sum += fruits[position[0]][position[1]];
            }

            //bottom left corner man
            position = new int[] {n-1, 0};
            sum += fruits[position[0]][position[1]];

            for(int i = 1; i < n - 1; i++){
                int[] tempPosition = new int[2];
                int max = 0;

                for(int j = -1; j <= 1; j++){
                    int val = position[0] + j;
                    if(i < val && val < n && fruits[val][i] > max){
                        tempPosition[0] = val;
                        tempPosition[1] = i;
                        max = fruits[val][i];
                    }
                }
                position = tempPosition;
                sum += fruits[position[0]][position[1]];
            }

            return sum;
        }
    }

}
