public class ProblemNo3300 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minElement(int[] nums) {
            int min = Integer.MAX_VALUE;
            for(int i: nums){
                int sum = 0;
                while(i > 0){
                    sum += (i%10);
                    i /= 10;
                }
                min = Math.min(min, sum);
            }
            return min;
        }
    }

}
