import java.util.HashMap;
import java.util.Map;

public class ProblemNo3702 {

    public static void main(String[] args) {
        Solution a = new ProblemNo3702().new Solution();
        System.out.println(a.longestSubsequence(new int[]{6,0}));
    }

    class Solution {

        public int longestSubsequence(int[] nums) {
            int xor = 0, zeros = 0;
            for (int i: nums) {
                xor ^= i;

                if (i == 0) zeros++;
            }

            if( zeros == nums.length) return 0;
            return xor > 0 ? nums.length : nums.length - 1;
        }

    }


}
