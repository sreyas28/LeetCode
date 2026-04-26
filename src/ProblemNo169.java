public class ProblemNo169 {
    public static void main(String[] args) {

    }

    class Solution {
        public int majorityElement(int[] nums) {

            int current = -1;
            int count = 0;

            for(int num:nums){
                if (count == 0) {
                    current = num;
                    count++;
                }
                else if (current == num) count++;
                else count--;
            }


            return current;
        }
    }

}
