import java.util.Arrays;

public class ProblemNo3041 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3041().new Solution();
        System.out.println(a.maxSelectedElements(new int[]{1, 4, 7, 10}));

    }

    class Solution {
        public int maxSelectedElements(int[] nums) {
            int[] arr = new int[1_000_001];
            int max = 1;

            Arrays.sort(nums);

            for (int x : nums) {
                arr[x + 1] = Math.max(arr[x + 1], arr[x] + 1);
                arr[x] = Math.max(arr[x], arr[x - 1] + 1);

                max = Math.max(max, Math.max(arr[x], arr[x + 1]));
            }

            return max;
        }
    }

}
