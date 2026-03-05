public class ProblemNo1784 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean checkOnesSegment(String s) {
            int i = 0;

            while (i < s.length() && s.charAt(i) != '1') i++;
            while (i < s.length() && s.charAt(i) != '0') i++;
            while (i < s.length()) {
                if (s.charAt(i) == '1') return false;
                i++;
            }

            return true;
        }
    }

}
