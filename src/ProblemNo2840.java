public class ProblemNo2840 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean checkStrings(String s1, String s2) {
            if (s1.length() != s2.length()) return false;

            final int n = s1.length();

            int[] even_S1 = new int[26];
            int[] even_S2 = new int[26];
            int[] odd_S1 = new int[26];
            int[] odd_S2 = new int[26];

            for (int idx = 0; idx < n; idx++) {
                if (idx % 2 == 0) {
                    even_S1[s1.charAt(idx) - 'a']++;
                    even_S2[s2.charAt(idx) - 'a']++;
                } else {
                    odd_S1[s1.charAt(idx) - 'a']++;
                    odd_S2[s2.charAt(idx) - 'a']++;
                }
            }

            for (int idx = 0; idx < 26; idx++) {
                if (even_S1[idx] != even_S2[idx]) return false;
                if (odd_S1[idx] != odd_S2[idx]) return false;
            }

            return true;
        }
    }

}
