public class ProblemNo3354 {
    public static void main(String[] args) {

        ProblemNo3354.Solution a = new ProblemNo3354().new Solution();
        System.out.println(a.countValidSelections(new int[]{1,0,2,0,3}));

    }

    class Solution {
        public int countValidSelections(int[] nums) {
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    if (function(1, nums.clone(), i)) count++;
                    if (function(-1, nums.clone(), i)) count++;
                }
            }

            return count;
        }

        private boolean function(int direction, int[] nums, int index){
            int current = index + direction;

            while(current >= 0 && current < nums.length){
                if(nums[current] != 0){
                    nums[current] -= 1;
                    direction *= -1;
                }
                current += direction;
            }

            for(int i: nums){
                if(i != 0) return false;
            }

            return true;
        }
    }

}
