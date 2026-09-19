public class ProblemNo3498 {
    public static void main(String[] args) {

    }

    class Solution {
        public int reverseDegree(String s) {

            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int cur = 26 - s.charAt(i) + 'a';

                sum += (cur * (i+1));
            }

            return sum;
        }
    }

}
