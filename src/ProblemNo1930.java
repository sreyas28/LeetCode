import java.util.*;

public class ProblemNo1930 {
    public static void main(String[] args) {
        ProblemNo1930.Solution a = new ProblemNo1930().new Solution();
        System.out.println(a.countPalindromicSubsequence("ckafnafqo"));
    }

    class Solution {
        public int countPalindromicSubsequence(String s) {
            Map<Character, int[]> startLast = new HashMap<>();

            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(startLast.containsKey(c)) startLast.get(c)[1] = i ;
                else {
                    int[] temp = {i, -1};
                    startLast.put(c, temp);
                }
            }

            int result = 0;
            for(char key: startLast.keySet()){
                Set<Character> seen = new HashSet<>();
                int[] indexes = startLast.get(key);
                int start = indexes[0], end = indexes[1];

                for(int i = start+1; i < end && seen.size() <= 26 ; i++ ) seen.add(s.charAt(i));
                result += seen.size();
            }

            return result;
        }
    }

    // it does not consider order ;)
    class Solution_ {
        public int countPalindromicSubsequence(String s) {
            int[] letters = new int[26];
            for(char c: s.toCharArray()) letters[c-'a']++;
            Arrays.sort(letters);

            int result = 0;
            int ones = 0;

            for(int i = 0; i < 26; i++){
                int count = letters[i];

                if(count >= 3) result += 26 - i + ones;
                else if(count == 2) result += 26 - i - 1 + ones;
                else if(count == 1) ones++;
                else continue;
            }

            return result;
        }
    }

}
