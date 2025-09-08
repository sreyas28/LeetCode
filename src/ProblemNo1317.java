public class ProblemNo1317 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] getNoZeroIntegers(int n) {

            int[] result = {1, n-1};

            while(Integer.toString(result[0]).contains("0") ||
                    Integer.toString(result[1]).contains("0")){
                result[0] += 1;
                result[1] -= 1;
            }

            return result;
        }
    }

}
