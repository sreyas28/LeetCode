public class ProblemNo1888 {
    public static void main(String[] args) {
        ProblemNo1888.Solution p = new ProblemNo1888().new Solution();
        System.out.println(p.minFlips("001000000010"));

    }

    class Solution {
        public int minFlips(String s) {
            int n = s.length();
            String ss = s + s;

            StringBuilder alt1 = new StringBuilder();
            StringBuilder alt2 = new StringBuilder();

            boolean flag = false;
            for (int i = 0; i < n * 2; i++) {
                alt1.append(flag ? '1' : '0');
                alt2.append(!flag ? '1' : '0');
                flag = !flag;
            }

            int alt_1 = 0, alt_2 = 0;
            int countAlt_1 = 0, countAlt_2 = 0;

            for (int i = 0; i < n; i++) {
                char c = ss.charAt(i);

                alt_1 = c != alt1.charAt(i) ? alt_1 + 1 : alt_1;
                alt_2 = c != alt2.charAt(i) ? alt_2 + 1 : alt_2;
            }
            countAlt_1 = alt_1;
            countAlt_2 = alt_2;

            for (int i = n; i < n * 2; i++) {
                int indexOld = i - n;
                char cOld = ss.charAt(indexOld);
                char c = ss.charAt(i);

                alt_1 = cOld != alt1.charAt(indexOld) ? alt_1 - 1 : alt_1;
                alt_2 = cOld != alt2.charAt(indexOld) ? alt_2 - 1 : alt_2;

                alt_1 = c != alt1.charAt(i) ? alt_1 + 1 : alt_1;
                alt_2 = c != alt2.charAt(i) ? alt_2 + 1 : alt_2;

                countAlt_1 = Math.min(countAlt_1, alt_1);
                countAlt_2 = Math.min(countAlt_2, alt_2);
            }


            return Math.min(countAlt_1, countAlt_2);
        }
    }


    // brute Force
    class Solution_ {
        public int minFlips(String s) {
            int count = Integer.MAX_VALUE;

            for (int i = 0; i < s.length(); i++) {
                count = Math.min(type2(s), count);
                s = type1(s);
            }

            return count;
        }

        private String type1(String s) {
            return s.substring(1) + s.charAt(0);
        }

        private int type2(String s) {
            int countL = 0, countR = 0;
            boolean flag = false;

            for (char c : s.toCharArray()) {
                if (c != '1' && flag) countL++;
                else if (c != '0' && !flag) countL++;

                if (c != '1' && !flag) countR++;
                else if (c != '0' && flag) countR++;

                flag = !flag;
            }

            return Math.min(countL, countR);
        }

    }

}
