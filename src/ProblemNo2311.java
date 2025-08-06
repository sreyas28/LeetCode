public class ProblemNo2311 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestSubsequence(String s, int k) {
            int count = 0, sum = 0, n = s.length();
            int bits = (int) (Math.log(k)/Math.log(2)) + 1;

            for(int i = 0; i < n; i++){
                char ch = s.charAt(n-i-1);

                if(ch == '1'){
                    if(i < bits && sum + ( 1 << i) <= k){
                        count++;
                        sum += (1 << i);
                    }
                }
                else count++;
            }


            return count;
        }
    }

}
