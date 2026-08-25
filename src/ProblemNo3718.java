import java.util.Arrays;

public class ProblemNo3718 {
    public static void main(String[] args) {

    }

    class Solution {
        public int missingMultiple(int[] nums, int k) {
            Arrays.sort(nums);
            int toFind = k;

            for (int i: nums) {
                if (i == toFind) toFind += k;
            }

            return toFind;
        }
    }

}
