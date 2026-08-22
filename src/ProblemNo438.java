import java.util.*;
import java.util.regex.Pattern;

public class ProblemNo438 {
    public static void main(String[] args) {
        Solution a = new ProblemNo438().new Solution();
        System.out.println(a.findAnagrams("cbaebabacb", "bac"));

    }

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            final int sLen = s.length(), pLen = p.length();

            if (sLen < pLen) return new ArrayList<>();

            p = getWord(p);

            List<Integer> ans = new ArrayList<>();

            StringBuilder stringBuilder = new StringBuilder(s.substring(0, pLen));
            for (int i = pLen; i < sLen; i++) {
                String val = getWord(stringBuilder.toString());
                if (val.equals(p)) ans.add(i - pLen);

                stringBuilder.deleteCharAt(0);
                stringBuilder.append(s.charAt(i));
            }

            if (getWord(stringBuilder.toString()).equals(p)) ans.add(sLen - pLen);

            return ans;
        }

        private String getWord(String p){
            char[] pArr = p.toCharArray();
            Arrays.sort(pArr);
            return String.valueOf(pArr);
        }

    }

}
