public class ProblemNo3876 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean uniformArray(int[] nums) {
            int min = Integer.MAX_VALUE;

            boolean foundOdd = false;
            for (int num : nums) {
                if ((num & 1) == 1) foundOdd = true;
                min = Math.min(min, num);
            }

            if ((min & 1) == 1) return true;
            return !foundOdd;
        }
    }


}
