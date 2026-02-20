import java.util.ArrayList;
import java.util.List;

public class ProblemNo761 {
    public static void main(String[] args) {

        ProblemNo761.Solution p = new ProblemNo761().new Solution();
        System.out.println(p.makeLargestSpecial("11011000"));

    }

    class Solution {
        public String makeLargestSpecial(String s) {
            return DFSBottomUp(s);
        }

        private String DFSBottomUp(String s) {
            int[] prefix =  new int[s.length()];
            prefix[0] = 1;

            List<Integer> zeroes = new ArrayList<>();

            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == '1') prefix[i] = prefix[i-1] + 1;
                else prefix[i] = prefix[i-1] - 1;

                if (prefix[i] == 0) zeroes.add(i);
            }

            int prev = 1;
            List<String> words = new ArrayList<>();
            for (Integer zero : zeroes) {
                int cur = zero;
                String currentString = s.substring(prev, cur);

                if(currentString.isEmpty()) words.add("10");
                else words.add('1' + DFSBottomUp(currentString) + '0');
                prev = cur+2;
            }

            words.sort((a,b) -> b.compareTo(a));
            StringBuilder sb = new StringBuilder();

            for(String word: words) sb.append(word);

            return sb.toString();
        }

    }

}
