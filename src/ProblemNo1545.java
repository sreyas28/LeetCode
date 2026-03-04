public class ProblemNo1545 {
    public static void main(String[] args) {
        ProblemNo1545.Solution p = new ProblemNo1545().new Solution();
        System.out.println(p.findKthBit(3, 1));
    }

    class Solution {
        public char findKthBit(int n, int k) {
            String sb = "0";

            for(int i = 0; i < n; i++){
                sb = sb + "1" + invertAndReverse(sb);
            }

            return sb.charAt(k-1);
        }

        private String invertAndReverse(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '1') sb.append('0');
                else sb.append('1');
            }

            return sb.reverse().toString();
        }
    }

}
