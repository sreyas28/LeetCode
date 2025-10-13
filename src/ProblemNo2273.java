import java.util.*;

public class ProblemNo2273 {
    public static void main(String[] args) {

        ProblemNo2273.Solution a = new ProblemNo2273().new Solution();
        System.out.println(a.removeAnagrams(new String[]{
                "abba","baba","bbaa","cd","cd"
        }));

    }

    class Solution {
        public List<String> removeAnagrams(String[] words) {
            List<String> result = new ArrayList<>();
            String prevSorted = "";

            for(String a: words){
                char[] word = a.toCharArray();
                Arrays.sort(word);

                String sorted = new String(word);
                if(!sorted.equals(prevSorted)) {
                    result.add(a);
                    prevSorted = sorted;
                }
            }

            return result;
        }
    }

}
