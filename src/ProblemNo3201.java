import java.util.Arrays;

public class ProblemNo3201 {
    public static void main(String[] args) {

        ProblemNo3201.Solution a = new ProblemNo3201().new Solution();

        System.out.println(a.maximumLength(new int[] {1,4,2}));

    }

    class Solution {
        public int maximumLength(int[] nums) {
            int countEven = 0;
            int countOdd = 0;
            for (int num : nums) {
                if (num % 2 == 0) {
                    countEven++;
                } else {
                    countOdd++;
                }
            }

            int evenDp = 0;
            int oddDp = 0;
            for (int num : nums) {
                if (num % 2 == 0) {
                    evenDp = Math.max(evenDp, oddDp + 1);
                } else {
                    oddDp = Math.max(oddDp, evenDp + 1);
                }
            }

            return Math.max(Math.max(countEven, countOdd), Math.max(evenDp, oddDp));
        }
    }

}
