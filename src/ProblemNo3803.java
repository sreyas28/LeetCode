import java.util.*;

public class ProblemNo3803 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3803().new Solution();
//        System.out.println(a.residuePrefixes("abc"));
        System.out.println(a.residuePrefixes("dddd"));
//        System.out.println(a.residuePrefixes("bob"));
    }

    class Solution {
        public int residuePrefixes(String s) {
            int countResidue = 0;
            Set<Character> unique = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                unique.add(s.charAt(i));
                if (unique.size() == (i+1) % 3) countResidue++;
            }

            return countResidue;
        }
    }

}
