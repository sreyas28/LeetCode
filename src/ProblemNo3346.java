import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProblemNo3346 {
    public static void main(String[] args) {
        ProblemNo3346.Solution a = new ProblemNo3346().new Solution();
        System.out.println(a.maxFrequency(new int[] {5,11,20,20}, 5, 1));
    }

    class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            Map<Integer, Integer> freq = new HashMap<>();
            Arrays.sort(nums);
            int maxVal = nums[nums.length -1];
            int[] diff = new int[maxVal + 2];

            for(int num: nums){
                freq.put(num, freq.getOrDefault(num, 0) + 1);

                int low = Math.max(num - k, 0);
                int high = Math.min(num + k, maxVal);
                diff[low]++;
                diff[high+1]--;
            }

            int result = 0;
            for(int target=0; target<=maxVal; target++){
                diff[target] += target > 0 ? diff[target-1]: 0;

                int targetFreq = freq.getOrDefault(target, 0);
                int needChange = diff[target] - targetFreq;
                int maxOp = Math.min(needChange, numOperations);

                result = Math.max(result, targetFreq + maxOp);
            }

            return result;
        }
    }

}

//public int maxFrequency(int[] nums, int k, int numOperations) {
//    Arrays.sort(nums);
//
//    int maxFreq = 1;
//    for(int i = 0; i < nums.length; i++){
//        int num = nums[i];
//        int tempMax = 1;
//        for(int j = i+1; j<nums.length; j++) {
//            int canChange = Math.abs(nums[j] - nums[i]);
//            if(canChange <= k && canChange >= 0) tempMax++;
//        }
//        maxFreq = Math.max(maxFreq, tempMax);
//
//    }
//    return maxFreq;
//}
