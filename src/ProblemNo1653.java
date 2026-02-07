public class ProblemNo1653 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minimumDeletions(String s) {
            int n = s.length();

            int[] a_toRight = new int[n];
            int aCount = 0;
            for (int i = n - 1; i >= 0; i--) {
                a_toRight[i] = aCount;
                if (s.charAt(i) == 'a') aCount++;
            }

            int min = Integer.MAX_VALUE;
            int bCount = 0;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, a_toRight[i] + bCount);

                if(s.charAt(i) == 'b') bCount++;
            }

            return min;
        }
    }

}
