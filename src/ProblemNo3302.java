import java.util.Arrays;

public class ProblemNo3302 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3302().new Solution();
        System.out.println(Arrays.toString(a.validSequence("vbcca", "abc")));

    }

    class Solution {
        public int[] validSequence(String word1, String word2) {
            final int word1Length = word1.length(), word2Length = word2.length();

            Integer[] lastCharSeen = new Integer[word2Length];

            for (int i = word1Length - 1, j = word2Length - 1; i >= 0 && j >= 0; i--) {
                if (word1.charAt(i) == word2.charAt(j) && lastCharSeen[j] == null) {
                    lastCharSeen[j--] = i;
                }
            }

            int[] result = new int[word2Length];
            int j = 0;
            boolean flag = false;

            for (int i = 0; i < word1Length; i++) {
                if (j == word2Length) return result;

                if (word1.charAt(i) == word2.charAt(j) || (!flag && (j == word2Length - 1 || (lastCharSeen[j+1] != null && lastCharSeen[j + 1] > i)))) {
                    if (word1.charAt(i) != word2.charAt(j)) flag = true;
                    result[j++] = i;
                }
            }

            if (j == word2Length) return result;
            return new int[]{};
        }
    }

}
