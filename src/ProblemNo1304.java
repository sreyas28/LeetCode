import java.util.Arrays;

public class ProblemNo1304 {
    public static void main(String[] args) {


        ProblemNo1304.Solution a = new ProblemNo1304().new Solution();
        System.out.println(Arrays.toString(a.sumZero(4)));

    }

    class Solution {
        public int[] sumZero(int n) {
            int[] result = new int[n];

            if (n % 2 == 0){
                int start_end = (n / 2) * -1;
                for(int i = 0; i < n; i++) {
                    result[i] = start_end++;
                    if(i == n / 2) result[i] = start_end++;
                }
            }
            else{
                int start_end = (n / 2) * -1;
                for(int i = 0; i < n; i++) result[i] = start_end++;
            }
            return result;
        }
    }

}
