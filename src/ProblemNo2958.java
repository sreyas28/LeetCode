import java.util.HashMap;

public class ProblemNo2958 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2958().new Solution();
        System.out.println(a.maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));

    }

    class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();

            int maxLen = 0, j = 0;
            for (int i = 0; i < nums.length; i++) {
                int currVal = nums[i];
                map.put(currVal, map.getOrDefault(currVal, 0) + 1);
                if (map.get(currVal) > k){
                    while(map.get(currVal) > k){
                        map.put(nums[j], map.get(nums[j]) - 1);
                        if (map.get(nums[j]) == 0) map.remove(nums[j]);

                        j++;
                    }
                }

                maxLen = Math.max(maxLen, i - j + 1);
            }

            return maxLen;
        }
    }

}
