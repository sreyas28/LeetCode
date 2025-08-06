import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemNo3487 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxSum(int[] nums) {
            Set<Integer> positive = new HashSet<>();
            for(int i: nums) if(i >= 0) positive.add(i);

            if(positive.isEmpty()) return Arrays.stream(nums).max().getAsInt();
            return positive.stream().mapToInt(Integer::intValue).sum();
        }
    }
}
