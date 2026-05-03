public class ProblemNo796 {
    public static void main(String[] args) {

        Solution a = new ProblemNo796().new Solution();
        System.out.println(a.rotateString("abcde", "cdeab"));

    }

    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) return false;

            for(int i = 0; i < s.length(); i++) {
                if (s.equals(goal)) return true;
                s = rotate(s);
            }

            return false;
        }

        private String rotate(String word) {
            return word.substring(word.length()-1) + word.substring(0, word.length()-1);
        }

    }

}
