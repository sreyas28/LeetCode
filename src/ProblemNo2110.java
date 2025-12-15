public interface ProblemNo2110 {
    public static void main(String[] args) {

    }

    class Solution {
        public long getDescentPeriods(int[] prices) {
            long result = 0;

            int count = 1;
            for(int i=1; i<prices.length; i++){

                if(prices[i-1] == prices[i]+1) count++;
                else{
                    result += calc(count);
                    count = 1;
                }
            }

            result += calc(count);

            return result;
        }

        private long calc(int i){
            return ((long) i * (i+1)) / 2;
        }

    }

}
