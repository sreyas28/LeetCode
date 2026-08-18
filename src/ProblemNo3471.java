import java.util.*;

public class ProblemNo3471 {
    public static void main(String[] args) {

    }

    class Solution {
        public int largestInteger(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

            if(k == 1){
                int max = -1;
                for(int key : map.keySet()){
                    if(map.get(key) == 1) max = Math.max(max, key);
                }
                return max;
            }
            if (k == nums.length) return Arrays.stream(nums).max().getAsInt();

            int leftValue = nums[0], rightValue = nums[nums.length - 1];
            int leftCount = map.get(leftValue),  rightCount = map.get(rightValue);

            if (leftCount == 1 && rightCount == 1) return Math.max(leftValue, rightValue);
            else if (leftCount == 1) return leftValue;
            else if (rightCount == 1) return rightValue;
            else return -1;
        }
    }

}
