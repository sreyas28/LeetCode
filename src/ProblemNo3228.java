public class ProblemNo3228 {
    public static void main(String[] args) {
        ProblemNo3228.Solution a= new ProblemNo3228().new Solution();
        System.out.println(a.maxOperations("010010"));
    }

    public class Solution {

        public int maxOperations(String s) {
            int countOne = 0;
            int ans = 0;
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == '0') {
                    while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                        i++;
                    }
                    ans += countOne;
                } else {
                    countOne++;
                }
                i++;
            }
            return ans;
        }
    }

}
