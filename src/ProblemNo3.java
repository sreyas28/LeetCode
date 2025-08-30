import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ProblemNo3 {
    public static void main(String[] args) {

        ProblemNo3.Solution a = new ProblemNo3().new Solution();
        System.out.println(a.lengthOfLongestSubstring("ohomm"));

    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new LinkedHashSet<>();
            int maxLen = 0;

            for(char c: s.toCharArray()){
                if(!set.contains(c)) set.add(c);
                else{
                    Iterator<Character> iterator = set.iterator();
                    while(set.contains(c)){
                        iterator.next();
                        iterator.remove();
                    }

                    set.add(c);
                }
                maxLen = Math.max(maxLen, set.size());
//                System.out.println(set + " " + maxLen + " " + c);
            }

            return maxLen;
        }
    }

}
