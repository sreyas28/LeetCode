import java.util.*;

public class ProblemNo3518 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3518().new Solution();
        System.out.println(a.smallestPalindrome("abccba", 1)); // abc
        System.out.println(a.smallestPalindrome("abccba", 2)); // acb
        System.out.println(a.smallestPalindrome("abccba", 3)); // bac
        System.out.println(a.smallestPalindrome("abccba", 4)); // bca
        System.out.println(a.smallestPalindrome("abccba", 5)); // cab
        System.out.println(a.smallestPalindrome("abccba", 6)); // cba

        System.out.println(a.smallestPalindrome("abba", 2));
        System.out.println(a.smallestPalindrome("aa", 2));
    }

    class Solution {

        private static final long CAP = 2_000_000_000L;

        public String smallestPalindrome(String s, int k) {
            final int n = s.length();
            String extra = (n % 2 == 0) ? "" : s.charAt(n / 2) + "";

            Map<Character, Integer> half = new TreeMap<>();
            for (char c : s.substring(0, n / 2).toCharArray()) half.put(c, half.getOrDefault(c, 0) + 1);

            if (k > calcWays(null, half)) return "";

            StringBuilder sb = new StringBuilder();

            long remaining = k;
            while (remaining > 0 && !half.isEmpty()) {
                char val = ' ';
                for (char key : half.keySet()) {
                    long ways = calcWays(key, half);
                    if (remaining - ways > 0) remaining -= ways;
                    else {
                        val = key;
                        break;
                    }
                }
                sb.append(val);
                if (half.containsKey(val)) {
                    half.put(val, half.get(val) - 1);
                    if (half.get(val) == 0) half.remove(val);
                }
            }

            sb.append(extra + new StringBuilder(sb).reverse());

            return sb.toString();
        }

        private long calcWays(Character key, Map<Character, Integer> half) {
            long result = 1;
            int seen = 0;
            for (Character k : half.keySet()) {
                int cnt = half.get(k) - (key != null && k == key ? 1 : 0);
                for (int j = 1; j <= cnt; j++) {
                    seen++;
                    result = result * seen / j;
                    if (result > CAP) result = CAP;
                }
            }
            return result;
        }

    }

}
