public class ProblemNo1437 {
    public static void main(String[] args) {

        ProblemNo1437.Solution a = new ProblemNo1437(). new Solution();
        System.out.println(a.kLengthApart(new int[] {1,0,0,1,0,1}, 2));

    }

    class Solution {
        public boolean kLengthApart(int[] nums, int k) {

            int prevIndex = -1;
            int index = -1;

            for(int i = 0; i< nums.length; i++){
                if(nums[i] == 1 && index == -1) index = i;
                else if(nums[i] == 1) {
                    prevIndex = index;
                    index = i;

                    if((index - prevIndex - 1) < k) return false;
                }
            }
            return true;
        }
    }

}
