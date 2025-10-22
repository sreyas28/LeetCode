import java.util.*;

public class ProblemNo3347 {
    public static void main(String[] args) {
        ProblemNo3347.Solution a = new ProblemNo3347().new Solution();
        System.out.println(a.maxFrequency(new int[] {5,11,20,20}, 5, 1));
    }

    class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            Map<Integer, Integer> freq = new HashMap<>();
            Arrays.sort(nums);
            int maxVal = nums[nums.length -1];

            Map<Integer, Integer> diff = new TreeMap<>();

            for(int num: nums){
                freq.put(num, freq.getOrDefault(num, 0) + 1);

                int low = Math.max(num - k, 0);
                int high = num + k;
                diff.put(num, diff.getOrDefault(num, 0));
                diff.put(low, diff.getOrDefault(low, 0) + 1);
                diff.put(high+1, diff.getOrDefault(high+1, 0) - 1);
            }
            Integer[] keysArray = diff.keySet().toArray(new Integer[0]);

            int result = 0;
            for(int target=0; target<keysArray.length; target++){
                int val = keysArray[target];
                if(target != 0) diff.put(val, diff.getOrDefault(keysArray[target-1], 0) + diff.get(val));

                int targetFreq = freq.getOrDefault(val, 0);
                int needChange = diff.getOrDefault(val, 0) - targetFreq;
                int maxOp = Math.min(needChange, numOperations);

                result = Math.max(result, targetFreq + maxOp);
            }

            return result;
        }
    }
}
