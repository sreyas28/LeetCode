public class ProblemNo1752 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1752().new Solution();
        System.out.println(a.check(new int[]{5,5,6,6,6,9,1,2}));

    }

    class Solution {
        public boolean check(int[] nums) {
            final int N = nums.length;
            int switched = 0;

            if (nums[0] >= nums[N-1]){
                for (int i = 1; i < N; i++) {
                    if (nums[i] >= nums[i-1]) continue;
                    switched = i;
                    break;
                }
            }

            for (int i = 0; i < N - 1; i++) {
                int next = (switched + 1) % N;

                if (nums[switched] > nums[next]) return false;

                switched = next;
            }

            return true;
        }
    }

}
