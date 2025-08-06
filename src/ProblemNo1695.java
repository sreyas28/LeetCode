import java.util.HashSet;
import java.util.Set;

public class ProblemNo1695 {
    public static void main(String[] args) {

        ProblemNo1695.Solution a = new ProblemNo1695().new Solution();
        System.out.println(a.maximumUniqueSubarray(new int[]{187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,
                459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,
                490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434}));

    }

    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            int sum = 0, maxSum = 0;
            Set<Integer> have = new HashSet<>();

            int left = -1, right = 0;
            while(left < right && right < nums.length){
                if(!have.contains(nums[right])){
                    have.add(nums[right]);
                    sum += nums[right];
                    right++;
                }

                else{
                    while(have.contains(nums[right])){
                        left++;
                        have.remove(nums[left]);
                        sum -= nums[left];
                    }
                    have.add(nums[right]);
                    sum += nums[right];
                    right++;
                }

                maxSum = Math.max(maxSum, sum);
            }


            return maxSum;
        }
    }

}
