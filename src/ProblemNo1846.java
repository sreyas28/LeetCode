import java.util.Arrays;

public class ProblemNo1846 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1846().new Solution();
        System.out.println(a.maximumElementAfterDecrementingAndRearranging(new int[] {1,2,2,2,1}));

    }

    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            int maxNum = 1;

            Arrays.sort(arr);
            arr[0] = 1;

            for (int i = 1; i < arr.length; i++) {
                int prev =  arr[i-1];
                int diff = arr[i] - prev;

                if  (diff <= 1) {
                    maxNum = Math.max(maxNum, arr[i]);
                    continue;
                }

                arr[i] = prev + 1;
                maxNum = Math.max(maxNum, arr[i]);
            }

            return maxNum;
        }
    }

}
