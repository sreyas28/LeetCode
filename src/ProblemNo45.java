public class ProblemNo45 {
    public static void main(String[] args) {
        ProblemNo45.Solution a = new ProblemNo45().new Solution();
        System.out.println(a.jump(new int[] {2,3,1,1,4}));
    }

    class Solution {
        public int jump(int[] nums) {
            int[] canReach = new int[nums.length];
            for(int i = nums.length-2; i >= 0; i--) canReach[i] = i + nums[i];

            return reaches(nums.length - 1, canReach, 0);
        }

        private int reaches(int toReach, int[] canReach,int operations){
            int last = -1;

            for(int i = toReach-1; i >= 0; i--){
                if(canReach[i] >= toReach) last = i;
            }

            if(last == 0) return operations + 1;
            else if(toReach == 0) return operations;

            return reaches( last, canReach, operations) + 1;
        }

    }

}
