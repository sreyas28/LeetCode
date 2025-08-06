public class ProblemNo2419 {
    public static void main(String[] args) {

        ProblemNo2419.Solution a = new ProblemNo2419().new Solution();
        System.out.println(a.longestSubarray(new int[]{96317,96317,96317,96317,96317,96317,96317,96317,96317,279979}));

    }

    class Solution {
        public int longestSubarray(int[] nums) {
            int maxNumber = -1;
            for(int i: nums) maxNumber = Math.max(maxNumber, i);

            int result = 1, max = 0;

            for(int i: nums){
                if(i == maxNumber) max++;
                else max = 0;

                result = Math.max(result, max);
            }



            return result;
        }
    }
}
