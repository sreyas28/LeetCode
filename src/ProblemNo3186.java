import java.util.*;

public class ProblemNo3186 {
    public static void main(String[] args) {

        ProblemNo3186.Solution a = new ProblemNo3186().new Solution();
        System.out.println(a.maximumTotalDamage(new int[]{7,1,6,6}));
    }

    class Solution {
        public long maximumTotalDamage(int[] power) {
            Map<Integer, Integer> freq = new HashMap<>();

            for(int i: power) freq.put(i, freq.getOrDefault(i, 0) + 1);
            List<Integer> unique = new ArrayList<>(freq.keySet());
            Collections.sort(unique);

            return DFS(0, unique, freq, new HashMap<>());
        }

        private long DFS(int i, List<Integer> unique, Map<Integer, Integer> freq, Map<Integer, Long> memo){
            if(i == unique.size()) return 0;

            if(memo.containsKey(i)) return memo.get(i);

            long result = DFS(i+1, unique, freq, memo); // skipping it
            long  limit = unique.get(i) + 2;
            int next = i + 1;
            while(next < unique.size() && unique.get(next) <= unique.get(i) + 2) next++;

            result = Math.max(result, ((long) unique.get(i) * freq.get(unique.get(i))) + DFS(next, unique, freq, memo));
            memo.put(i, result);
            return result;
        }
    }

    //Working But Slow O(2^n)
    class Solution__ {
        public long maximumTotalDamage(int[] power) {
            Arrays.sort(power);
            return DFS(0, power, 0L, new HashMap<>());
        }

        private long DFS(int i, int[] power,long cantTakeMask, Map<String, Long> memo){
            if(i == power.length) return 0;

            String key = i + "|" + cantTakeMask;
            if(memo.containsKey(key)) return memo.get(key);

            long result = DFS(i+1, power, cantTakeMask, memo);
            if ((cantTakeMask >> power[i] & 1) != 1){
                long newMask = cantTakeMask;
                newMask |= (1L << (power[i] + 1));
                newMask |= (1L << (power[i] + 2));

                long b = power[i] + DFS(i+1, power, newMask, memo);
                result = Math.max(result, b);
            }

            memo.put(key, result);
            return memo.get(key);
        }
    }

    //Working But Slow O(2^n)
    class Solution_ {
        public long maximumTotalDamage(int[] power) {
            Arrays.sort(power);

            long sum = 0;
            return DFS(0, power, new HashSet<>(), sum);
        }

        private long DFS(int i, int[] power, Set<Integer> cantTake, long sum){
            if(i == power.length) return sum;
            if(cantTake.contains(power[i])) return DFS(i+1, power, cantTake, sum);

            else{
                long a = DFS(i+1, power, cantTake, sum);

                sum += power[i];
                Set<Integer> newCantTake = new HashSet<>(cantTake);
                newCantTake.add(power[i] + 1);
                newCantTake.add(power[i] + 2);
                long b = DFS(i+1, power, newCantTake, sum);

                return Math.max(a, b);
            }
        }
    }

}
