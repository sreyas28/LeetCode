public class ProblemNo2405 {
    public static void main(String[] args) {

    }

    class Solution {
        public int partitionString(String s) {
            boolean[] unique = new boolean[26];
            int count = 0;

            for (char c : s.toCharArray()) {
                if (unique[c - 'a']) {
                    count++;
                    unique = new boolean[26];
                }

                unique[c - 'a'] = true;
            }
            count++;

            return count;
        }
    }

}
