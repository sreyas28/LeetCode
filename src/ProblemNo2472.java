public class ProblemNo2472 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2472().new Solution();
//        System.out.println(a.maxPalindromes("abaccdbbd", 3));
        System.out.println(a.maxPalindromes("sjbxiufnaanqkwsqswkqrcznzcddhtuhtthuttjfuufjtcfywgecegwyhhnnhtozczirynhhnyrire", 3));
//        System.out.println(a.maxPalindromes("adbcda", 2));

    }

    class Solution {
        public int maxPalindromes(String s, int k) {
            int count = 0;

            int i = 0, j = i + k;
            while (i < s.length() && j <= s.length()) {
                if (isPalindrome(s.substring(i, j))) {
                    count++;
                    i = j;
                    j = i + k;
                    continue;
                }

                if (j+1 <= s.length() && isPalindrome(s.substring(i, j+1))) {
                    count++;
                    i = j + 1;
                    j = i + k;
                    continue;
                }

                i++;
                j++;
            }

            return count;
        }

        private boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) return false;
                left++;
                right--;
            }

            return true;
        }

    }

}
