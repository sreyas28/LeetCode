public class ProblemNo3513 {
    public static void main(String[] args) {

    }

    class Solution {
        public int uniqueXorTriplets(int[] nums) {
            int ans = nums.length;
            if (ans <= 2) return ans;

            return (int) (Math.pow(2, (int) (Math.log(ans) / Math.log(2)) + 1));
        }
    }

}
