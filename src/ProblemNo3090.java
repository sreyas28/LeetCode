public class ProblemNo3090 {

    class Solution {
        public int maximumLengthSubstring(String s) {
            int[] frequency = new int[26];

            int maxLen = 0, lIdx = 0;

            for(char rIdx = 0; rIdx < s.length(); rIdx++){
                int key = s.charAt(rIdx) - 'a';

                frequency[key]++;

                while(frequency[key] > 2){
                    int temp = s.charAt(lIdx) - 'a';

                    frequency[temp]--;
                    lIdx++;
                }

                maxLen = Math.max(maxLen, rIdx - lIdx + 1);
            }

            return maxLen;
        }
    }
}
