import java.util.Arrays;

public class ProblemNo976 {
    public static void main(String[] args) {

    }

    class Solution {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);

            for(int i = nums.length - 1; i >= 2; i--){
                int a = nums[i];
                int b = nums[i-1];
                int c = nums[i-2];

                if(c+b > a) return a+b+c;
            }

            return 0;
        }
    }

}
