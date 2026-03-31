import java.util.Arrays;

public class ProblemNo3474 {
    public static void main(String[] args) {
        ProblemNo3474.Solution a = new ProblemNo3474().new Solution();
        System.out.println(a.generateString("TFFFT", "bab"));
    }

    class Solution {
        public String generateString(String str1, String str2) {
            final int n = str1.length(), m = str2.length();
            final int len = n + m - 1;

            StringBuilder sb = new StringBuilder();
            sb.repeat("a", len);

            boolean[] locked = new boolean[len];

            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) == 'T') {

                    for (int j = i, k = 0; k < m; j++, k++) {
                        if (locked[j] && sb.charAt(j) != str2.charAt(k)) return ""; // case where it already contradicts
                        locked[j] = true;
                    }
                    sb.replace(i, i + m, str2);
                } // placing all vals for T
            }

            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) == 'F') {
                    boolean flag = false;
                    int idx = -1;
                    for (int j = i + m - 1; j >= i; j--) {
                        if (str2.charAt(j - i) != sb.charAt(j)) {
                            flag = true;
                        }
                        if (idx == -1 && !locked[j]) {
                            idx = j;
                        }
                    }
                    if (flag) continue;
                    else if (idx != -1) sb.replace(idx, idx + 1, "b");
                    else return "";
                }
            }

            return sb.toString();
        }
    }

}
