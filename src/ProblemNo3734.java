public class ProblemNo3734 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3734().new Solution();
        System.out.println(a.lexPalindromicPermutation("aac", "abb"));
        System.out.println(a.lexPalindromicPermutation("abc", "abb"));
        System.out.println(a.lexPalindromicPermutation("abab", "abba"));
        System.out.println(a.lexPalindromicPermutation("aabb", "aaab"));
        System.out.println(a.lexPalindromicPermutation("aabb", "abaa"));
        System.out.println(a.lexPalindromicPermutation("z", "z"));

    }

    class Solution {
        public String lexPalindromicPermutation(String s, String target) {
            final int sLen = s.length(), targetLen = target.length();

            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

            String toFind = target.substring(0, targetLen / 2);
            String extraOrNotPossible = extraChar(freq);
            if (extraOrNotPossible.equals("!"))
                return ""; // it is not possible to build a palindromic String with that freq table


            String res, res_equal;
            if (sLen % 2 == 0) {
                res = backtracking(freq.clone(), toFind, 0, "", false, false);
                res_equal = backtracking(freq, toFind, 0, "", false, true);
            } else {
                res = backtracking(freq.clone(), toFind, 0, "", false, false);
                res_equal = backtracking(freq, toFind, 0, "", false, true);
            }

            res += extraOrNotPossible + new StringBuilder(res).reverse().toString();
            res_equal += extraOrNotPossible + new StringBuilder(res_equal).reverse().toString();

            int resLen = res.length(), res_equalLen = res_equal.length();

            if (resLen == targetLen && res_equalLen == targetLen) {
                if (res.compareTo(res_equal) > 0 && res_equal.compareTo(target) > 0) return res_equal;
                else if (res.compareTo(target) > 0) return res;
                else return "";
            }
            else if (res.length() == targetLen && res.compareTo(target) > 0) return res;
            else if (res_equal.length() == targetLen && res_equal.compareTo(target) > 0) return res_equal;
            else return "";
        }

        /**
         * if char is ! means that it cant form a palindromic string
         */
        private String extraChar(int[] freq) {
            boolean flag = false;
            String ch = "";

            for (int i = 0; i < freq.length; i++) {
                if (freq[i] == 0) continue;
                else if (!flag && freq[i] % 2 == 1) {
                    flag = true;
                    ch = (char) (i + 'a') + "";
                } else if (freq[i] % 2 == 1) return "!";
            }

            return ch;
        }

        private String backtracking(int[] freq, String target, int idx, String wordSoFar, boolean lastGreater, boolean equalTo) {
            if (idx >= target.length()) return wordSoFar;

            String word = "";
            char globalCur = target.charAt(idx);
            for (int i = 0; i < 26; i++) {
                char cur = (char) (i + 'a');

                if ((!lastGreater && (cur) < globalCur) || freq[i] == 0) continue;

                freq[i] -= 2;
                if (freq[i] >= 0) {
                    if (lastGreater) {
                        word = backtracking(freq, target, idx + 1, wordSoFar + cur, true, equalTo);
                    } else {
                        word = backtracking(freq, target, idx + 1, wordSoFar + cur, cur > globalCur, equalTo);
                    }
                    if (equalTo && word.compareTo(target) >= 0) return word;
                    else if (!equalTo && word.compareTo(target) > 0) return word;
                }
                freq[i] += 2;
            }

            return "";
        }

    }

}
