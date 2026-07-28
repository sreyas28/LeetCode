import java.util.Arrays;

public class ProblemNo3517 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3517().new Solution();
//        System.out.println(a.smallestPalindrome("daccad"));
        System.out.println(a.smallestPalindrome("babab"));

    }

    class Solution {
        public String smallestPalindrome(String s) {
            StringBuilder sb = new StringBuilder();
            char[] sorted = s.substring(0, s.length() / 2).toCharArray();
            Arrays.sort(sorted);
            sb.append(sorted);

            if (s.length() % 2 == 0) sb.append(new StringBuilder(sb).reverse());
            else sb.append(s.charAt(s.length() / 2) + new StringBuilder(sb).reverse().toString());

            return sb.toString();
        }
    }

}
