import java.util.*;

public class ProblemNo3720 {

    public static void main(String[] args) {

        Solution a = new ProblemNo3720().new Solution();
        System.out.println(a.lexGreaterPermutation("abc", "bba"));
        System.out.println(a.lexGreaterPermutation("leet", "code"));
        System.out.println(a.lexGreaterPermutation("baba", "bbaa"));

    }

    class Solution {
        public String lexGreaterPermutation(String s, String target) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) freq[c - 'a']++;

            return backtracking(freq, target, 0, "", false);
        }

        private String backtracking(int[] freq, String target, int idx, String wordSoFar, boolean lastGreater) {
            if (idx >= target.length()) return wordSoFar;

            String word = "";
            char globalCur = target.charAt(idx);
            for (int i = 0; i < 26; i++) {
                char cur = (char)(i + 'a');

                if ((!lastGreater && (cur) < globalCur) || freq[i] == 0) continue;

                freq[i]--;
                if (lastGreater) {
                    word = backtracking(freq, target, idx + 1, wordSoFar + cur, true);
                }
                else {
                    word = backtracking(freq, target, idx + 1, wordSoFar + cur,  cur > globalCur);
                }

                if (word.compareTo(target) > 0) return word;
                freq[i]++;
            }

            return "";
        }

    }


}
