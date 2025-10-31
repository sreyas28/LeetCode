public class ProblemNo3289 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] getSneakyNumbers(int[] nums) {

            int sum = 0, sumSquared = 0;

            for(int i: nums){
                sum += i;
                sumSquared += i*i;
            }
            int len = nums.length - 2;
            int A = sum - ((len*(len - 1)) / 2);
            int B = sumSquared - ((len*(len - 1)*(2*len - 1)) / 6);

            int D = (int) Math.sqrt(2*B - A*A);

            return new int[]{(A-D)/2, (A+D)/2};
        }
    }

}
