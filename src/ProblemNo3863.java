import java.util.*;

public class ProblemNo3863 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3863().new Solution();
        System.out.println(a.minOperations("edc"));

    }

    class Solution {
        public int minOperations(String s) {
            final int N = s.length();
            if (N == 1) return 0;

            char[] characters = s.toCharArray();
            Arrays.sort(characters);

            boolean minMoreThanOne = characters[0] == characters[1];
            boolean maxMoreThanOne = characters[N-1] == characters[N-2];

            char minChar = characters[0];
            char maxChar = characters[N-1];

            boolean flagNotSorted = false;
            for (int i = 0; i < N; i++){
                if (s.charAt(i) != characters[i]) {
                    flagNotSorted = true;
                    break;
                }
            }

            if (!flagNotSorted) return 0;
            else if (N == 2) return -1;
            else if (minChar == s.charAt(0) || maxChar == s.charAt(N-1)) return 1;
            else if (!minMoreThanOne && !maxMoreThanOne && minChar == s.charAt(N-1) && maxChar == s.charAt(0)) return 3;
            else return 2;
        }
    }

}
