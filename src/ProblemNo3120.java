public class ProblemNo3120 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3120().new Solution();
        System.out.println(a.numberOfSpecialChars("aaAbcBC"));
    }

    class Solution {
        public int numberOfSpecialChars(String word) {

            int[] charCapital = new int[26];
            int[] charSmall = new int[26];
            for(char c: word.toCharArray()) {
                if (c >= 'a' && c <= 'z') charCapital[c - 'a']++;
                else if (c >= 'A' && c <= 'Z') charSmall[c - 'A']++;
            }

            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (charCapital[i] > 0 && charSmall[i] > 0) count++;
            }

            return count;
        }
    }

}
