import java.util.*;

public class ProblemNo3583 {
    public static void main(String[] args) {

        ProblemNo3583.Solution a = new ProblemNo3583().new Solution();
        System.out.println(a.specialTriplets(new int[]{37,9,24,24,12,12,12,24,12,24,52,35}));

    }

    class Solution {
        public int specialTriplets(int[] nums) {
            final int MOD = (int) 1e9 + 7;
            final int SIZE = (int) 1e5;
            int[] suffixFreq  = new int[SIZE+1];
            int[] prefixFreq  = new int[SIZE+1];
            for(int i: nums) suffixFreq[i]++;

            long count = 0;
            for(int key: nums){
                int target = key*2;

                suffixFreq[key]--;

                if( target <= SIZE && prefixFreq[target] >= 1 && suffixFreq[target] >= 1) {
                    count = (count + (long) prefixFreq[target] * suffixFreq[target]) % MOD;
                }

                prefixFreq[key]++;
            }

            return (int)(count % MOD);
        }
    }

    // works but a bit slow not TLE but still
    class Solution_ {
        public int specialTriplets(int[] nums) {
            final int MOD = (int) 1e9 + 7;
            Map<Integer, Integer> suffixFreq  = new HashMap<>();
            Map<Integer, Integer> prefixFreq  = new HashMap<>();
            for(int i: nums) suffixFreq.put(i, suffixFreq.getOrDefault(i,0)+1);

            long count = 0;
            for(int key: nums){
                int target = key*2;

                suffixFreq.put(key, suffixFreq.get(key)-1);
                if(suffixFreq.get(key) <= 0) suffixFreq.remove(key);

                if(prefixFreq.containsKey(target) && suffixFreq.containsKey(target)) {
                    count = (count + (long) prefixFreq.get(target) * suffixFreq.get(target)) % MOD;
                }

                prefixFreq.put(key, prefixFreq.getOrDefault(key,0)+1);
            }

            return (int)(count % MOD);
        }
    }

}
