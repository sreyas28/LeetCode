import java.util.*;

public class ProblemNo1291 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1291().new Solution();
        System.out.println(a.sequentialDigits(10, 300));

    }

    class Solution {
        private final static String nums = "123456789";

        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> ans = new ArrayList<>();

            int lengthLow = String.valueOf(low).length();
            int lengthHigh = String.valueOf(high).length();

            for (int len = lengthLow; len <= lengthHigh; len++) {

                for (int j = 0; (j + len - 1) < 9; j++) {
                    int curNumber = Integer.parseInt(nums.substring(j, j + len));
                    if (low <= curNumber && curNumber <= high) ans.add(curNumber);

                    if (curNumber > high) break;
                }
            }

            return ans;
        }
    }

}
