import java.util.*;

public class ProblemNo3955 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3955().new Solution();
        System.out.println(a.generateValidStrings(3, 1));

    }

    class Solution {
        private List<String> validStrings;
        private int k, n;

        public List<String> generateValidStrings(int n, int k) {
            this.validStrings = new ArrayList<>();
            this.k = k;
            this.n = n;

            recursion(false, 0, "", 0);
            return validStrings;
        }

        private void recursion(boolean lastOne, int i, String s, int currSum) {
            if (currSum > this.k) return;
            else if (i == n) {
                validStrings.add(s);
                return;
            }

            if (!lastOne) recursion(true, i + 1, s + "1", currSum + i);
            recursion(false, i + 1, s + "0", currSum);
        }
    }

}
