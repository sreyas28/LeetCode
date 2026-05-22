public class ProblemNo33 {
    public static void main(String[] args) {

    }

    // simplest O(n) linear
    class Solution_ {
        public int search(int[] nums, int target) {

            for(int i = 0; i < nums.length; i++){
                if (nums[i] == target) return i;
            }

            return -1;
        }
    }

}
