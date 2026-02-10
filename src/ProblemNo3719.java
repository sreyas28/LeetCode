import java.util.*;

public class ProblemNo3719 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestBalanced(int[] nums) {
            int max = -1;

            for (int i = 0; i < nums.length; i++) {
                Set<Integer> even = new HashSet<>();
                Set<Integer> odd = new HashSet<>();

                int currentMax = 0;

                for (int j = i; j < nums.length; j++) {
                    int val = nums[j];

                    if (val % 2 == 0) even.add(val);
                    else odd.add(val);

                    if (even.size() == odd.size()) currentMax = j - i + 1;
                }

                max = Math.max(max, currentMax);
            }

            return max;
        }
    }

}
