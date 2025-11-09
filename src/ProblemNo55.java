import java.util.Arrays;

public class ProblemNo55 {
    public static void main(String[] args) {

        ProblemNo55.Solution a = new ProblemNo55().new Solution();
        System.out.println(a.canJump(new int[] {2,3,1,1,4}));

    }

    class Solution {
        public boolean canJump(int[] nums) {
            int[] canReach = new int[nums.length];
            for(int i = nums.length-2; i >= 0; i--) canReach[i] = i + nums[i];

            return reaches(nums.length - 1, canReach);
        }

        private boolean reaches(int toReach, int[] canReach){
            int last = -1;

            for(int i = toReach-1; i >= 0; i--){
                if(canReach[i] >= toReach) last = i;
            }

            if(last == 0 || toReach == 0) return true;
            else if(last == -1) return false;

            return reaches( last, canReach);
        }

    }

}
