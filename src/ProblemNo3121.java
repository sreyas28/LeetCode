import java.util.Arrays;

public class ProblemNo3121 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3121().new Solution();
        System.out.println(a.numberOfSpecialChars("aaAbcBC"));
    }

    class Solution {
        public int numberOfSpecialChars(String word) {
            int[] lowerCaseIndex = new int[26];
            int[] upperCaseIndex = new int[26];

            Arrays.fill(lowerCaseIndex, -1);
            Arrays.fill(upperCaseIndex, -1);

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c >= 'a' && c <= 'z') lowerCaseIndex[c - 'a'] = i;
                else if (c >= 'A' && c <= 'Z' && upperCaseIndex[c - 'A'] == -1) upperCaseIndex[c - 'A'] = i;
            }

            int count = 0;

            for (int i = 0; i < 26; i++) {
                if (lowerCaseIndex[i] == -1 || upperCaseIndex[i] == -1 || lowerCaseIndex[i] > upperCaseIndex[i])
                    continue;

                count++;
            }

            return  count;
        }
    }

}
