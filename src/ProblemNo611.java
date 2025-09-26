import java.util.Arrays;

public class ProblemNo611 {
    public static void main(String[] args) {

    }

    class Solution {


        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int count = 0;

            for(int k = nums.length - 1; k >= 2; k--){
                int c = nums[k];
                int i = 0, j = k - 1;

                while(i < j){

                    if(nums[i] + nums[j] > c) {
                        count += (j - i);
                        j--;
                    }
                    else i++;
                }
            }

            return count;
        }

        public int triangleNumber_BruteForce(int[] nums) {
            int count = 0;

            for(int i=0; i<nums.length - 2; i++){
                int a = nums[i];
                for(int j=i+1; j<nums.length - 1; j++){
                    int b = nums[j];
                    for(int k=j+1; k<nums.length; k++){
                        int c = nums[k];
                        if (a+b > c && b+c > a && c+a > b) count++;
                    }
                }
            }

            return count;
        }
    }

}
