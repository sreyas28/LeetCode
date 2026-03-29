public class ProblemNo2839 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean canBeEqual(String s1, String s2) {
            String second = replace(1, 3, s1);
            String third = replace(0, 2, s1);
            String forth = replace(0, 2, second);


            return s2.equals(s1) || s2.equals(second) || s2.equals(third) || s2.equals(forth);
        }

        private String replace(int from, int to, String str) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                if (i == from) sb.append(str.charAt(to));
                else if (i == to)  sb.append(str.charAt(from));
                else sb.append(str.charAt(i));
            }
            return sb.toString();
        }

    }

}
