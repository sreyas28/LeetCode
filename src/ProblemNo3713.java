import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProblemNo3713 {
    public static void main(String[] args) {

    }

    // bruteForce
    class Solution {
        public int longestBalanced(String s) {
            int maxLen = 0;

            for(int l = 0; l < s.length(); l++) {
                int[] chars = new int[26];
                int val = 0;

                for(int r = l; r < s.length(); r++) {
                    int currentVal = s.charAt(r) - 'a';
                    chars[currentVal]++;
                    val = Math.max(val, chars[currentVal]);

                    if(countEqual(chars, val)) maxLen = Math.max(maxLen, r - l + 1);
                }
            }

            return maxLen;
        }

        private boolean countEqual (int[] chars, int val) {
            for(int key: chars) {
                if(key != 0 && key != val) return false;
            }

            return true;
        }

    }

}
