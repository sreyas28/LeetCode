public class ProblemNo3379 {
    public static void main(String[] args) {
        System.out.println(-2 % 10);
    }

    class Solution {
        public int[] constructTransformedArray(int[] nums) {
            int[] res = new int[nums.length];
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                int num = nums[i];

                if (num >= 0) {
                    int newIndex = (i + num) % n;
                    res[i] = nums[newIndex];
                } else {
                    int newIndex = (i+(num % n));
                    if(newIndex < 0) newIndex += n;
                    res[i] = nums[newIndex];
                }
            }
            return res;
        }
    }

}
