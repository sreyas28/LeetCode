public class ProblemNo3653 {

    public static void main(String[] args) {

    }

    class Solution {
        public int xorAfterQueries(int[] nums, int[][] queries) {
            for (int[] query : queries) {
                int end = query[1], dist = query[2], multi = query[3];

                for (int i = query[0]; i <= end; i += dist) nums[i] =(int) (((long) nums[i] * multi) % 1_000_000_007);
            }

            int xored = 0;
            for (int i : nums) xored ^= i;

            return xored;
        }
    }


}
