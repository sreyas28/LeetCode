import java.util.*;

public class ProblemNo78 {
    public static void main(String[] args) {

        Solution solution = new ProblemNo78().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));

    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            int m = 1 << nums.length;

            for(int mask = 1; mask < m; mask++){
                ans.add(new ArrayList<>());
                for(int i = 0; i < nums.length; i++){
                    if ((mask >> i & 1) == 1) ans.getLast().add(nums[i]);
                }
            }

            return ans;
        }
    }

}
