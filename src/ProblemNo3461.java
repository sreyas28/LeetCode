public class ProblemNo3461 {
    public static void main(String[] args) {

        ProblemNo3461.Solution a = new ProblemNo3461(). new Solution();
        System.out.println(a.hasSameDigits("3902"));

    }

    class Solution {
        public boolean hasSameDigits(String s) {

            while(s.length() != 2){
                StringBuilder temp = new StringBuilder();
                for(int i = 1; i < s.length(); i++) {

                    int a = s.charAt(i - 1) - '0';
                    int b = s.charAt(i) - '0';

                    temp.append((a + b) % 10);
                }

                s = temp.toString();

            }

            return s.charAt(0) == s.charAt(1);
        }
    }

}
