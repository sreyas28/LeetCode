import java.util.HashMap;
import java.util.Map;

public class ProblemNo3003 {
    public static void main(String[] args) {

        ProblemNo3003.Solution a = new ProblemNo3003().new Solution();
        System.out.println(a.maxPartitionsAfterOperations("accca", 2));

    }

    class Solution {

        private Map<String, Integer> memo = new HashMap<>();

        public int maxPartitionsAfterOperations(String s, int k) {
            return recursion(0, 0, true, k, s);
        }

        private int recursion(int i, int bitMasking, boolean canChange, int k, String s){
            if(i >= s.length()) return bitMasking > 0 ? 1: 0;

            String key = i + "," + bitMasking + "," + canChange;
            if(memo.containsKey(key)) return memo.get(key);

            int newBitMasking = bitMasking | (1 << (s.charAt(i) - 'a'));
            int prefix = 0;

            if(Integer.bitCount(newBitMasking) > k){
                prefix++;
                newBitMasking = 1 << (s.charAt(i) - 'a');
            }

            int withOutSubstitution = prefix + recursion(i+1, newBitMasking, canChange, k, s);
            int withSubstitution = 0;

            if(canChange){
                for(int c = 0; c < 26; c++){
                    int changedBitMasking = bitMasking | (1 << c);

                    int tempPrefix = 0;
                    if(Integer.bitCount(changedBitMasking) > k){
                        tempPrefix++;
                        changedBitMasking = 1 << c;
                    }

                    withSubstitution = Math.max(withSubstitution, tempPrefix + recursion(i+1, changedBitMasking, false, k, s));
                }
            }

            memo.put(key, Math.max(withSubstitution, withOutSubstitution));

            return memo.get(key);
        }
    }

}
