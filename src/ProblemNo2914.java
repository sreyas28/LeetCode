public class ProblemNo2914 {

    public static void main(String[] args) {

        Solution a = new ProblemNo2914().new Solution();
        System.out.println(a.minChanges("1001"));

    }

    class Solution {
        public int minChanges(String s) {
            int count = 0;

            for (int i = 0; i < s.length(); i += 2) {
                if (s.charAt(i) != s.charAt(i + 1)) count++;
            }

            return count;
        }
    }

}
