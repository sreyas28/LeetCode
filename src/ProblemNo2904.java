public class ProblemNo2904 {
    public static void main(String[] args) {
        Solution a = new ProblemNo2904().new Solution();
        System.out.println(a.shortestBeautifulSubstring("100011001", 3));
//        System.out.println(a.shortestBeautifulSubstring("001", 1));
//        System.out.println(a.shortestBeautifulSubstring("000", 1));
    }

    class Solution {
        public String shortestBeautifulSubstring(String s, int k) {
            final int N = s.length();
            String result = null;
            int count = 0, j = 0, i = 0;

            // removing leading zeroes
            while (j < N && s.charAt(j) != '1') {
                j++;
                i++;
            }

            for (; i < N; i++) {
                char c = s.charAt(i);
                if (c == '1') count++;

                if (count > k) {
                    while (count > k) {
                        if (s.charAt(j) == '1') count--;
                        j++;
                    }
                    while (s.charAt(j) != '1') j++;
                }

                if (count == k) result = helper(s.substring(j, i+1), result);
            }

            // removing leading zeroes
            while (j < N && s.charAt(j) != '1') j++;
            if (count == k) result = helper(s.substring(j, i), result);

            return result == null ? "" : result;
        }

        private String helper(String current, String prev) {
            int currentLength = current.length();

            if (prev == null || currentLength < prev.length()) return current;
            else if (currentLength == prev.length() && current.compareTo(prev) < 0) return current;

            return prev;
        }
    }

}
