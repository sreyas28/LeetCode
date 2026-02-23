import java.util.HashSet;
import java.util.Set;

public class ProblemNo1461 {
    public static void main(String[] args) {

        ProblemNo1461.Solution sol = new ProblemNo1461().new Solution();
        System.out.println(sol.hasAllCodes("00110110", 2));
        System.out.println(sol.hasAllCodes("0110", 2));
        System.out.println(sol.hasAllCodes("0110", 1));

    }

    class Solution {
        public boolean hasAllCodes(String s, int k) {
            int tureVal = (int) Math.pow(2,k);
            boolean[] dp = new boolean[tureVal];
            int count = 0;

            for (int i = 0; i <= s.length() - k; i++) {
                String sub =  s.substring(i, i + k);
                int val = binToDecimal(sub);
                if(!dp[val]){
                    dp[val] = true;
                    count++;

                    if(count == tureVal){
                        return true;
                    }
                }
            }

            return count == tureVal;
        }

        private int binToDecimal(String s) {
            int res = 0;
            for (char c : s.toCharArray()) {
                res = (res << 1) + (c - '0');
            }
            return res;
        }

    }

}
